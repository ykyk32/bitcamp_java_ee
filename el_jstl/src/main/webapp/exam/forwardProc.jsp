<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("apple","사과");

//페이지 이동
/* RequestDispatcher dispatcher = request.getRequestDispatcher("상대번지-나를 기준점으로"); */
/* RequestDispatcher dispatcher 
= request.getRequestDispatcher("http://localhost:8080/el_jstl/exam/forwardResult.jsp");절대번지 */

RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
dispatcher.forward(request, response);//제어권을 넘기기
%>
<%-- <jsp:forward page="forwardResult.jsp"/> 요즘 잘 안씀 --%>
