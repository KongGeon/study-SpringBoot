package com.mysite.sbb.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
//엔티티명을 User 대신 SiteUser로 한 이유는 스프링 시큐리티에 이미 User 클래스가 있기 때문

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)//unique = true는 유일한 값만 저장할 수 있음을 의미
    private String username;

    private String password;

    @Column(unique = true)//unique = true는 유일한 값만 저장할 수 있음을 의미
    private String email;
}