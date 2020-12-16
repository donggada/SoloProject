<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../include/top.jsp"></jsp:include>
<div id="container">
        <div class="subTop">
            <h2>회원탈퇴</h2>
        </div>
<form action="Deletepro.jsp" method="post">
비밀번호:<input type="password" name="pass"><br>
<input type="submit" value="확인 ">
</form>
</body>
</html>