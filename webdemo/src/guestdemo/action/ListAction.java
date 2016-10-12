package guestdemo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class ListAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		BoardDAO dao=BoardDAO.getInstance();
		List<BoardDTO> aList=dao.listMethod();
		req.setAttribute("aList", aList);
		
	}//end execute()

}//end class
