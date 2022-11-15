<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.mainnav{
   background-color: brown;
   list-style: none;
   color: #ffffff;
}

.mainnav:after{ /*container-snb,content  바로 붙지 않게 하기 위해서 clear 함 */
   content: '';
   display: block;
   clear: both;
}

.mainnav li{
   display: inline-block;
   justify-content: space-between;
}

.mainnav li a {
   display: block;
   padding: 0 13px; /*  위아래, 좌우 */
   background-color: orange;
   color: #ffffff;
   font: bold 16px/40px 'Nanum Gothic', sans-serif; 
      /*폰트의 굵기 | 글자의 크기 | /line-height 줄간격 |  글꼴  , 앞에 글꼴없으면 다음 글꼴*/
   text-transform: uppercase;
   text-decoration: none;
}
.mainnav li a:hover {
   color: #660000;
   background-color: #ffcc00;
}
</style>
<ul class="mainnav">
	<!-- memId 라는 세션이 있으면 글쓰기기 보이게 -->
	
	<c:if test="${sessionScope.memId != null }" ><!-- .memId != null도 가능 -->
		<li><a href ="http://localhost:8080/miniProject_MVC/board/boardWriteForm.do">글쓰기</a></li>
	</c:if>
	<li><a href ="/miniProject_MVC/board/boardList.do?pg=1">목록</a></li>
	
</ul>
