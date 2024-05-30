package com.mysite.sbb.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {//SiteUser의 기본키 타입은 Long이므로 JpaRepository<SiteUser, Long>으로 사용
	Optional<SiteUser> findByusername(String username); //ID로 SiteUser 엔티티를 조회
}