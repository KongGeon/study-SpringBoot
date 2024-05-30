package com.mysite.sbb.user;
//권한 부여

import lombok.Getter;


@Getter //ADMIN과 USER 상수는 값을 변경할 필요가 없으므로 @Setter 없이 @Getter만 사용할 수 있도록 했다.
public enum UserRole {//UserRole은 enum 자료형(열거 자료형)으로 작성
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}