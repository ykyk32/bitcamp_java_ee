package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤 
		boolean exist = memberDAO.isExistId(id); //아이디가 있으면 true - 사용 불가능, 아이디가 없으면 false - 사용 가능
		
		//응답
		request.setAttribute("id", id);//아이디 가져가는 방법 1
		if(exist) {
			return "/member/checkIdFail.jsp";
			//return "/member/checkIdFail.jsp?id="+id;//사용불가능//아이디 가져가는 방법 2
		}else {
			return "/member/checkIdOk.jsp";//사용가능
			
		}
		
	}

}
