
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복확인</title>
</head>
<body>
<h1>중복확인</h1>
<%
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
int check =-1;
membDAO dao=new DAO();
check=dao.overcheck(id);


if(check==-1){
	
%>
<script type="text/javascript">
	alert("사용불가아이디입니다")
	history.back();
	
	</script>

<% 
}else if(check==1){
	%> 
<script type="text/javascript">
alert("사용가능한아이디입니다")
</script>
아이디:<input type="text" value="<%=id%>"><a href="insertForm.jsp?id=<%=id%>"><input type="button" value="사용하기" ></a>

 	<%  
 }
%> 
</body>
</html>