package test.com.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class MemberRestController {

	@Autowired
	MemberService service;
	
	@ResponseBody
	@RequestMapping(value = "/api/m_idCheck.do", method = RequestMethod.GET)
	public Map<String,String> m_idCheck(MemberVO vo){
		log.info("m_idCheck");
		
		Map<String,String> map = new HashMap<String, String>();
		MemberVO vo2 = service.idCheck(vo);
		
		if(vo2==null) {
			map.put("result", "OK");
		} else {
			map.put("result", "Not OK");
		}
		
		
		return map;
	}
}
