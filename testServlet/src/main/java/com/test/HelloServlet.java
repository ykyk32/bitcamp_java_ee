package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void init() {
	   System.out.println("init() 메소드");
   }

   	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
   		System.out.println("doGet() 메소드");
   		
   		response.setContentType("text/html;charset=UTF-8");//앞으로 치는코드듣이 html임을 알려준다
   		PrintWriter out = response.getWriter();//생성
   			out.print("<html>");
   			out.print("</html>");
   			out.print("Hello Servlet!!<br>");
   			out.println("안녕하세요 서블릿!!<br>");
   			out.println("<body>");
   			out.println("</body>");
   	}
   	public void destroy() {
   		System.out.println("destroy() 메소드");
   	}
   	
}

