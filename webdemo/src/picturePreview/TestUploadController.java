package picturePreview;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploadMain")
public class TestUploadController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis=req.getRequestDispatcher("/picturePreview/insert.jsp");
		dis.forward(req, resp);
	}//end doGet()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//enctype이 multipart이면 req객체로 받아올수 없다.|| cos.jar파일을 이용
		MultipartRequest multi=null;
		
		//String saveDirectory="c:/temp/";
		//C:\Study\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webdemo\
		String root=req.getRealPath("/");                                                                
		//System.out.println(root);
		String saveDirectory =root+"temp";
		
		File file=new File(saveDirectory);
		if(!file.isDirectory())
			file.mkdir();
		int maxPostSize=1*1000*1000*1000; //1GB
		String encoding ="UTF-8";
		multi=new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		
		TestDAO dao=TestDAO.getInstance();
		dao.insertMethod(multi.getFilesystemName("filepath"));
		
		resp.sendRedirect("previewList");

	}//end doPost()
}//end class
