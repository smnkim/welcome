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
		//이메일 형식이 올바른지 서버 쪽, 클라이언트 쪽 모두에서 체크
		
		Board newBoard = new Board(b.getEmail(), b.getPwd(), b.getTitle(), b.getContent());
		boardService.insert(newBoard);
		
		return "redirect:/main.nhn";
	}	
	
	
	@RequestMapping("/confirmpwd.nhn")
	public ModelAndView confirmpwd(String no) throws Exception {
		ModelAndView mv = new ModelAndView("main");

		mv.addObject("pno", no);
	    mv.addObject("view", "../board/confirmpwd.jsp");

  		return mv;

	}

	@RequestMapping("/confirmpwdimpl.nhn")
	public ModelAndView confirmpwdimpl(int pno, String pwd) throws Exception {
		ModelAndView mv = new ModelAndView("main");
		
		Board newBoard = new Board(pno);
		Board getBoard = (Board) boardService.select(newBoard);
		
		if(getBoard.getPwd() != null && getBoard.getPwd().equals(pwd)){
			
			mv.addObject("view", "../board/update.jsp");
			
		}else{
			mv.addObject("view", "../board/failpwd.jsp");
		}
		return mv; 
	}	
		
}
