package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //데이터
	    request.setCharacterEncoding("UTF-8"); //post 방식-한글 나오도록 시키는거
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDTO memberDTO = new MemberDTO();
	    memberDTO.setId(id);
	    memberDTO.setPwd(pwd);
	     
	    //DB
	    MemberDAO memberDAO = MemberDAO.getInstance();//싱글톤
	    String name = memberDAO.memberLogin(memberDTO);

		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		 if(name != null )
	         out.println(name + "님이 로그인하였습니다");
	      else
	         out.println("아이디 또는 비밀번호가 틀렸습니다.");
		out.println("</body>");
		out.println("</html>");
		
	}

}
