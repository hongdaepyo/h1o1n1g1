package guestdemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.action.ListAction;
import guestdemo.action.ViewAction;
import guestdemo.action.WriteAction;

//http://localhost:8090/webdemo/board/*

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}// end doGet()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}// end doPost()

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		// /webdemo/board/writeForm.do
		// /webdemo/board/*
		String action = uri.substring(uri.lastIndexOf("/"));
		String path="";
		
		System.out.println(uri);
		if (action.equals("/*")|| action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			path="/guestview/list.jsp";
		}else if(action.equals("/writeForm.do")){
			path="/guestview/write.jsp";
		}else if(action.equals("/view.do")){
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path="/guestview/view.jsp";
		}else if(action.equals("/write.do")){
			WriteAction write=new WriteAction();
			write.execute(req, resp);
			resp.sendRedirect("list.do");
		}
		if(path!=""){
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
		}
	}// end process()

}// end class
