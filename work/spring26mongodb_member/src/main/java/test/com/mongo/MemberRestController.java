package test.com.mongo;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberRestController {
	
	@Autowired
	MemberService service;

	@ResponseBody
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<MemberVO> findAll() {
		log.info("/findAll.do");
		
		List<MemberVO> list = service.findAll();
		log.info("list.size():{}",list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList.do", method = RequestMethod.GET)
	public List<MemberVO> searchList(@RequestParam(defaultValue = "name")String searchKey,
			@RequestParam(defaultValue = "ki")String searchWord) {
		log.info("/searchList.do");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<MemberVO> list = service.searchList(searchKey,searchWord);
		log.info("list.size():{}",list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findOne.do", method = RequestMethod.GET)
	public MemberVO findOne(MemberVO vo) {
		log.info("/findOne.do");
		
		MemberVO vo2 = service.findOne(vo);
		log.info("vo2:{}",vo2);
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> insertOneOK(MemberVO vo) {
		log.info("/insertOneOK.do");
		
		long result = service.insertOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> updateOneOK(MemberVO vo) {
		log.info("/updateOneOK.do");
		
		long result = service.updateOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> deleteOneOK(MemberVO vo) {
		log.info("/deleteOneOK.do");
		
		long result = service.deleteOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
}
