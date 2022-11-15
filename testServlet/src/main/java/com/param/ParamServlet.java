package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 - http://localhost:8080/testServlet/ParamServlet?name=%EC%BD%94%EB%82%9C&age=13
		
		String name = request.getParameter("name");
		int age = Integer.parseInt( request.getParameter("age"));
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
			out.print("<html>");
			out.println("<body>");
			
			out.print("Hello Servlet!!<br>");
			out.println(name + "님의 나이는"+ age+"살 이므로");
			if(age>=19)out.println("성인 입니다.");
			else out.println("청소년 입니다.");
			
			out.println("</body>");
			out.print("</html>");
	}
	@Override
	public void destroy() {
		
	}

	

}
