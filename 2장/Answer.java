package com.mysite.sbb;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; //질문엔티티와 연결되었다는 걸 표시
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate; 

    @ManyToOne //질문엔티티와 연결되었다는 걸 표시
    //게시판 서비스에서는 하나의 질문에 답변은 여러 개가 달릴 수 있다. 따라서 답변은 Many(많은 것)가 되고 질문은 One(하나)이 된다. 즉, @ManyToOne 애너테이션을 사용하면 N:1 관계를 나타낼 수 있다. 
    //거꾸로라면 @OneToMany 애너테이션을 사용
    private Question question; 
}