package com.mysite.sbb.question;
//서비스 만들기

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;

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
}