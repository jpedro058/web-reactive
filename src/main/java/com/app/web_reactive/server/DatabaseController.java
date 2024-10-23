package com.app.web_reactive.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/db")
public class DatabaseController {

    @Autowired
    private DatabaseClient databaseClient;

    @GetMapping("/tables")
    public Flux<Map<String, Object>> getAllTables() {
        String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        return databaseClient.sql(sql)
                .fetch()
                .all();
    }

    @GetMapping("/content")
    public Mono<Map<String, List<Map<String, Object>>>> getAllTablesContent() {
        return getAllTables()
                .flatMap(table -> {
                    String tableName = (String) table.get("table_name");
                    return databaseClient.sql("SELECT * FROM " + tableName)
                            .fetch()
                            .all()
                            .collectList()
                            .map(content -> Map.of(tableName, content));
                })
                .collectList()
                .map(list -> list.stream()
                        .flatMap(map -> map.entrySet().stream())
                        .collect(java.util.stream.Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> v1
                        )));
    }
}
