<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//session
//session.removeAttribute("memName");
//session.invalidate(); - 무효화, 모든 세션 없애기


//쿠키

Cookie[] ar = request.getCookies();
if(ar != null){
	for(int i=0;i<ar.length;i++){
				
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0); //쿠키삭제
			response.addCookie(ar[i]);//클라이언트에게 보내기
		}
		if(ar[i].getValue().equals("memId")){
			ar[i].setMaxAge(0); //쿠키삭제
			response.addCookie(ar[i]);//클라이언트에게 보내기	
		}
		
	}//for
}
		
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃
</body>
</html>