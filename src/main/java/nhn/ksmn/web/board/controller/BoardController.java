package nhn.ksmn.web.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
	
	@ResponseBody
   @RequestMapping("/selectallajax.nhn")
   public ResponseEntity<String> selectallajax() throws Exception {
      
		ResponseEntity<String> returnData = null;
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=EUC-KR");
      
		
      JSONArray ja = new JSONArray();
      ArrayList<Object> result = new ArrayList<Object>();
      
      result = boardService.select();


         for (Object obj : result) {
            Board board = (Board) obj;

            JSONObject jo = new JSONObject();
            jo.put("no", board.getNo());
            jo.put("title", board.getTitle());
            jo.put("writer", board.getEmail());
            jo.put("date", board.getLatest_time());
            ja.put(jo);

         }
      returnData = new ResponseEntity<String>(ja.toString(), header, HttpStatus.CREATED);
      
      return returnData;
   }

}
