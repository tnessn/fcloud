package org.fcloud.api.service;

import java.io.UnsupportedEncodingException;

import org.fcloud.api.service.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/hs2")
public interface IHelloService {
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    BookDTO hello(@RequestHeader("name") String name, @RequestHeader("author") String author, @RequestHeader("price") Integer price) throws UnsupportedEncodingException;

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody BookDTO book);
}