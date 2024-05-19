package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //@Controller 애너테이션을 적용하면 MainController 클래스는 스프링 부트의 컨트롤러가 된다.
public class MainController {
	 @GetMapping("/sbb") //@GetMapping 애너테이션은 요청된 URL(/sbb)과의 매핑을 담당한다.
	 @ResponseBody //@ResponseBody 애너테이션은 URL 요청에 대한 응답으로 문자열을 리턴하라는 의미로 쓰였다.
	    public String index() {
	        return "안녕하세요 sbb에 오신 것을 환영합니다.";
	    }
	

}
