package test.com.tileslayout;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return ".home";
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String test() {
		logger.info("/test.do");
		
		
		
		return ".test/test";
	}
	
	@RequestMapping(value = "/test2.do", method = RequestMethod.GET)
	public String test2() {
		logger.info("/test2.do");
		
		
		
		return ".test/test2";
	}
	
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		logger.info("/b_insert.do");
		
		
		
		return ".board/insert";
	}
	
	@RequestMapping(value = "/b_select.do", method = RequestMethod.GET)
	public String b_select() {
		logger.info("/b_select.do");
		
		
		
		return ".board/select";
	}
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("/m_insert.do");
		
		
		
		return ".member/insert";
	}
	@RequestMapping(value = "/m_select.do", method = RequestMethod.GET)
	public String m_select() {
		logger.info("/m_select.do");
		
		
		
		return ".member/select";
	}
	
	//mission
	//spring17fileUpload_member를 이용해서 기존기능 그대로 구현하시고
	//spring19tiles 처럼 타일즈 기능을 추가한 프로젝트를 구현하세요.
	//프로젝트명 : spring20tiles_member
	
}
