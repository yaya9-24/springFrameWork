package test.com.employees;

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
public class EmpRestController {
	
	@Autowired
	EmpService service;
	
	@ResponseBody
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<EmpVO> findAll(@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "0")int limit) {
		log.info("/findAll.do");
		
		List<EmpVO> list = service.findAll(page, limit);
		log.info("list.size():{}",list.size());
		
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findOne.do", method = RequestMethod.GET)
	public EmpVO findOne(EmpVO vo) {
		log.info("/findOne.do");
		
		EmpVO vo2 = service.findOne(vo);
		log.info("vo2:{}",vo2);
		
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList.do", method = RequestMethod.GET)
	public List<EmpVO> searchList(@RequestParam(defaultValue = "first_name")String searchKey,
			@RequestParam(defaultValue = "K")String searchWord,
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "0")int limit) {
		log.info("/searchList.do");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		List<EmpVO> list = service.searchList(searchKey,searchWord,page,limit);
		log.info("list.size():{}",list.size());
		
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> insertOneOK(EmpVO vo) {
		log.info("/insertOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.insertOne(vo);
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
			
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> updateOneOK(EmpVO vo) {
		log.info("/updateOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.updateOne(vo);
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
			
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> deleteOneOK(EmpVO vo) {
		log.info("/deleteOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.deleteOne(vo);
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
			
		return map;
	}
}
