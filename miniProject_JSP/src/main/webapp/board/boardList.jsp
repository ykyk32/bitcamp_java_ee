<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.bean.BoardPaging"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashMap"%>


    
<%

//데이터
int pg = Integer.parseInt(request.getParameter("pg"));

	//1페이지당 5개씩
int endNum = pg*5;
int startNum = endNum - 4;

/* 
select ~~~ where rn>=? and rn<=?
		
pg=1 rn>=1 and rn<=5
pg=2 rn>= startNum rn<= endNum 
*/

//session
String id = (String)session.getAttribute("memId");

Map<String, Integer> map = new HashMap<String, Integer>();//Map<키값, 값(오브젝트로 보통 사용)>은 인터페이스, HashMap이 Map에게 추상메소드를 overriding해준다.
map.put("startNum", startNum);
map.put("endNum", endNum);
//DB
BoardDAO boardDAO= BoardDAO.getInstance();
List<BoardDTO> list=boardDAO.boardList(map);

//페이징 처리
int totalA = boardDAO.getTotalA();// 총 글수 

BoardPaging boardPaging = new BoardPaging();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();


%>    

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

<% if(list != null) { %>
	
		<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows"><!-- hsides-Horizontal SIDES//rules="rows"-행만표시 -->
			<tr>
				<th style="width: 100px">글번호</th>
				<th style="width: 400px">제목</th>
				<th style="width: 100px">작성자</th>
				<th style="width: 100px" >조회수</th>
				<th style="width: 200px" >작성일</th>
			</tr>
	<%for(BoardDTO boardDTO : list){ %>
		<tr>
			<td align="center"><%= boardDTO.getSeq() %></td>
			<%-- <td class="subjectA" onclick="isLogin(<%=boardDTO.getSeq()%>,<%=pg %>)"><%= boardDTO.getSubject() %></td> --%>
			<td><a href="#" class="subjectA" onclick="isLogin('<%=id%>',<%=boardDTO.getSeq()%>,<%=pg %>)" ><%= boardDTO.getSubject() %></a></td>
			<td align="center"><%= boardDTO.getId() %></td>
			<td align="center"><%= boardDTO.getHit() %></td>
			<td align="center"><%= new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %></td><!-- java는 대문자MM해야 월 -->
		</tr>	
	<%}//for %>
		</table> 
		
		<div style="display: inline-block; clear: both;">
		<div id="main"><input type="button" value="메인" onclick="location.href='../index.jsp'" style="cursor: pointer;"/></div>
		<!-- <img src="../img/img2.png" width="70" height="70" onclick="location.href='../index.jsp'" style="cursor: pointer;"> -->
		<div id="pagingDiv"><%=boardPaging.getPagingHTML() %></div>
		</div>
<%}//if %>

<script type="text/javascript">
function boardPaging(pg,seq){/*javaScript는 자료형 없으니까 pg로 받는다 */
	location.href ="boardList.jsp?pg="+pg;
}
function isLogin(id,seq,pg){
	
	if(id == 'null') alert("먼저 로그인하세요");
	else
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
}

<%--
 function isLogin(seq,pg) {
	if('<%=(String)session.getAttribute("memId")%>' == 'null'){
		alert("먼저 로그인 하세요");
		
	}else{
		
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	}  

}
--%>
</script>
</body>
</html>