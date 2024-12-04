package com.web.p1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class SurveyController {
	
	@Autowired
	private surveyRep srep;
	
	@GetMapping("/start")
	public String start() {
		return "start";
	}
	
	@GetMapping("/answer1")
	public String answer1(HttpSession se, @RequestParam("mid") String mid) {
		se.setAttribute("mid", mid);
		return "answer1";
	}
	
	@GetMapping("/answer2")
	public String answer2(HttpSession se, @RequestParam("genre") String genre) {
		se.setAttribute("genre", genre);
		return "answer2";
	}
	
	@GetMapping("/thanks")
	public String thanks(HttpSession se, @RequestParam("app") String app) {
		se.setAttribute("app", app);
		return "thanks";
	}
	
	@GetMapping("/result")
	public String result(HttpSession se, Model mo) {
		mo.addAttribute("mid",se.getAttribute("mid"));
		mo.addAttribute("genre",se.getAttribute("genre"));
		mo.addAttribute("app",se.getAttribute("app"));
		survey s = new survey();
		s.userid = (String)se.getAttribute("mid");
		s.genre = (String)se.getAttribute("genre");
		s.app = (String)se.getAttribute("app");
		srep.save(s);
		return "result";
	}
	
	@GetMapping("/surveyList")
	public String surveyList(Model mo) {
		mo.addAttribute("arr",srep.findAll());
		return "surveyList";
	}
	
	@GetMapping("/iam")
	public String iam() {
		return "iam";
	}
	
	@PostMapping("/food/report")
	public String iamAnswer(@RequestParam("age") String age , @RequestParam("gender") String gender,
			@RequestParam(value= "food", required = false) String[] food, @RequestParam("q1") String q1, @RequestParam("q2") String q2,
			@RequestParam("q3") String q3,@RequestParam("comments") String comments, Model mo) {
		
		var arr = new ArrayList<String>();
		if(food !=null) {
			for(String f: food ) {
				arr.add(f);
			}
		}
		
		
		mo.addAttribute("arr",arr);
		mo.addAttribute("age",age);
		mo.addAttribute("gender",gender);
		mo.addAttribute("q1",q1);
		mo.addAttribute("q2",q2);
		mo.addAttribute("q3",q3);
		mo.addAttribute("comments",comments);
		return "iamAnswer";
	}
	
	
}
