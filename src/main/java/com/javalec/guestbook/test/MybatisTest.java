package com.javalec.guestbook.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class MybatisTest {

	public static void main(String[] args) {
		GuestBookDAO dao = new GuestBookDAO();
		GuestBookVO vo = new GuestBookVO();
		
//		// insert	
//		vo.setName("qwer");
//		vo.setPw("1111");
//		vo.setContent("qwerqweqr");
//		dao.insert(vo);
		
//		// delete		
//		vo.setNo(161);
//		dao.delete(vo);
		
//		// update
//		vo.setContent("zxcvzxcv");
//		vo.setNo(145);
//		dao.update(vo);
		
		
//		// getKeyword
//		Map<String, Object> map = new HashMap<String, Object>();	//map�씠 object瑜� 二쇰㈃ �뼐媛� �궡遺��쟻�쑝濡� �븣�븘�꽌 媛믪뿉 留욊쾶 李얠븘以�
//		map.put("keyword", "%1%");
//		List<GuestBookVO> list = dao.getKeywordList(map);
//		for(GuestBookVO guestbook : list) {
//		System.out.println(guestbook.toString());
//		}
		
		// list
		List<GuestBookVO> list = dao.selectList();
		for(GuestBookVO guestbook : list) {
			System.out.println(guestbook.toString());
		}
		
		
	}

	
	
}
