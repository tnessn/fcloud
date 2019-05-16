package org.fcloud.consumer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.dubbo.config.annotation.Reference;
import org.fcloud.api.service.HelloService;
import org.fcloud.api.service.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController  {
	@Reference
    private HelloService helloService;

    
    
    @RequestMapping("/hello1")
    public String hello1() {
        return helloService.hello("张三");
    }

    @RequestMapping(value = "/hello2")
    public BookDTO hello2() throws UnsupportedEncodingException {
        BookDTO book = helloService.hello(URLEncoder.encode("三国演义","UTF-8"), URLEncoder.encode("罗贯中","UTF-8"), 33);
        System.out.println(book);
        return book;
    }

    @RequestMapping("/hello3")
    public String hello3() {
        BookDTO book = new BookDTO();
        book.setName("xxxx");
        book.setPrice(44);
        book.setAuthor("tttttt");
        return helloService.hello(book);
    }
    
}