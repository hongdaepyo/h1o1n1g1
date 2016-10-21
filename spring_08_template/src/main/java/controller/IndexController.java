package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String process(){
		return "index";  //이곳의 index = tiles.xml의 definition name과 같다.
	}
}
