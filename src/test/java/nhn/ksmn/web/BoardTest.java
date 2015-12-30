package nhn.ksmn.web;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import nhn.ksmn.web.board.entity.Board;
import nhn.ksmn.web.board.service.impl.BoardServiceImpl;
import nhn.ksmn.web.board.util.EmailValidator;

public class BoardTest {
	@Autowired
	BoardServiceImpl boardService;
	
	Board board;
	
	@Test
	public void testRegisterimpl() throws Exception {
//		
//		Board newBoard = new Board("smnkim@nhnent.com","123","게시판 제목","본문의 내용을 작성하고 있습니다.");
//		int actual = boardService.insert(newBoard);
//		Assert.assertEquals(actual,1);
	}
	
	@Test
	public void testEmailValidator() {
		
		EmailValidator emailValidator = new EmailValidator();
		
//		String[] email = new String[] { "smnkim@test.c111111om",
//				"smnkim@n22.22.222hn.ent", "smn@#$.kim@nhnent.com",
//				"testemail@navercom", "kimseamina@naver.com" };
		String[] email = new String[] { "smnkim@test.com",
				"smnkim@nhn.ent", "smn.kim@nhnent.com",
				"testemail@naver.com", "kimseamina@naver.com" };
				
		for (String actual : email) {
			boolean result = emailValidator.validate(actual);
			System.out.println(result);
			Assert.assertEquals(result, true);
		}
	}

	@Test
	public void testMyboard() throws Exception {
		Board newBoard = (Board) boardService.select(new Board(1));
		Board findBoard = (Board) boardService.select(new Board(newBoard.getNo()));
		Assert.assertEquals(newBoard, findBoard);
	}

	@Test
	public void testConfirmpwdimpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateimpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectallajax() {
		fail("Not yet implemented");
	}

}
