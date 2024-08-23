package test.com.product.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.com.product.model.ProductVO;
import test.com.product.service.ProductService;

@Slf4j
@Controller
public class ProductController {

	@Autowired
	ServletContext context;

	@Autowired
	ProductService service;

	@RequestMapping(value = "/p_insert.do", method = RequestMethod.GET)
	public String p_insert() {
		log.info("p_insert()...");

		return "product/insert";
	}

	@RequestMapping(value = "/p_update.do", method = RequestMethod.GET)
	public String p_update(ProductVO vo, Model model) {
		log.info("p_update()...");

		ProductVO vo2 = service.selectOne(vo);
		model.addAttribute("vo2", vo2);

		return "product/update";
	}

	@RequestMapping(value = "/p_delete.do", method = RequestMethod.GET)
	public String p_delete() {
		log.info("p_delete()...");

		return "product/delete";
	}

	@RequestMapping(value = "/p_selectOne.do", method = RequestMethod.GET)
	public String p_selectOne(ProductVO vo, Model model) {
		log.info("p_selectOne()...");

		ProductVO vo2 = service.selectOne(vo);

		model.addAttribute("vo2", vo2);

		return "product/selectOne";
	}

	@RequestMapping(value = "/p_selectAll.do", method = RequestMethod.GET)
	public String p_selectAll(Model model) {
		log.info("p_selectAll()...");

		List<ProductVO> list = service.selectAll();

		model.addAttribute("list", list);

		return "product/selectAll";
	}

	@RequestMapping(value = "/p_searchList.do", method = RequestMethod.GET)
	public String p_searchList(Model model, @RequestParam String searchKey, @RequestParam String searchWord) {
		log.info("p_searchList()...");

		List<ProductVO> list = service.searchList(searchKey, searchWord);

		model.addAttribute("list", list);

		return "product/selectAll";
	}

	@RequestMapping(value = "/p_insertOK.do", method = RequestMethod.POST)
	public String p_insertOK(ProductVO vo) throws IllegalStateException, IOException {
		log.info("p_insertOK()...");

		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);

		if (originName.length() == 0) {//넘어온 파일이 없을 때 default.png 할당
			vo.setImg_name("default.png");
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			vo.setImg_name(save_name);

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

		return "redirect:p_selectAll.do";
	}

	@RequestMapping(value = "/p_updateOK.do", method = RequestMethod.POST)
	public String p_updateOK(ProductVO vo) throws IllegalStateException, IOException {
		log.info("p_updateOK()...");
		
		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);

		if (originName.length() == 0) {
			vo.setImg_name(vo.getImg_name());//넘어온 파일이 없을 때 기존 이미지 할당
		} else {
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			vo.setImg_name(save_name);

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

		return "redirect:p_selectOne.do?num=" + vo.getNum();
	}

	@RequestMapping(value = "/p_deleteOK.do", method = RequestMethod.POST)
	public String p_deleteOK(ProductVO vo) {
		log.info("p_deleteOK()...");

		int result = service.delete(vo);
		log.info("result:{}", result);

		return "redirect:p_selectAll.do";
	}

	//회원가입프로그램에 프로필사진을 넣을 수 있도록 처리하세요
	//spring17fileUpload_member(참고 프로젝트:spring12mybatis_member)
	//사용자계정 : SPRING2/hi123456
	//member 테이블 생성, 시퀀스 생성 등등..
}
