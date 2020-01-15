package com.github.tnessn.fcloud.api.service.a;


import com.github.tnessn.fcloud.api.service.b.BookDTO;

public interface HelloService{
    String hello(String name);
    BookDTO hello(String name, String author,Integer price) ;
    String hello(BookDTO book);
}