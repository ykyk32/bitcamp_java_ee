<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
int dan,i;

%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 > 
<% 
for(i=1;i<=9;i++){%><tr><% 
	
	for(dan=2;dan<=9;dan++){
		%><td width="100" >
		<%=dan%>  * <%= i%> = <%= dan*i%>
		&ensp;</td>
<%	
	}%></tr><br><% 
}

%>
</table>

</body>
</html>