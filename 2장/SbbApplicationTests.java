package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest //SbbApplicationTests 클래스가 스프링 부트의 테스트 클래스임을 의미
class SbbApplicationTests {

    @Autowired //@Autowired 애너테이션을 통해 스프링의 ‘의존성 주입(DI)’이라는 기능을 사용하여 QuestionRepository의 객체를 주입
    private QuestionRepository questionRepository;
    //@Autowired 애너테이션을 해당 변수에 적용하면 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입한다. 
    //테스트 코드 작성 시에만 @Autowired를 사용하고 실제 코드 작성 시에는 생성자를 통한 객체 주입 방식을 사용
    
    @Test //testJpa 메서드가 테스트 메서드임을 나타낸다. 
    void testJpa() {        
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
    	
    	 List<Question> all = this.questionRepository.findAll();
         assertEquals(2, all.size()); //assertEquals  : 테스트에서 예상한 결과와 실제 결과가 동일한지를 확인하는 목적으로 사용

         Question q = all.get(0);
         assertEquals("sbb가 무엇인가요?", q.getSubject());
    }
}