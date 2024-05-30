package com.mysite.sbb;
//스프링 시큐리티의 설정

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;// H2 콘솔의 화면이 프레임(frame) 구조 허락
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;//회원가입용
import org.springframework.security.crypto.password.PasswordEncoder;//회원가입용
import org.springframework.security.authentication.AuthenticationManager;//로그인용
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;//로그인용

@Configuration //스프링의 환경 설정 파일임을 의미하는 애너테이션
@EnableWebSecurity //모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
public class SecurityConfig {
    @Bean //빈(bean)은 스프링에 의해 생성 또는 관리되는 객체,  컨트롤러, 서비스, 리포지터리 등도 모두 빈에 해당
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())//다음은 인증되지 않은 모든 페이지의 요청을 허락한다는 의미이다.
            .csrf((csrf) -> csrf
                    .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))) //CSRF 처리 시 H2 콘솔은 예외로 처리
            .headers((headers) -> headers
                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))) // H2 콘솔의 화면이 프레임(frame) 구조 허락
            .formLogin((formLogin) -> formLogin //.formLogin 메서드는 스프링 시큐리티의 로그인 설정을 담당하는 부분
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/"))//user/login이고 로그인 성공 시에 이동할 페이지는 루트 URL(/)임을 의미
            .logout((logout) -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                    .logoutSuccessUrl("/")//로그아웃이 성공하면 루트(/) 페이지로 이동
                    .invalidateHttpSession(true))//.invalidateHttpSession(true)를 통해 로그아웃 시 생성된 사용자 세션도 삭제하도록 처리했다.
            ;
        return http.build();
    }
    
    //회원가입
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    //로그인
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        //AuthenticationManager는 스프링 시큐리티의 인증을 처리
    	//AuthenticationManager는 사용자 인증 시 앞에서 작성한 UserSecurityService와 PasswordEncoder를 내부적으로 사용하여 인증과 권한 부여 프로세스를 처리한다.
    	return authenticationConfiguration.getAuthenticationManager();
    }
    
    
    
}