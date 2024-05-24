package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;//프리픽스

import org.springframework.web.bind.annotation.PostMapping;//질문등록 Post
import org.springframework.web.bind.annotation.RequestParam;//질문등록 Post

@RequestMapping("/question")//프리픽스
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
	
	   private final QuestionService questionService;
	  
	   @GetMapping("/list")
	  public String list(Model model) { //매개변수로 Model을 지정하면 객체가 자동으로 생성, 롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
		  List<Question> questionList = this.questionService.getList();
	        model.addAttribute("questionList", questionList);
	        return "question_list"; //템플릿 이름
	    }
	  
	   @GetMapping(value = "/detail/{id}") //상세페이지
	    public String detail(Model model, @PathVariable("id") Integer id) {
		  //@GetMapping(value = "/question/detail/{id}")에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 이와 같이 동일해야 한다. 
		  Question question = this.questionService.getQuestion(id);
	        model.addAttribute("question", question); 
		  return "question_detail";  //템플릿 이름
	    }
	   
	   @GetMapping("/create")//질문 등록
	   public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
	        // 질문을 저장한다.
	        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
	    }
	   
    
}