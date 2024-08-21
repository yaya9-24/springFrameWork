package test.com.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		
		model.addAttribute("vo",vo);
		
		List<TestVO> list = new ArrayList<TestVO>();
		for (int i = 0; i < 5; i++) {
			TestVO vo2 = new TestVO();
			vo2.setName("kim"+i);
			vo2.setAge(33+i);
			list.add(vo2);
		}
		model.addAttribute("list",list);
		
		return "home";
	}
	
}
