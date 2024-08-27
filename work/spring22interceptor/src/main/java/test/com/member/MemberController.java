package test.com.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		log.info("/login.do");
		
		
		return "login";
	}
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.GET)
	public String loginOK() {
		log.info("/loginOK.do");
		
		session.setAttribute("user_id", "admin");
		
		return "redirect:home.do";
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("/logout.do");
		
		session.removeAttribute("user_id");
		
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll() {
		log.info("/selectAll.do");
		
		
		return "selectAll";
	}
	
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne() {
		log.info("/selectOne.do");
		
		
		return "selectOne";
	}
	
}
