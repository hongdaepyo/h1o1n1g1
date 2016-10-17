package part05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemInsertController {
	private MemDao dao;
	
	public void setDao(MemDao dao){
		this.dao=dao;
	}

	@RequestMapping(value="/memInsert.htm", method=RequestMethod.GET)
	public String form(){
		return "view/part05/memForm";
	}//end form()
	
	@RequestMapping(value="/memInsert.htm", method=RequestMethod.POST)
	public String process(MemDTO dto){
		dao.insertMethod(dto);
		return "redirect:/memList.htm";
	}
}//end class
