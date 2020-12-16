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
<title>Insert title here</title>
</head>
<body>
<h1>jsp5/deletepro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
String pass=request.getParameter("pass");
int check=-1;


MemberDAO mdao=new MemberDAO();
check=mdao.userCheck(id, pass);

if (check==1){
mdao.deleteMember(id);
response.sendRedirect("../user/LoginForm.jsp");
}else if(check==0){
	%>
	<script type="text/javascript">
	alert("비밀번호를 확인해주세요");
	history.back();
	</script>
	<% 
	
}else if(check==-1){
	%>
	<script type="text/javascript">
	alert("아이디를확인해주세요");
	history.back();
	</script>
	<% 
	
}
%>
</body>
</html>