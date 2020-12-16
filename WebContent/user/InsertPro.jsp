<%@page import="member.MemberDAO"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.sql.Timestamp"%>
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
<h1>jsp4_test/insertpro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String pass1=request.getParameter("pass1");
String gender=request.getParameter("gender");
String email= request.getParameter("email");
String tel=request.getParameter("tel");
String jumin=request.getParameter("jumin");

%>
<jsp:useBean id="mb" class="member.MemberDTO"></jsp:useBean>\
<jsp:setProperty property="*" name="mb"/>
<%
	MemberDAO mdao=new MemberDAO();
	 int check=mdao.juminCheck(jumin);
if(!id.equals("")){
if(pass.equals(pass1)){
	if(check==-1){
	mdao.insertMember(mb);		
	%>
	<script type="text/javascript">
	alert("회원가입성공!")
	location.href="LoginForm.jsp";
	</script>
	<% 
			}else{
				%>
				<script type="text/javascript">
				alert("이미 아이디가 있습니다!")
				location.href="LoginForm.jsp";
				</script>
			<%
			}
	}else{
	%>
		<script type="text/javascript">
		alert("비밀번호가 다릅니다!")
		history.back();
		</script>
	<%
		}
}else{
	%>
	<script type="text/javascript">
	alert("중복체크해주세요!")
	history.back();
	</script>
	<%
}

	%>


</body>
</html>