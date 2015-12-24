package nhn.ksmn.web.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nhn.ksmn.web.board.entity.Board;
import nhn.ksmn.web.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	 BoardService boardService;

	@RequestMapping("/main.nhn")
	public ModelAndView main(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("main");
	    session.setAttribute("head", "screen/header.jsp");
	    session.setAttribute("body", "screen/section.jsp");
	    session.setAttribute("foot", "screen/footer.jsp");
	    session.setAttribute("screen", "screen.jsp");	    
	    
	    
	    mv.addObject("view", "../board/board.jsp");
	    mv.addObject("boards", boardService.select());  

  		return mv;

   }
	
	@RequestMapping("/register.nhn")
	public ModelAndView register() throws Exception {
		ModelAndView mv = new ModelAndView("main");

	    mv.addObject("view", "../board/register.jsp");

  		return mv;

   }
	@RequestMapping("/registerimpl.nhn")
	public String registerimpl(Board b) throws Exception {
		System.out.println(b.toString());
//		Board newBoard = new Board(b.getEmail(), b.getPwd(), b.getTitle(), b.getContent());
		Board newBoard = new Board("kimseamina@naver.com", "1234", "바보멍청이이이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		boardService.insert(newBoard);
		
		return "redirect:/main.nhn";
	}	
}
