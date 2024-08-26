package test.com.restapi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestRestController {
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test.do", method = RequestMethod.GET)
	public String json_test() {
		log.info("/json_test.do");
		
		//{"result":"OK"}
		
		return "{\"result\":\"OK\"}";
	}
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test2.do", method = RequestMethod.GET)
	public Map<String, String> json_test2() {
		log.info("/json_test2.do");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "Not OK");
		
		return map;
	}
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test3.do", method = RequestMethod.GET)
	public TestVO json_test3() {
		log.info("/json_test3.do");
		
		TestVO vo= new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		
		return vo;
	}
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test4.do", method = RequestMethod.GET)
	public List<TestVO> json_test4() {
		log.info("/json_test4.do");
		
		List<TestVO> list = new ArrayList<TestVO>();
		for (int i = 1; i < 4; i++) {
			TestVO vo= new TestVO();
			vo.setName("kim"+i);
			vo.setAge(33+i);
			list.add(vo);
		}
		
		
		return list;
	}
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test5.do", method = RequestMethod.GET)
	public Map<String, TestVO> json_test5() {
		log.info("/json_test5.do");
		
		Map<String,TestVO> map = new HashMap<String, TestVO>();
		TestVO vo= new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		map.put("vo", vo);
		
		
		return map;
	}
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_test6.do", method = RequestMethod.GET)
	public Map<String, List<TestVO>> json_test6() {
		log.info("/json_test6.do");
		
		Map<String,List<TestVO>> map = new HashMap<String, List<TestVO>>();
		
		List<TestVO> list = new ArrayList<TestVO>();
		for (int i = 1; i < 4; i++) {
			TestVO vo= new TestVO();
			vo.setName("kim"+i);
			vo.setAge(33+i);
			list.add(vo);
		}
		
		List<TestVO> list2 = new ArrayList<TestVO>();
		for (int i = 10; i < 14; i++) {
			TestVO vo= new TestVO();
			vo.setName("kim"+i);
			vo.setAge(33+i);
			list2.add(vo);
		}
		map.put("list", list);
		map.put("list2", list2);
		
		
		return map;
	}
	
	//http://localhost:8088/restapi/api/json_idCheck.do?id=admin
	//admin 일때는 {"result":"Not OK"}
	//admin이 아닐때는 {"result":"OK"} 출력되도록 구현하기.
	
	@ResponseBody //RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_idCheck.do", method = RequestMethod.GET)
	public Map<String, String> json_idCheck(
			@RequestParam(defaultValue = "admin") String id) {
		log.info("/json_idCheck.do....{}",id);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(id.equals("admin")) {
			log.info("중복입니다.");
			map.put("result", "Not OK");
		}else {
			log.info("사용가능");
			map.put("result", "OK");
		}		
		return map;
	}
	
	//spring17fileUpload_member 프로젝트에 아이디 체크 기능을 추가하세요.
	
	
}//end class
