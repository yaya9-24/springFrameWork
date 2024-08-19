package test.com.hello.controller;

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
		
		logger.info("formattedDate {}.", formattedDate);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}//end home
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert");
		
		String user_name = "kim";
		
		logger.info("user_name : {}", user_name);
		
		return "test/insert";
	}//end insert
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update() {
		logger.info("Welcome update");
		
		return "test/update";
	}//end update
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete() {
		logger.info("Welcome delete");
		
		return "test/delete";
	}//end delete
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll() {
		logger.info("Welcome selectAll");
		
		return "test/selectAll";
	}//end selectAll
	
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne() {
		logger.info("Welcome selectOne");
		
		return "test/selectOne";
	}//end insert
	
	//mission....01
	//spring02member
	//test.com.member >> HomeController
	//test.com.member.controller >> MemberController
	//controller >> servlet Path(/,/home.do,/m_insert.do,/m_update.do,,,,,)
	//views/member/insert.jsp,update.jsp.,,,,
	//views/home.jsp
	//views/top_menu.jsp
	
	//mission....02
	//spring03board
	//test.com.board >> HomeController
	//test.com.board.controller >> BoardController
	//controller >> servlet Path(/,/home.do,/b_insert.do,/b_update.do,,,,,)
	//views/board/insert.jsp,update.jsp.,,,,
	//views/home.jsp
	//views/top_menu.jsp
	
}//end class
