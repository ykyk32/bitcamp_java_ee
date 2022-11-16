<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	String keyword = request.getParameter("keyword");
	%>
	<%= keyword %>
	<!--서버로부터 오는 데이터 받고 출력  -->
   <%--  ${param.keyword} --%>