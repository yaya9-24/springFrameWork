package test.com.employees;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmpRestController {
	
	@Autowired
	EmpService service;
	
	
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<EmpVO> findAll(@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "0")int limit) {
		log.info("/findAll.do");
		
		List<EmpVO> list = service.findAll(page, limit);
		log.info("list.size():{}",list.size());
		
		
		return list;
	}
	
}
