package org.fcloud.eureka.provider.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.fcloud.api.service.IHelloService;
import org.fcloud.api.service.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController  implements IHelloService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }

    @Override
    public Book hello(@RequestHeader String name, @RequestHeader String author, @RequestHeader Integer price) throws UnsupportedEncodingException {
        Book book = new Book();
        book.setName(URLDecoder.decode(name,"UTF-8"));
        book.setAuthor(URLDecoder.decode(author,"UTF-8"));
        book.setPrice(price);
        System.out.println(book);
        return book;
    }

    @Override
    public String hello(@RequestBody Book book) {
        return "书名为：" + book.getName() + ";作者为：" + book.getAuthor();
    }
}