<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="member.dao.MemberDAO"%>

<%
//데이터
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//DB
MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤
String name = memberDAO.memberLogin(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(name != null){
	//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	
	//세션
	//HttpSession session = request.getSession(); //세션 생성
	//session.setAttribute("memName", name);
	
	//쿠키
	//Cookie cookie = new Cookie("쿠키명",값);
	Cookie cookie = new Cookie("memname",name);
	cookie.setMaxAge(30*60); ////초단위
	//클라이언트에게 보내기(서버가 쿠키 만들어서 클라이언트에 저장)
	response.addCookie(cookie);
	
	Cookie cookie2 = new Cookie("memId",id);
	cookie2.setMaxAge(30*60); 	//30분
	response.addCookie(cookie2);//클라이언트에 보내기
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
	
}else{
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
}
%>
</body>
</html>
















