package part04_ajax_daum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//945948afbe6a4f41cd89e5fd9efe678e   다음 api키
@Controller
public class SearchDaumController {
	@RequestMapping("/daumForm.do")
	public String form(){
		return "part04_ajax_daum/daumForm";
	}//end form()

}//end class
