package view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import dao.BoardDao;

public class BoardDownLoadView extends AbstractView{
	private BoardDao dao;
	
	public BoardDownLoadView() {
		
	}
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int num=Integer.parseInt(request.getParameter("rno"));
		String root=request.getSession().getServletContext().getRealPath("/");
		String saveDirectory=root+"temp"+File.separator;
		
		String upload=dao.getFile(num);
		String fileName=upload.substring(upload.indexOf("_")+1);
		
		String str=URLEncoder.encode(fileName,"UTF-8");
		
		response.setContentType("application/octet-stream");
		
		response.setHeader("Content-Disposition", "attachment;filename="+str+";");
		
		FileCopyUtils.copy(new FileInputStream(new File(saveDirectory,upload)), response.getOutputStream());
		
		
	}

}
