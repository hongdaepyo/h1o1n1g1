package part03_search;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpSearchController {
	private EmpDao dao;
	
	@RequestMapping("/search.do")
	public String searchForm(){
		return "part03_search/searchForm";
	}//end searchForm()
	
	public void setDao(EmpDao dao){
		this.dao=dao;
	}
	
	@RequestMapping("/process.do")
	//@ResponseBody 결과값을 json으로 리턴해주겠다.
	public @ResponseBody List<EmployeeDTO> searchProcess(String data){
		return dao.search(data);
	}
	
}//end class
