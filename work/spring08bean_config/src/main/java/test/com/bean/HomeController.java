package test.com.bean;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TestBean tb01;
	
	@Autowired
	TestBean tb02;
	
	@Autowired
	TestBean tb03;
	
	@Autowired
	Person p01;
	
	@Autowired
	Person p02;
	
	@Autowired
	Person p03;
	
	@Autowired
	TestBean2 tb04;
	
	@Autowired
	TestBean2 tb05;
	
	@Autowired
	TestBean2 tb06;
	
	@Autowired
	TestBean3 tb07;
	
	@Autowired
	Car car;
	
	@Autowired
	MissionBean mission;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("tb01:{}",tb01);
		logger.info("tb02:{}",tb02);
		logger.info("tb03:{}",tb03);
		
		logger.info("p01:{}",p01);
		logger.info("p02:{}",p02);
		logger.info("p03:{}",p03);
		
		logger.info("tb04:{}",tb04);
		logger.info("tb05:{}",tb05);
		logger.info("tb06:{}",tb06);
		
		logger.info("tb07:{}",tb07);
		
		logger.info("car:{}",car);
		logger.info("mission:{}",mission);
		
		
		
		
		return "home";
	}
	
}
