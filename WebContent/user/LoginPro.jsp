<%@page import="member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp5/loginPro.jsp</h1>
<%

request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String name=request.getParameter("name");

MemberDAO mdao=new MemberDAO();
int check=mdao.userCheck(id, pass);

if(check==1){
	session.setAttribute("id", id);
	%>
	<script type="text/javascript">
	alert("로그인성공");
	location.href="../Main/Main.jsp";
	</script>
	<%
}
if(check==0){
	%>
	<script type="text/javascript">
	alert("비밀번호가 틀립니다");
	history.back();
	</script>
	<%
}
if(check==-1){
	%>
	<script type="text/javascript">
	alert("아이디가 틀립니다");
	history.back();
	</script>
	<%
}
%>


</body>
</html>