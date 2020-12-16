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
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String jumin = request.getParameter("jumin");
	 int check=-1;
	MemberDAO mdao=new MemberDAO();
	check=mdao.PassFind(id, jumin, name);
	if(check==2){
		%>
		<script type="text/javascript">
		location.href="PassUpdateForm.jsp?id=<%=id%>";
		</script>
		<%
		
	}
if(check==1){
	%>
	<script type="text/javascript">
	alert("이름이 다릅니다");
	history.back();
	</script>
	<%
	}
if(check==0){
	%>
	<script type="text/javascript">
	alert("주민번호가 다릅니다");
	history.back();
	</script>
	<%
}
if(check==-1){
	%>
	<script type="text/javascript">
	alert("아이디가 다릅니다");
	history.back();
	</script>
	<%
}
	
	
	%>




</body>
</html>