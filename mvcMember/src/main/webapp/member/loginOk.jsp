<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><img src="../img/img2.png" width="70" height="70" onclick="location.href='../index.jsp'" 
         style="cursor: pointer;">${sessionScope.memName}님 로그인</h3>

<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
</body>
</html>











