package com.app.web_reactive.data;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Media implements Serializable {
   String id;
   String title;
}
