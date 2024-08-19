package test.com.member.controller;

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
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("Welcome insert!");
		
		return "member/insert";
	}
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update() {
		logger.info("Welcome update!");
		
		return "member/update";
	}
	
	@RequestMapping(value = "/m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		logger.info("Welcome delete!");
		
		return "member/delete";
	}
	
	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll() {
		logger.info("Welcome selectAll!");
		
		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne() {
		logger.info("Welcome selectOne!");
		
		return "member/selectOne";
	}
	
}//end class
