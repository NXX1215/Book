package com.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private Double price;
    private String publish_date;
    private Integer status;
}
