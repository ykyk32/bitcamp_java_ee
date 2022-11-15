<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<%
//데이터
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//DB
MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤
MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(memberDTO != null){
	//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	
	//세션
	//HttpSession session = request.getSession(); //세션 생성
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
	session.setAttribute("memberDTO", memberDTO);
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
	
}else{
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
}
%>
</body>
</html>
















