package guestdemo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class WriteAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		MultipartRequest multi=null;
		String saveDirectory=req.getRealPath("/");
		File file=new File(saveDirectory+"/temp");
		if(!file.exists())
			file.mkdirs();
		saveDirectory+="/temp/";
		
		int maxPostSize=1000000000; //1GB
		String encoding="UTF-8";
		
		try {
			multi=new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardDTO dto=new BoardDTO();
		dto.setWriter(multi.getParameter("writer"));
		dto.setEmail(multi.getParameter("email"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("Content"));
		dto.setUpload(multi.getFilesystemName("upload"));
		BoardDAO dao=BoardDAO.getInstance();
		dao.insertMethod(dto);
		
		
	}//end execute()

}//end class
