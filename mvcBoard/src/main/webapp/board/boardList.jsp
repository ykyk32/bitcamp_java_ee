<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#pagingDiv {
	/* border: 1px solid red; */
	text-align: center;
	width: 900px;
	margin-top: 10px;
	
	}
#main {
	float: left;
}
#currentPaging {
	border: 1px solid blue;
	padding: 3px 10px;
	margin: 5px;
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
#paging {
	/* border: 1px solid blue; */
	cursor: pointer;
	padding: 3px 10px;
	margin: 5px;
}
/* .subjectA:hover {
	color: green;
	text-decoration: underline;
} */
a.subjectA:link { color: black; text-decoration: none;}
a.subjectA:visited {color: black; text-decoration: none;}
a.subjectA:hover {color: gray;	text-decoration: underline;}
a.subjectA:active {color: black; text-decoration: none;}
</style>
</head>
<body>

	<c:if test="${requestScope.list != null }">	
		<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows"><!-- hsides-Horizontal SIDES//rules="rows"-행만표시 -->
			<tr>
				<th style="width: 100px">글번호</th>
				<th style="width: 400px">제목</th>
				<th style="width: 100px">작성자</th>
				<th style="width: 100px" >조회수</th>
				<th style="width: 200px" >작성일</th>
			</tr>
	<c:forEach var="boardDTO" items="${list }"> 
		<tr>
			<td align="center">${boardDTO.seq}</td>
			<%-- <td class="subjectA" onclick="isLogin(<%=boardDTO.getSeq()%>,<%=pg %>)"><%= boardDTO.getSubject() %></td> --%>
			<td><a href="#" class="subjectA" onclick="isLogin('${id }',${boardDTO.seq },${pg })" >${ boardDTO.subject }</a></td>
			<td align="center">${ boardDTO.id } </td>
			<td align="center">${boardDTO.hit}</td>			
			<td align="center"><fmt:formatDate value="${boardDTO.logtime }" pattern="yyyy.MM.dd"/></td><!-- java는 대문자MM해야 월 -->
			
		</tr>	
	</c:forEach>
		</table> 
	</c:if>	
		
	<div style="display: inline-block; clear: both;">
		<div id="main"><input type="button" value="메인" onclick="location.href='../index.jsp'" style="cursor: pointer;"/></div>
		<!-- <img src="../img/img2.png" width="70" height="70" onclick="location.href='../index.jsp'" style="cursor: pointer;"> -->
		<div id="pagingDiv">${boardPaging.pagingHTML  }</div>
		</div>


<script type="text/javascript">
function boardPaging(pg,seq){/*javaScript는 자료형 없으니까 pg로 받는다 */
	location.href ="boardList.do?pg="+pg;
}
function isLogin(id,seq,pg){
	
	if(id == 'null') alert("먼저 로그인하세요");
	//else
		//location.href="boardView.do?seq="+seq+"&pg="+pg;
}



</script>
</body>
</html>