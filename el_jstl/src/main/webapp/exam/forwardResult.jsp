<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String apple = (String)request.getAttribute("apple");//꺼내욜 때 Object 로 끄내니까 형변환

%>

결과 = <%=apple%>