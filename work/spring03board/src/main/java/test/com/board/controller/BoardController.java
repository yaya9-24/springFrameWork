package test.com.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		logger.info("Welcome b_insert");
		
		
		return "board/insert";
	}
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update() {
		logger.info("Welcome b_update");
		
		
		return "board/update";
	}
	
	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		logger.info("Welcome b_delete");
		
		
		return "board/delete";
	}
	
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll() {
		logger.info("Welcome b_selectAll");
		
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne() {
		logger.info("Welcome b_selectOne");
		
		
		return "board/selectOne";
	}
	
	
}//end class
