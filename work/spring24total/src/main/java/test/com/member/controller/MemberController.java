package test.com.member.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class MemberController {
	
	//mission
	//spring24total(회원가입 + 게시글 프로젝트)
	//spring23login_member + spring13board(파일업로드+타일즈 기능추가)
	//게시글은 로그인한 아이디로 작성할 수 있도록 처리하세요.
	

	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext context;

	@Autowired
	MemberService service;

	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("insert()...");

		return ".member/insert";
	}

	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo, Model model) {
		log.info("update()...", vo);

		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return ".member/update";
	}

	@RequestMapping(value = "/m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		log.info("delete()...");

		return ".member/delete";
	}

	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model) {
		log.info("selectAll()...");

		List<MemberVO> list = service.selectAll();
		log.info("{}", list);

		model.addAttribute("list", list);

		return ".member/selectAll";
	}

	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(String searchKey, String searchWord, Model model) {
		log.info("searchList()...");

		List<MemberVO> list = service.searchList(searchKey, searchWord);
		log.info("{}", list);

		model.addAttribute("list", list);

		return ".member/selectAll";
	}

	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo, Model model) {
		log.info("selectOne()...");
		log.info("{}", vo);

		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return ".member/selectOne";
	}

	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("insertOK()...");
		log.info("{}", vo);

		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);

		if (originName.length() == 0) {
			vo.setProfile("default.png");
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			vo.setProfile(save_name);

			File f = new File(realPath, save_name);
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

		}
		
		int result = service.insert(vo);
		log.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("updateOK()....");
		log.info("{}", vo);

		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);

		if (originName.length() == 0) {
			vo.setProfile(vo.getProfile());
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			vo.setProfile(save_name);

			File f = new File(realPath, save_name);
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

		}
		int result = service.update(vo);
		log.info("result:{}", result);

		return "redirect:m_selectOne.do?num="+vo.getNum();
	}

	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.POST)
	public String m_deleteOK(MemberVO vo) {
		log.info("deleteOK()...");
		log.info("{}", vo);

		int result = service.delete(vo);
		log.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}
	
	@RequestMapping(value = "/m_login.do", method = RequestMethod.GET)
	public String m_login() {
		log.info("m_login()...");
		
		return ".member/login";
	}
	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(MemberVO vo) {
		log.info("loginOK()...");
		log.info("{}", vo);
		
		MemberVO vo2 = service.login(vo);
		if (vo2 !=null){
            session.setAttribute("user_id",vo.getId());
            session.setMaxInactiveInterval(5*60);
            return "redirect:home.do";
        } else {
        	return "redirect:m_login.do";
        }		
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("/logout.do");
		
		session.removeAttribute("user_id");
		
		return "redirect:home.do";
	}
}// end class
