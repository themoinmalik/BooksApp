package com.demo.security.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {

    private String author;
    private String name;
}
