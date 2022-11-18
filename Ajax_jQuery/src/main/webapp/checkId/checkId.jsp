<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML파일 태그 시작 전의 공백 제거 —--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%--JSP주석--%>
<%-- 
DB 연동 - 아이디가 "hong" 이 이미 있는 값이면 DB에 저장된 아이디로 취급하여 true를 전달 // DB 연동 할 거리가 없어서 임의로 여기에 생성
--%>

<c:set var="result" value="false" />
<c:if test="${param.user_id == 'hong'}">
	<c:set var="result" value="true" />
</c:if>

<?xml version="1.0" encoding="UTF-8"?> 
<check_id>
	<result>${result }</result>
</check_id>
