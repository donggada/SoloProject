
<%@page import="member.MemberDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Driver"%>
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
<h1>jsp5Member/updatepro.jsp</h1>


<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
String pass=request.getParameter("pass");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
String email= request.getParameter("email");
String tel=request.getParameter("tel");
String address=request.getParameter("address");

int check=-1;

MemberDAO mdao=new MemberDAO();
check=mdao.userCheck(id, pass);

if (check==1){
%>
<jsp:useBean id="m"  class="member.MemberDTO"/>
<jsp:setProperty property="*" name="m"/>
<%
mdao.updateMember(m);
	%><script type="text/javascript">
	alert("수정완료");
	window.close();
	</script><%
}if(check==0){
	%>
	<script type="text/javascript">
	alert("비밀번호를 확인해주세요");
	history.back();
	</script>
	<% }
if(check==-1)
          {%>
	<script type="text/javascript">
	alert("아이디가 없습니다");
	history.back();
	</script>
	<% 	
}
%>
</body>
</html>