package nhn.ksmn.web.board.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface BoardService {
	
	   @Transactional
	   public int insert(Object obj) throws Exception;
	
	   @Transactional
	   public int delete(Object obj) throws Exception;
	
	   @Transactional
	   public int update(Object obj) throws Exception;

	   public Object select(Object obj) throws Exception;

	   public ArrayList<Object> select();
}
