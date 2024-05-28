package com.mysite.sbb;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

//이와 같이 hello, lombok 속성에 final을 추가하고 @RequiredArgsConstructor 애너테이션을 적용하면 해당 속성(hello와 lombok)을 필요로 하는 생성자가 롬복에 의해 자동으로 생성된다. 
@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
	 private final String hello; 
	    private final int lombok; 

	    public static void main(String[] args) { 
	        HelloLombok helloLombok = new HelloLombok("헬로", 5); 
	        System.out.println(helloLombok.getHello()); 
	        System.out.println(helloLombok.getLombok()); 
	    } 
}
