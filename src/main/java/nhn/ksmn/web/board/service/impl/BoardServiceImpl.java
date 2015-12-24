package nhn.ksmn.web.board.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import nhn.ksmn.web.board.dao.BoardDao;
import nhn.ksmn.web.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource(name="boardDao")
    private BoardDao boardDao;
 
	@Override
	public int insert(Object obj) throws Exception {
		return boardDao.insert(obj);
	}

	@Override
	public int delete(Object obj) throws Exception {
		return 0;
	}

	@Override
	public int update(Object obj) throws Exception {
		return 0;
	}

	@Override
	public Object select(Object obj) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Object> select() {
		return boardDao.select();
	}

}
