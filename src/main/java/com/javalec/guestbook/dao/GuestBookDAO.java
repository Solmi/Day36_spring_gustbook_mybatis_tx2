package com.javalec.guestbook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javalec.guestbook.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
   
   @Autowired
   private SqlSession mybatis;
   private DataSourceTransactionManager transactionManager;
   
   public void insert(GuestBookVO vo) {
      System.out.println("-----mybatis inserting");
      
      DefaultTransactionDefinition def = new DefaultTransactionDefinition();
      def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
      TransactionStatus status = transactionManager.getTransaction(def);
      
      try {
      mybatis.insert("GuestBookDao.insert", vo);
      mybatis.insert("GuestBookDao.insert", vo);
      }catch(Exception e) {
         e.printStackTrace();
         transactionManager.rollback(status);
      }
      transactionManager.commit(status);
   }
   
   public void delete(GuestBookVO vo) {
      System.out.println("[dao.delete] " + vo.getNo());
      System.out.println("[dao.delete] " + vo.getPw());
      
      mybatis.delete("GuestBookDao.delete", vo);
   }
   
   public List<GuestBookVO> selectList() {
      return mybatis.selectList("GuestBookDao.getList");
   }
   
   public void update(GuestBookVO vo) {
      mybatis.update("GuestBookDao.update", vo);
   }
   
   public List<GuestBookVO> getKeywordList(Map<String, Object> map){
      return mybatis.selectList("GuestBookDao.getKeywordList", map);
   }
   
   public GuestBookVO getGuestBookOne(GuestBookVO vo){
      return mybatis.selectOne("GuestBookDao.getBookOneList", vo);
   }

}