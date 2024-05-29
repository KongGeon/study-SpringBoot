package com.mysite.sbb.question;
//서비스 만들기

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;//페이징
import org.springframework.data.domain.PageRequest;//페이징
import org.springframework.data.domain.Pageable;//페이징
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;//페이징 최신화 정렬 위해 설치
import java.util.List;//페이징 최신화 정렬 위해 설치
import org.springframework.data.domain.Sort;//페이징 최신화 정렬 위해 설치

@RequiredArgsConstructor
@Service//서비스 만들기
public class QuestionService {

    private final QuestionRepository questionRepository; // questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다

    public List<Question> getList() { 
        return this.questionRepository.findAll();//질문 목록 데이터를 조회하여 리턴
    }
    
    public Question getQuestion(Integer id) {  //id값으로 질문 데이터를 조회하기 위해 getQuestion 메서드를 추가
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content) {//질문생성
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    
    public Page<Question> getList(int page) {//질문페이징
    	List<Sort.Order> sorts = new ArrayList<>();//최신순 정렬
        sorts.add(Sort.Order.desc("createDate"));//최신순 정렬
        
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));//한번에 10개 노출, 최신순 정렬
        return this.questionRepository.findAll(pageable);
    }
}