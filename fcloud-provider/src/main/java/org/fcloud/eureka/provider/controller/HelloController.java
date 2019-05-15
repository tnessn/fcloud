package org.fcloud.eureka.provider.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.fcloud.api.HelloApi;
import org.fcloud.api.service.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController  implements HelloApi{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String hello(String name) {
        return "hello " + name + "!";
    }

    @Override
    public BookDTO hello(String name, String author, Integer price) throws UnsupportedEncodingException {
        BookDTO book = new BookDTO();
        book.setName(URLDecoder.decode(name,"UTF-8"));
        book.setAuthor(URLDecoder.decode(author,"UTF-8"));
        book.setPrice(price);
        System.out.println(book);
        return book;
    }

    @Override
    public String hello(BookDTO book) {
        return "书名为：" + book.getName() + ";作者为：" + book.getAuthor();
    }
}