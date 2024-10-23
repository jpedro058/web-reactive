package com.app.web_reactive.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web_reactive.data.Media;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/media")
public class MediaController {

   @GetMapping()
   private Flux<Media> getAllMedia() {
      return Flux.just(
         /* new Media(1, "The GodFather"),
         new Media(2, "yaaaaaaaaa") */
      );
   }

}
