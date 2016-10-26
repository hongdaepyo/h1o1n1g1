package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddrController {
	@RequestMapping("/addr.do")
	public String postForm(){
		return "address";
	}
}
