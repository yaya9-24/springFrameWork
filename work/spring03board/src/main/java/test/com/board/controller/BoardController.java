package test.com.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.board.model.BoardVO;
import test.com.board.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		logger.info("Welcome insert");
		
		
		return "board/insert";
	}
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update() {
		logger.info("Welcome update");
		
		BoardVO vo = new BoardVO();
		vo.setNum(11);
		
		BoardVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}",vo2);
		
		return "board/update";
	}
	
	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		logger.info("Welcome delete");
		
		
		return "board/delete";
	}
	
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll() {
		logger.info("Welcome selectAll");
		
		List<BoardVO> list = service.selectAll();
		logger.info("{}",list);
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne() {
		logger.info("Welcome selectOne");
		
		BoardVO vo = new BoardVO();
		vo.setNum(11);
		
		BoardVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}",vo2);
		
		return "board/selectOne";
	}
	
	@RequestMapping(value = "/b_searchList.do", method = RequestMethod.GET)
	public String b_searchList() {
		logger.info("Welcome searchList");
		String searchKey = "title";
		String searchWord = "ja";
		
		List<BoardVO> list = service.searchList(searchKey,searchWord);
		logger.info("{}",list);
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.GET)
	public String b_insertOK() {
		logger.info("Welcome insertOK");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("spring");
		vo.setContent("hello");
		vo.setWriter("admin");
		vo.setWdate(new Date(System.currentTimeMillis()));
		
		int result = service.insert(vo);
		logger.info("result:{}",result);
		
		return "redirect:b_selectAll.do";
	}
	
	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.GET)
	public String b_updateOK() {
		logger.info("Welcome updateOK");
		
		BoardVO vo = new BoardVO();
		vo.setNum(11);
		vo.setTitle("title11");
		vo.setContent("content11");
		vo.setWriter("kim11");
		vo.setWdate(new Date(System.currentTimeMillis()));
		
		int result = service.update(vo);
		logger.info("result:{}",result);
		
		return "redirect:b_selectOne.do?num=33";
	}
	
	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.GET)
	public String b_deleteOK() {
		logger.info("Welcome deleteOK");
		
		BoardVO vo = new BoardVO();
		vo.setNum(11);
		
		int result = service.insert(vo);
		logger.info("result:{}",result);
		
		return "redirect:b_selectAll.do";
	}
}//end class
