package com.mysite.sbb;

import java.time.LocalDateTime; 
import java.util.List; 

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.OneToMany; 

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //엔티티로 만들기 위한 애너테이션
public class Question {
    @Id //기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //데이터를 저장할 때 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장된다.
    //strategy = GenerationType.IDENTITY는 고유한 번호를 생성하는 방법을 지정하는 부분으로, GenerationType.IDENTITY는 해당 속성만 별도로 번호가 차례대로 늘어나도록 할 때 사용한다.
    private Integer id; //고유 번호

    //세부 설정을 위해 @Column 애너테이션을 사용
    @Column(length = 200) //열의 길이를 200
    private String subject; //제목

    //세부 설정을 위해 @Column 애너테이션을 사용
    @Column(columnDefinition = "TEXT") //‘텍스트’를 열 데이터로 넣을 수 있음을 의미
    private String content; //내용

    private LocalDateTime createDate; //작성 일시
    //테이블에서는 create_date라는 열 이름으로 설정된다. 
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)  //다대일 관계
    private List<Answer> answerList; 
    
    //tip.엔티티를 만들 때 Setter 메서드는 사용하지 않는다 : 엔티티는 데이터베이스와 바로 연결되므로 데이터를 자유롭게 변경할 수 있는 Setter 메서드를 허용하는 것이 안전하지 않다고 판단
}