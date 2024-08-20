package test.com.component;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	public HomeController() {
		log.info("HomeController()...");
	}
	
	@Autowired
	TestComponent tc; //null >>의존성주입(DI-@Autowired)에 의해 null이 아니게 된다.
	
	@Autowired
	TestService ts;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//TestComponent tc = new TestComponent();
		log.info("{}",tc);
		//log.info(tc.toString());
		return "home";
	}
	
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.GET)
	public String insertOK(Locale locale, Model model) {
		log.info("/insertOK.do");
		int result = ts.insert();
		log.info("result:{}",result);
		return "home";
	}
}//end class
