
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
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
MemberDAO mdao=new MemberDAO();
MemberDTO mdto=mdao.getmember(id);

if(!id.equals("")){
if(mdto.getIDoverLapcheck().equals("아이디있음")){
	
%>
<script type="text/javascript">
	alert("사용불가아이디입니다")
	history.back();
	
	</script>

<% 
}
if(mdto.getIDoverLapcheck().equals("아이디없음")){
	%> 
<script type="text/javascript">
alert("사용가능한아이디입니다")
</script>
<form action="InsertForm.jsp" method="post" name="over">
아이디:<input type="text" value="<%=id%>" name="id"><a href="InsertForm.jsp?id=<%=id%>"><input type="button" value="사용하기" ></a>
</form>
 	<%  
 }
}else{%> 
<script type="text/javascript">
alert("아이디를 입력해주세요")
history.back();
</script>
	<%  
}
%> 
</body>
</html>