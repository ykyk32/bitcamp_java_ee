package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");


		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤
		MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
		
		
		//응답
		
		if(memberDTO != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			return "/member/loginOk.jsp";
		}else{
			return "/member/loginFail.jsp";
		}
		
	}

}
