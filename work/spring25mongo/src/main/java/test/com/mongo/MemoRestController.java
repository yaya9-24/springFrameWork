package test.com.mongo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemoRestController {
	
	@Autowired
	MemoService service;
	
	@ResponseBody
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<MemoVO> findAll() {
		log.info("/findAll.do");
		
		List<MemoVO> list = service.findAll();
		log.info("list.size():{}",list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList.do", method = RequestMethod.GET)
	public List<MemoVO> searchList(@RequestParam(defaultValue = "name")String searchKey,
			@RequestParam(defaultValue = "n")String searchWord) {
		log.info("/searchList.do");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<MemoVO> list = service.searchList(searchKey,searchWord);
		log.info("list.size():{}",list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findOne.do", method = RequestMethod.GET)
	public MemoVO findOne(MemoVO vo) {
		log.info("/findOne.do");
		log.info("vo:{}",vo);
		
		MemoVO vo2 = service.findOne(vo);
		log.info("vo2:{}",vo2);
		
		return vo2;
	}
	
	//insertOneOK.do?age=101&name=kim1&office=multi&phone=0201
	//{"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/insertOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> insertOneOK(MemoVO vo) {
		log.info("/insertOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.insertOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
	
	//updateOneOK.do?age=102&name=yang2&office=multi2&phone=0222
	//{"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/updateOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> updateOneOK(MemoVO vo) {
		log.info("/updateOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.updateOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
	
	//deleteOneOK.do?age=101
	//{"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/deleteOneOK.do", method = RequestMethod.GET)
	public Map<String,Long> deleteOneOK(MemoVO vo) {
		log.info("/deleteOneOK.do");
		log.info("vo:{}",vo);
		
		long result = service.deleteOne(vo);
		log.info("result:{}",result);
		
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}
	
	//미션: spring26mongodb_member CRUD처리 핵심로직 구현하기.
	//package : test.com.member : RestAPI로 구현하기
	//데이터베이스 : multi
	//컬렉션 : member
}
