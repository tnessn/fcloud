package org.fcloud.provider.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.fcloud.api.service.HelloService;
import org.fcloud.api.service.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl  implements HelloService{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String hello(String name) {
        return "hello " + name + "!";
    }

    @Override
    public BookDTO hello(String name, String author, Integer price){
        BookDTO book = null;
		try {
			book = new BookDTO();
			book.setName(URLDecoder.decode(name,"UTF-8"));
			book.setAuthor(URLDecoder.decode(author,"UTF-8"));
			book.setPrice(price);
			System.out.println(book);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return book;
    }

    @Override
    public String hello(BookDTO book) {
        return "书名为：" + book.getName() + ";作者为：" + book.getAuthor();
    }
}