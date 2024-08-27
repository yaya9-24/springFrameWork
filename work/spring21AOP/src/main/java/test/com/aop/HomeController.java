package test.com.aop;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	TestService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		log.info("insert result : {}",service.insert(null));
		log.info("selectAll result : {}",service.selectAll());
		
		log.info("======================");
		log.info("update result : {}",service.update(null));
		
		log.info("======================");
		log.info("delete result : {}",service.delete(null));
		
		log.info("======================");
		log.info("searchList result : {}",service.searchList(null,null));
		
		log.info("======================");
		log.info("selectOne result : {}",service.selectOne(null));
		
		log.info("======================");
		log.info("idCheck result : {}",service.idCheck(null));
		
		return "home";
	}
	
}
