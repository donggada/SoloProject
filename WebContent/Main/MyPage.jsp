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
String id=(String)session.getAttribute("id");
if(id==null){
	response.sendRedirect("../user/LoginForm.jsp");
}
%>
<jsp:include page="../include/top.jsp"></jsp:include>
<div id="container">
        <div class="subTop">
            <h2>나의페이지</h2>
        </div>
        <%if(id!=null){
if(id.equals("admin")){%>
<a href="List.jsp"><input type="button" value="회원목록"></a><br>
<%}
}%> 
<input type="button" value="나의정보" onclick="MyInfo()"><br>
<input type="button" value="회원정보수정  " onclick="update()"><br>
<a href="DeleteForm.jsp"><input type="button" value="회원정보삭제"></a><br>
<input type="button" value="로그아웃 "  onclick="location.href='../user/LogOut.jsp'">
<jsp:include page="../include/bottom.jsp"></jsp:include>

<script type="text/javascript">
function MyInfo() {
	  window.open("MyInfo.jsp", "pop1", ' top=150,left=500 width=600, height=500, fullscreen=no scrollbars=no, status=yes'); 
	fr.target = "pop1";
}

function update() {
	  window.open("UpdateForm.jsp", "pop2", ' top=150,left=500 width=600, height=600, fullscreen=no scrollbars=no, status=yes'); 
	fr.target = "pop2";
}



</script>
</body>
</html>