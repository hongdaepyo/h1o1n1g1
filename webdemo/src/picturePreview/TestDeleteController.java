package picturePreview;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testDel")
public class TestDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestDAO dao = TestDAO.getInstance();
		String chk[]=req.getParameterValues("chk");
		String root=req.getRealPath("/");
		for(int i=0; i<chk.length; i++){
			int num=Integer.parseInt(chk[i]);
			File file=new File(root+"/temp/"+dao.imgMethod(num));
			file.delete();
		}
		
		dao.deleteMethod(chk);
		resp.sendRedirect("previewList");
				
	}//end doGet();
	
}//end class
