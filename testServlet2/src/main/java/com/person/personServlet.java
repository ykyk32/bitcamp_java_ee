package com.person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/personServlet")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  //데이터
	  String name = req.getParameter("name");
	  int gender= Integer.parseInt(req.getParameter("gender"));
	  String color = req.getParameter("color");
	  String[] hobby = req.getParameterValues("hobby");
	  String[] subject = req.getParameterValues("subject");
	  
	  //응답
	  resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
			out.print("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("li{color :  "+color+"}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.print("<ul>");
			out.println("<li>이 름 : "+name+"</li><br>");
			out.println("<li>성 별 : "+gender+"</li><br>");
			out.println("<li>색 깔 : "+color+"</li><br>");
			out.println("<li>취 미 : ");
			for(int i=0;i<hobby.length;i++) {
				out.println(hobby[i]+"&nbsp;");
			}
			out.println("</li><br>");
			
			/*
			 * out.println("<li>과 목 : "); for(int i=0;i<subject.length;i++) {
			 * out.println(subject[i]+"&nbsp;"); }
			 */
			out.println("<li>과 목 : ");
			for(String data: subject) {
				out.println(data+"&emsp;");
			}
			out.println("</li><br>");
			out.println("</ul>");
			
			out.println("</body>");
			out.print("</html>");
}
  
  @Override
public void destroy() {
	
}
   
}
