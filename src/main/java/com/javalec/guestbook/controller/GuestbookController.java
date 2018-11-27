package com.javalec.guestbook.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.service.IGuestBookService;
import com.javalec.guestbook.vo.GuestBookVO;

@Controller
public class GuestbookController {
	@Autowired
	private IGuestBookService guestbookService;
	
	@RequestMapping("/getguestbooklist.do")
	public String getGuestBookList(GuestBookDAO dao, Model model) {
		System.out.println("리스트 조회 컨트롤러");
		//model.addAttribute("list", dao.selectList());
		model.addAttribute("list", guestbookService.getGuestBookList());

		return "index.jsp";
	}
	
	@RequestMapping("/addform.do")
	public String InsertformGuestBook() {
		System.out.println("insert form 컨트롤러");
		
		return "addform.jsp";
	}
	
	@RequestMapping("/add.do")
	public String InsertGuestBook(GuestBookVO vo, GuestBookDAO dao, Model model) {
		System.out.println("insert 컨트롤러");
		//dao.insert(vo);
		guestbookService.insertGuestBook(vo);
		
		return "getguestbooklist.do";
	}
	
	@RequestMapping("/deleteform.do")
	public String DeleteformGuestBook() {	
		System.out.println("delete form 컨트롤러");
		
		return "deleteform.jsp";
	}
	
	@RequestMapping("/delete.do")
	public String DeleteGuestBook(GuestBookVO vo, GuestBookDAO dao, Model model) { //알아서 객체 셋팅해줌. command 객체. 
		// 비밀번호 일치 확인
		System.out.println("[delete.do] no : " + vo.getNo());
		System.out.println("[delete.do] pw : " + vo.getPw());
		
		boolean pwCheck = false;
		pwCheck = guestbookService.check_pw(vo);
		//pwCheck = dao.check_pw(vo);
		
		System.out.println("[delete.do] pwCheck : " + pwCheck);
		
		if(pwCheck == true) {
			guestbookService.deleteGuestBook(vo);
			
			return "getguestbooklist.do";
		}
		
		model.addAttribute("msg", "비밀번호가 일치하지 않음");
		return "deleteform.do";
	}
	
	@RequestMapping("/updateform.do")
	public String UpdateformGusetBook() {
		System.out.println("update form 컨트롤러");
		
		return "updateform.jsp";
	}
	
	@RequestMapping("/update.do")
	public String UpdateGusetBook(GuestBookVO vo, GuestBookDAO dao, Model model) {
		System.out.println("update 컨트롤러");
		System.out.println("[update.do] pw : " + vo.getPw());
		System.out.println("[update.do] content : " + vo.getContent());
		
		// 비밀번호 일치 확인
		boolean pwCheck = false;
		pwCheck = guestbookService.check_pw(vo);
		//pwCheck = dao.check_pw(vo);
				
		if(pwCheck == true) {
			guestbookService.updateGuestBook(vo);
					
			return "getguestbooklist.do";
		}
		
		model.addAttribute("msg", "비밀번호가 일치하지 않음");
		return "updateform.do";
	}
	
	@RequestMapping("/showcontent.do")
	public String ViewOneGuestBook(GuestBookVO vo, Model model, GuestBookDAO dao) {
		System.out.println("단독 리스트 컨트롤러");
		model.addAttribute("resultList", guestbookService.getGuestBookOne(vo));
		
		return "showcontent.jsp";
	}
	
	@RequestMapping("/searchkeywordlist.do")
	public String SearchGuestBook(GuestBookDAO dao, Model model, 
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, 
			@RequestParam(value="search_option", defaultValue="", required=false) String search_option) {
		System.out.println("키워드 검색 목록 컨트롤러");
		System.out.println("option : " + search_option);
		System.out.println("keyword : " + keyword);
		
		
		Map<String, Object> map = new HashMap<String, Object>();	//map이 object를 주면 얘가 내부적으로 알아서 값에 맞게 찾아줌
		map.put("keyword", "%"+keyword+"%");
		
		
		// 내용 검색용
		model.addAttribute("list", guestbookService.getKeywordList(map));
		model.addAttribute("searchKeyword", keyword);
		
//		// select 검색용
//		model.addAttribute("searchKeyword", keyword);
//		model.addAttribute("searchOption", search_option);
//		//model.addAttribute("list", guestbookService.getSearchGuestBook(keyword, search_option));
//		model.addAttribute("list", guestbookService.getSearchGuestBook(keyword, search_option));
		
		return "index.jsp";
		
	}

}
