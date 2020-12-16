<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String pass1=request.getParameter("pass1");
MemberDAO mdao=new MemberDAO();
if(pass.equals(pass1)){
%>
<jsp:useBean id="mb" class="member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="mb"/>
<%
mdao.passupdate(pass, id);
%>
<script type="text/javascript">
alert("비밀번호 수정완료!");
window.close();
</script>
<%
}else{
	%>
	<script type="text/javascript">
	alert("비밀번호가 다릅니다");
	history.back();
	</script>
	<%
}
%>
</body>
</html>