package part04_ajax_daum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//945948afbe6a4f41cd89e5fd9efe678e   다음 api키
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SearchDaumController {
	@RequestMapping("/daumForm.do")
	public String form(){ 
		return "part04_ajax_daum/daumForm";
	}//end form()
	
	/*@RequestMapping("/searchOpen.do")
	public ModelAndView process(String search) throws MalformedURLException, IOException{
		ModelAndView mav=new ModelAndView();
		String url="https://apis.daum.net/search/book?apikey=945948afbe6a4f41cd89e5fd9efe678e&q="+URLEncoder.encode(search,"UTF-8")+"&output=xml";
		HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String input=null;
		String total="";
		while((input=reader.readLine())!=null){
			total+=input;
		}
		
		mav.addObject("total",total);
		mav.setViewName("part04_ajax_daum/daumResult");
		return mav;
	}//end process()
*/
	
	@RequestMapping("/searchOpen.do")
	public @ResponseBody BookList process(String search) throws MalformedURLException, IOException, JAXBException{
		String url="https://apis.daum.net/search/book?apikey=945948afbe6a4f41cd89e5fd9efe678e&q="+URLEncoder.encode(search,"UTF-8")+"&output=xml";
		HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
		JAXBContext jaxbContext=null;
		BookList booklist =null;
		jaxbContext=jaxbContext.newInstance(BookList.class);
		booklist=(BookList)jaxbContext.createUnmarshaller().unmarshal(con.getInputStream());
		System.out.println("data:"+booklist.getBookItem().get(0).getTitle());
		return booklist;
	}
}//end class
