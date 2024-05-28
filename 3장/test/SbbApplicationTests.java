package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest //SbbApplicationTests 클래스가 스프링 부트의 테스트 클래스임을 의미
class SbbApplicationTests {

    @Autowired //@Autowired 애너테이션을 통해 스프링의 ‘의존성 주입(DI)’이라는 기능을 사용하여 QuestionRepository의 객체를 주입
    private QuestionRepository questionRepository;
    //@Autowired 애너테이션을 해당 변수에 적용하면 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입한다. 
    //테스트 코드 작성 시에만 @Autowired를 사용하고 실제 코드 작성 시에는 생성자를 통한 객체 주입 방식을 사용
    
    @Autowired
    private AnswerRepository answerRepository;
    
    //@Transactional // 테스트할때 메서드가 종료될 때까지 DB 세션이 유지 //데이터 생성할때 넣었더니 생성이 안되는 현상 있음
    @Test //testJpa 메서드가 테스트 메서드임을 나타낸다. 
    void testJpa() {      
//-------------데이터 입력
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
    	
//-------------데이터 개수와 데이터 내용 확인
//    	 List<Question> all = this.questionRepository.findAll();
//         assertEquals(2, all.size()); //assertEquals  : 테스트에서 예상한 결과와 실제 결과가 동일한지를 확인하는 목적으로 사용
//
//         Question q = all.get(0);
//         assertEquals("sbb가 무엇인가요?", q.getSubject());
    	
//-------------id값으로 데이터를 조회
//    	Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
    	
//-------------subject값으로 데이터를 조회  
//    	QuestionRepository 인터페이스 수정 후 진행
//    	Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); //findBy + 엔티티의 속성명
//        assertEquals(1, q.getId());
    	
//-------------subject와 content를 함께 조회
//    	Question q = this.questionRepository.findBySubjectAndContent( //findBy + 엔티티의 속성명 + and(다른 sql문 변경 가능 or 같은걸로) + 엔티티의 속성명
//                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());
    	
//-------------subject 열에서 특정 문자열을 포함하는 데이터를 찾기
//    	 List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
////		 sbb%	'sbb'로 시작하는 문자열
////    	 %sbb	'sbb'로 끝나는 문자열
////    	 %sbb%	'sbb'를 포함하는 문자열
//         Question q = qList.get(0);
//         assertEquals("sbb가 무엇인가요?", q.getSubject());
        
//-------------질문 엔티티의 데이터를 수정
//    	 Optional<Question> oq = this.questionRepository.findById(1);
//         assertTrue(oq.isPresent()); //assertTrue()는 괄호 안의 값이 true(참) 인지를 테스트
//         Question q = oq.get();
//         q.setSubject("수정된 제목");
//         this.questionRepository.save(q);
         
//-------------질문 데이터 삭제하기
//    	 assertEquals(2, this.questionRepository.count());
//         Optional<Question> oq = this.questionRepository.findById(1);
//         assertTrue(oq.isPresent());
//         Question q = oq.get();
//         this.questionRepository.delete(q);
//         assertEquals(1, this.questionRepository.count());
    	
//-------------답변 데이터 저장하기
//    	Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
//    	
//-------------답변데이터 조회하기
//    	 Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());
    	
//-------------질문 데이터를 통해 답변 데이터 찾기
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    	
    }
}