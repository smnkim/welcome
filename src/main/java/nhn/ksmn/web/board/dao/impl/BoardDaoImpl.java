package nhn.ksmn.web.board.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nhn.ksmn.web.board.dao.BoardDao;
import nhn.ksmn.web.board.entity.Board;
@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
    private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
	@Override
	public int insert(Object obj) throws Exception {
		return sqlSession.insert("insertBoard", obj);
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
		return sqlSession.selectOne("getBoard", obj);
	}


	@Override
	public ArrayList<Object> select() {
		return (ArrayList<Object>) sqlSession.selectList("getBoards");
	}

}
