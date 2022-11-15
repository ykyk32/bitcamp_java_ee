package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String seq = request.getParameter("seq");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("display",  "/board/boardUpdateForm.jsp");
		return "/index.jsp";
		///board/boardUpdateForm.jsp 로 가는데 set으로 seq랑 pg실었다.
		//독단으로 안뜨게 display에 실어서 index로 보냄
	}

}
