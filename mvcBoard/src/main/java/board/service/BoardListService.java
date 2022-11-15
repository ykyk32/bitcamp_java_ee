package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//세션
		HttpSession session =request.getSession();
		String id= "hong";
		
		
		//1페이지당 5개씩
		int endNum = pg*5;
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();//Map<키값, 값(오브젝트로 보통 사용)>은 인터페이스, HashMap이 Map에게 추상메소드를 overriding해준다.
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		//DB
		BoardDAO boardDAO= BoardDAO.getInstance();
		List<BoardDTO> list=boardDAO.boardList(map);
		

		//페이징 처리
		int totalA = boardDAO.getTotalA();// 총 글수 

		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		
		request.setAttribute("pg",pg);
		request.setAttribute("list",list);
		request.setAttribute("boardPaging",boardPaging);
		request.setAttribute("id",id);
		
		
		return "/board/boardList.jsp";
	}

}
