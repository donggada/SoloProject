
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
<title>Insert title here</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div id="container">
        <div class="subTop">
            <h2>나의정보</h2>
        </div>
        
<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("id");

MemberDAO mdao=new MemberDAO();
MemberDTO bb=mdao.getmember(id);

%>
<table border="1">
<tr><td colspan="6">아이디</td></tr>
<tr><td colspan="6"><%=bb.getId()%></td></tr>
<tr><td colspan="2">이름</td><td colspan="2">주민등록번호</td><td colspan="2">성별</td></tr>
<tr><td colspan="2"><%=bb.getName() %></td><td colspan="2"><%=bb.getJumin()%></td><td colspan="2"><%=bb.getGender()%></td></tr>
<tr><td colspan="3">전화번호</td><td colspan="3">email</td></tr>
<tr><td colspan="3"><%=bb.getTel()%></td><td colspan="3"><%=bb.getEmail() %></td></tr>


</table>
<input type="button" value="확인" onclick="window.close()">
<script type="text/javascript">
function name() {
	
}
</script>
</body>
</html>