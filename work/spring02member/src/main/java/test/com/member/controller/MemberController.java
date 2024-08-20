package test.com.member.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;

	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("Welcome insert!");

		return "member/insert";
	}

	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo) {
		logger.info("Welcome update!");
		logger.info("{}",vo);
//		MemberVO vo = new MemberVO();
//		vo.setNum(num);

		MemberVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}", vo2);

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

		List<MemberVO> list = service.selectAll();
		logger.info("{}", list);
		return "member/selectAll";
	}

	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(String searchKey,String searchWord) {
		logger.info("Welcome searchList!");

		List<MemberVO> list = service.searchList(searchKey, searchWord);
		logger.info("{}", list);
		return "member/selectAll";
	}

	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo) {
		logger.info("Welcome selectOne!");
		logger.info("{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}", vo2);

		return "member/selectOne";
	}

	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.GET)
	public String m_insertOK(MemberVO vo) {
		logger.info("Welcome insertOK!");
		logger.info("{}",vo);
		
		int result = service.insert(vo);
		logger.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.GET)
	public String m_updateOK(MemberVO vo) {
		logger.info("Welcome updateOK!");
		logger.info("{}",vo);
		
		int result = service.update(vo);
		logger.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.GET)
	public String m_deleteOK(MemberVO vo) {
		logger.info("Welcome deleteOK!");
		logger.info("{}",vo);
		
		int result = service.delete(vo);
		logger.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	// spring03board프로젝트도 지금과 똑같이 동작하도록 컴포넌트 추가해주세요.

}// end class
