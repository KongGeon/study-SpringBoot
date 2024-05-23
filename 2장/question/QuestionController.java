package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //@RequiredArgsConstructor 애너테이션의 생성자 방식으로 questionRepository 객체를 주입
@Controller
public class QuestionController {


	  
//    @GetMapping("/question/list")
//    @ResponseBody
//    public String list() {
//        return "question list";
//    }
    //탬플릿
//    @GetMapping("/question/list")
//    @ResponseBody
//    public String list() {
//        return "question_list";
//    }
	
	  private final QuestionRepository questionRepository;
	  
	  @GetMapping("/question/list")
	  public String list(Model model) { //매개변수로 Model을 지정하면 객체가 자동으로 생성, 롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
	        List<Question> questionList = this.questionRepository.findAll();
	        model.addAttribute("questionList", questionList);
	        return "question_list";
	    }
    
}