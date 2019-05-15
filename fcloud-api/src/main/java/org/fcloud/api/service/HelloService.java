package org.fcloud.api.service;


import org.fcloud.api.service.dto.BookDTO;

public interface HelloService{
    String hello(String name);
    BookDTO hello(String name, String author,Integer price) ;
    String hello(BookDTO book);
}