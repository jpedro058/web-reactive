package com.app.web_reactive.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {
   
   @GetMapping()
   private String Hello() {
      return "projeto bacanz";
   }
}
