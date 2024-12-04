package com.web.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class myController {
	
	@Autowired
	private diaryRep drep;

	@GetMapping("/diary")
	public String diary() {
		return "diary";
	}
	

	@GetMapping("/diaryPop")
	public String diaryPop() {
		return "diaryPop";
	}
	
	@GetMapping("/diaryList")
	public String diaryList(Model mo) {
		mo.addAttribute("arr",drep.findAll());
		return "diaryList";
	}
	
	@GetMapping("/diary/insert")
    public String diaryInsert(@RequestParam("je") String je, @RequestParam("nae") String nae) {
        diary m = new diary();
        m.je = je;
        m.nae = nae;
        drep.save(m);
        return "redirect:/diaryPop";
    }
}
