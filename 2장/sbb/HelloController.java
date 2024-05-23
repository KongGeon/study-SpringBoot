package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello") //Get 방식의 URL 요청, Post 방식이면 @PostMapping
    @ResponseBody // hello 메서드의 출력 결과가 문자열 그 자체임을 나타낸다.
    public String hello() {
        return "Hello Wsdasdasdorld";
    }
}
