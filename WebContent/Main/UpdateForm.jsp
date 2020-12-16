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
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");

MemberDAO mdao=new MemberDAO();
MemberDTO mdto=mdao.getmember(id);







%>
<jsp:include page="../include/top.jsp"></jsp:include>
<div id="container">
        <div class="subTop">
            <h2>회원정보수정</h2>
        </div>
<form action="UpdatePro.jsp" method="post" name="fr">
아이디:<input type="text" name="id" value="<%=id%>" readonly="readonly"><br>
비밀번호:<input type="password" name="pass"><br>
이름:<input type="text" name="name"value="<%=mdto.getName()%>"><br>
주소:<input type="text" style="width:500px" name="address" id=address value="<%=mdto.getAddress()%>"><input type="button" value="주소검색" onclick="goPopup()"><br>
전화번호:<input type="tel" name="tel" value= "<%=mdto.getTel()%>" ><br>
이메일:<input type="text" name="email" value= "<%=mdto.getEmail()%>"><br>
<input type="submit" value="회원수정">
</form>
<script type="text/javascript">
function goPopup(){

	var pop = window.open("../JUSO/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	
}

function jusoCallBack(roadFullAddr){
	
	document.fr.address.value=roadFullAddr;
}
</script>
</body>
</html>