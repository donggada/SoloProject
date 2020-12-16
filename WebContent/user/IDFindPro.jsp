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
<title>비밀번호찾기</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");	
String name = request.getParameter("name");
String jumin = request.getParameter("jumin");

MemberDAO mdao=new MemberDAO();
MemberDTO mdto=mdao.IDFind(jumin, name);
if(mdto.getIDoverLapcheck().equals("찾음")){
	String id=mdto.getId() + ".";
	int checkidnum = id.length() - 3;
	String subst = id.substring(checkidnum);
	String Lookid = id.replace(subst, "**");
%>
<input type="text" value="<%=Lookid%>"><br>
<input type="button"  value=" 확인" onclick="window.close()">
<%
	}
	if(mdto.getIDoverLapcheck().equals("이름다름")){
	%>
	<script type="text/javascript">
	alert("이름,주민번호를 입력해주세요");
	history.back();
	</script>	
	<%
		}
if(mdto.getIDoverLapcheck().equals("아이디없음")){
	%>
	<script type="text/javascript">
	alert("주민번호가 다릅니다");
	history.back();
	</script>	
	<%
}
%>




</body>
</html>