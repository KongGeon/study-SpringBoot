package com.mysite.sbb.question;
//리포지터리
//리포지터리는 생성된 데이터베이스 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스이다.
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;//인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속
//CRUD 작업을 처리하는 메서드들을 이미 내장하고 있어 데이터 관리 작업을 좀 더 편리하게 처리할 수 있다.


//public interface QuestionRepository extends JpaRepository<Question, Integer> { //JpaRepository<Question, Integer>는 Question 엔티티로 리포지터리를 생성한다는 의미이다. Question 엔티티의 기본키가 Integer임을 이와 같이 추가로 지정해야 한다.
//
//	
//}

//findBySubject 메서드를 사용하려면 다음과 같이 QuestionRepository 인터페이스를 변경해야 한다. 
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    
    Question findBySubjectAndContent(String subject, String content); //subject와 content를 함께 조회
    
    List<Question> findBySubjectLike(String subject); //subject 열에서 특정 문자열을 포함하는 데이터를 찾기
    
}