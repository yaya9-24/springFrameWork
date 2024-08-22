package test.com.product.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
	ProductService service;
	
	@RequestMapping(value = "/p_insert.do", method = RequestMethod.GET)
	public String p_insert() {
		log.info("insert()...");
		
		return "product/insert";
	}
	
	@RequestMapping(value = "/p_update.do", method = RequestMethod.GET)
	public String p_update(ProductVO vo, Model model) {
		log.info("update()...");
		
		ProductVO vo2 = service.selectOne(vo);
		
		model.addAttribute("vo2",vo2);
		return "product/update";
	}
	
	@RequestMapping(value = "/p_delete.do", method = RequestMethod.GET)
	public String p_delete() {
		log.info("delete()...");
		
		return "product/delete";
	}
	
	@RequestMapping(value = "/p_selectOne.do", method = RequestMethod.GET)
	public String p_selectOne(ProductVO vo, Model model) {
		log.info("selectOne()...");
		
		ProductVO vo2 = service.selectOne(vo);
		
		model.addAttribute("vo2",vo2);
		
		return "product/selectOne";
	}
	
	@RequestMapping(value = "/p_selectAll.do", method = RequestMethod.GET)
	public String p_selectAll(Model model) {
		log.info("selectAll()...");
		
		List<ProductVO> list = service.selectAll();
		
		model.addAttribute("list",list);
		
		return "product/selectAll";
	}
	
	@RequestMapping(value = "/p_searchList.do", method = RequestMethod.GET)
	public String p_searchList(Model model
			, @RequestParam String searchKey
			,@RequestParam String searchWord) {
		log.info("searchList()...");
		
		List<ProductVO> list = service.searchList(searchKey,searchWord);
		
		model.addAttribute("list",list);
		
		return "product/selectAll";
	}
	
	@RequestMapping(value = "/p_insertOK.do", method = RequestMethod.POST)
	public String p_insertOK(ProductVO vo) {
		log.info("insertOK()...");
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
	
	@RequestMapping(value = "/p_updateOK.do", method = RequestMethod.POST)
	public String p_updateOK(ProductVO vo) {
		log.info("updateOK()...");
		
		int result = service.update(vo);
		log.info("result:{}",result);
		
		return "redirect:p_selectOne.do?num="+vo.getNum();
	}
	
	@RequestMapping(value = "/p_deleteOK.do", method = RequestMethod.POST)
	public String p_deleteOK(ProductVO vo) {
		log.info("deleteOK()...");
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
}
