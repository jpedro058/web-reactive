package com.app.web_reactive.client;

import com.app.web_reactive.data.Media;

import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;

public class Client {
   public static void main(String[] args) throws IOException {
      String BASE_URL = "http://localhost:8080";
		String MY_URI = "/media";
		// para prjt String MY_URI = "with delay";
		WebClient.create(BASE_URL)
					.get()
					.uri(MY_URI)
					.retrieve()
					.bodyToFlux(Media.class)
					.subscribe(System.out::println);


		System.out.println("Press Enter to exit");
		System.in.read();
   }
}

// primeiro req
// falta aqui alguma cena para proteger a ligaçao, deve se dar retry 3 vezes e dps cagar
// flux.cena(https://...).map(m -> ""+m.getfile()+ " " + m.getRDHC()+"").subscribe(m -> writeFile())
