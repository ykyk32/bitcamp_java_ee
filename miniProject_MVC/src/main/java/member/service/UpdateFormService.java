package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 * HttpSession session = request.getSession(); String id =
		 * (String)session.getAttribute("memId");
		 * 
		 * //DB MemberDAO memberDAO = MemberDAO.getInstance(); MemberDTO memberDTO
		 * =memberDAO.getMember(id);
		 * 
		 * request.setAttribute("memberDTO",memberDTO); 
		 * request.setAttribute("display", "/member/updateForm.jsp"); 
		 * return "/index.jsp";//index화면이 뜨는데 section 바뀌게
		 */
		
		request.setAttribute("display","/member/updateForm2.jsp"); 
		return "/index.jsp";//index화면이 뜨는데 section 바뀌게
	}

}
