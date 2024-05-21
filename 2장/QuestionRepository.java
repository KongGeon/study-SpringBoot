package com.mysite.sbb;
//리포지터리
//리포지터리는 생성된 데이터베이스 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스이다.

import org.springframework.data.jpa.repository.JpaRepository;//인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속
//CRUD 작업을 처리하는 메서드들을 이미 내장하고 있어 데이터 관리 작업을 좀 더 편리하게 처리할 수 있다.


public interface QuestionRepository extends JpaRepository<Question, Integer> { //JpaRepository<Question, Integer>는 Question 엔티티로 리포지터리를 생성한다는 의미이다. Question 엔티티의 기본키가 Integer임을 이와 같이 추가로 지정해야 한다.

	
}