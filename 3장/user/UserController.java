package com.mysite.sbb.user;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.DataIntegrityViolationException;//중복 아이디 체크
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup") //GET으로 요청되면 회원 가입을 위한 템플릿을 렌더링
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup") //POST로 요청되면 회원 가입을 진행
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            //여기서 오류 코드는 임의로 passwordInCorrect로 정의했다. 하지만 대형 프로젝트에서는 번역과 관리를 위해 오류 코드를 잘 정의하여 사용해야 한다.
            return "signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(), 
                    userCreateForm.getEmail(), userCreateForm.getPassword1());
        }catch(DataIntegrityViolationException e) {
        	//사용자 ID 또는 이메일 주소가 이미 존재할 경우에는 DataIntegrityViolationException이라는 예외가 발생
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch(Exception e) {
        	//그 밖에 다른 예외들은 해당 예외에 관한 구체적인 오류 메시지를 출력하도록 e.getMessage()를 사용
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }
    
    //로그인
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}