package com.javalec.guestbook.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javalec.guestbook.vo.GuestBookVO;

public interface IGuestBookService {
	public void insertGuestBook(GuestBookVO vo);
	public void deleteGuestBook(GuestBookVO vo);
	public void updateGuestBook(GuestBookVO vo);
	public List<GuestBookVO> getGuestBookList();
	public GuestBookVO getGuestBookOne(GuestBookVO vo);
	public List<GuestBookVO> getSearchGuestBook(String keyword, String option);	// 검색 - select option
	public List<GuestBookVO> getKeywordList(Map<String, Object> map);	// 검색 - 예시
	
	public boolean check_pw(GuestBookVO vo) ;
}
