package com.web.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController{ // 소스명, 클래스명 대소문자 까지 완벽 동일
	
	//여기 코딩할건데 
	//여기 말고 엄청나게 중요하게 신경써야 하는 부분은 컨트롤러 선언.이걸 해줘야 고객응대 가능!
	//이 안에 메소드들을 코딩합니다. 화면1개에 메소드1개
	//public String 메소드이름() {  
	//   return "";  
	//}
	
	@GetMapping("/") // 고객님이 사이트주소만 넣고 더이상 세부주소 안치시면 (홈피첫화면)
	public String home() {  // 메소드명 자유. 대부분은 화면이름이랑 주소랑 동일하게 하는 경향
		return "home";   // 화면 내보내는 한 줄
		
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}
	
	
	@PostMapping("/ex01result") //ex01.html 5번 라인과 정확히 일치
	public String ex01Answer(@RequestParam(name="mid") String mid, @RequestParam(name="pw") String pw, Model mo) {
		mo.addAttribute("pw", pw);
		mo.addAttribute("mid", mid);
		return "ex01Answer";
	}
	
	@GetMapping("/ex02")
	public String ex02() {
		return "ex02";
	}
	
	@GetMapping("/ex02/answer") 
	public String ex02Answer(@RequestParam("mname") String mname, @RequestParam("po") String po, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("po", po);
		int salary = 0;
		switch(po) {
			case "사원" -> salary = 3500; // 자바 switch 문
			case "대리" -> salary = 5000;
			case "팀장" -> salary = 7000;
			case "임원" -> salary = 9900;
		}
		mo.addAttribute("salary", salary);
		return "ex02Answer";
	}

	@GetMapping("/ex03")
	public String ex03() {
		return "ex03";
	}
	
	
	@PostMapping("/ex03/answer") 
	public String ex03Answer(@RequestParam("mname") String mname, @RequestParam("color") String color, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("color", color);
		return "ex03Answer";
	}
	
	@GetMapping("/wise")
	public String wise() {
		return "wise";
	}
	
	@PostMapping("/wise/answer") 
	public String wiseAnswer(@RequestParam("mname") String mname, @RequestParam("contect") String contect, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("contect", contect);
		return "wiseAnswer";
	}
	
	@GetMapping("/bread")
	public String bread() {
		return "bread";
	}
	
	@PostMapping("/bread/answer") 
	public String breadAnswer(@RequestParam("mname") String mname, @RequestParam("price") Integer price, @RequestParam("num") Integer num, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("price", price);
		mo.addAttribute("num", num);
		int sum = 0;
		sum = price*num;
		mo.addAttribute("sum", sum);
		return "breadAnswer";
	}
	
	@GetMapping("/q06")
	public String q06() {
		return "q06";
	}
	
	@GetMapping("/q06/a")
	public String q06a() {
		return "q06a";
	}
	
	@GetMapping("/q06/b")
	public String q06b() {
		return "q06b";
	}
	
	@PostMapping("/q06/aa") 
	public String q06aa(@RequestParam("mname1") String mname1, @RequestParam("mname2") String mname2, Model mo) {
		mo.addAttribute("mname1", mname1);
		mo.addAttribute("mname2", mname2);
		return "q06aa";
	}
	
	@PostMapping("/q06/bb") 
	public String q06bb(@RequestParam("category") String category, Model mo) {
		mo.addAttribute("category", category);
		return "q06bb";
	}
	
	@GetMapping("/ex04")
	public String ex04Answer(Model mo) {
		var arr = new ArrayList<String>();
		arr.add("고흐");
		arr.add("james");
		arr.add("dooli");
		arr.add("bread");
		
		mo.addAttribute("arr", arr);
		
		return "ex04";
		
	}

} // class