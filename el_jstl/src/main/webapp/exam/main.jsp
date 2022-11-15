<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive **</h3><!-- 포함 후에 컴파일- Duplicate local variable-->
<%@ include file="today.jsp" %><!--결과물이 아니라 소스를 들고온다  -->


<h3> ** include JSP tag ** </h3><!-- 각각 컴파일 후 포함-변수 안겹침 -->
<jsp:include page="image.jsp"/>
<br>

<% String name ="홍길동"; %>
main.jsp의 name =<%= name %>

</body>
</html>