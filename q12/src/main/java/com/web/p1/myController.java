package com.web.p1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class myController {
	
	@Autowired
	private boardgameRep brep;
	@Autowired
	private worldcupRep wrep;
	
	@GetMapping("/boardgameList")
	public String boardgameList(Model mo) {
		List<boardgame> arr = brep.findAll();
		mo.addAttribute("arr",arr);
		
		return "boardgameList";
	}
	
	
	@GetMapping("/worldcup1")
	public String worldcup1() {
		return "worldcup1";
	}
	
	@GetMapping("/worldcup2")
	public String worldcup2(@RequestParam("animal1") String animal1, HttpSession se) {
		se.setAttribute("animal1", animal1);
		return "worldcup2";
	}
	
	@GetMapping("/worldcup3")
	public String worldcup3(@RequestParam("animal2") String animal2, HttpSession se, Model mo) {
		mo.addAttribute("animal1", se.getAttribute("animal1"));
		mo.addAttribute("animal2", animal2);
		se.removeAttribute("animal1");
		return "worldcup3";
	}
	
	@PostMapping("/winner")
	public String winner(@RequestParam("win") String win,  Model mo) {
		wrep.increaseFcount(win);
		mo.addAttribute("win", win);
		return "winner";
	}
	
	@GetMapping("/worldcup/list")
	public String worldcupList(Model mo) {
//		List<worldcup> arr = wrep.findAll(); 2줄로 할때는 이렇게
		mo.addAttribute("arr",wrep.findAll());
		return "worldcupList";
	}
	
}


