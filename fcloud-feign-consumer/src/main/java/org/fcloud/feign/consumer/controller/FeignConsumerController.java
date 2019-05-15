package org.fcloud.feign.consumer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.fcloud.api.service.dto.BookDTO;
import org.fcloud.feign.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController  {
    @Autowired
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
        book.setName("红楼梦");
        book.setPrice(44);
        book.setAuthor("曹雪芹");
        return helloService.hello(book);
    }
    
}