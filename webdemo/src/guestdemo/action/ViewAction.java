package guestdemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		BoardDAO dao=BoardDAO.getInstance();
		int num=Integer.parseInt(req.getParameter("num"));
		dao.readCountMethod(num);
		BoardDTO aList=dao.viewMethod(num);
		req.setAttribute("dto", aList);
	}//end execute()

}//end class
