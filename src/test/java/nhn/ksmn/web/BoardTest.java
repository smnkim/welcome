package nhn.ksmn.web;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nhn.ksmn.web.board.entity.Board;
import nhn.ksmn.web.board.service.BoardService;
import nhn.ksmn.web.board.util.EmailValidator;

public class BoardTest {
	private BoardService boardService;

	@Before
	public void initData() {
		ApplicationContext factory = new ClassPathXmlApplicationContext("root-context.xml");
		boardService = (BoardService) factory.getBean("boardService");
	}

	@Test
	public void testRegisterimpl() throws Exception {
		
		Board newBoard = new Board("smnkim@nhnent.com","123","게시판 제목","본문의 내용을 작성하고 있습니다.");
		int actual = boardService.insert(newBoard);
		Assert.assertEquals(actual,1);
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
		
		Boolean result = (newBoard.getNo()==findBoard.getNo()?true:false);
		System.out.println(newBoard.toString());
		Assert.assertEquals(result, true);
	}

	@Test
	public void testConfirmpwdimpl() throws Exception {

		Board newBoard = new Board(2);
		Board getBoard = (Board) boardService.select(newBoard);
		
		boolean result = ((getBoard.getPwd() != null && getBoard.getPwd().equals("1"))?true:false);
		Assert.assertEquals(result, true);
	}

	@Test
	public void testUpdateimpl() throws Exception {
		Board newBoard = new Board(9, "업데이트테스할거얌!!!!!!!!!", "본문 내용 바뀌니~~~");
		int actual = boardService.update(newBoard);
		Assert.assertEquals(actual,1);
	}
}
