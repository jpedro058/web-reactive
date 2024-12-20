package com.app.web_reactive.data;

import java.io.Serializable;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("media")
public class Media implements Serializable {
   long id;
   String title;
   String release_date;
   float average_rating;
   boolean type;
}
