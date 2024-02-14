package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	@GetMapping("/rkdmf")
	@ResponseBody
	public String index() {
		return "안녕!!!";
	}
	
	@GetMapping("/")
	public String rroot() {
		return "redirect:/inventory/list";
	}
	
}
