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
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
</head>
<body>
<div id="container">
        <div class="subTop">
            <h2>아이디찾기</h2>
        </div>
<form action="IDFindPro.jsp" method="post">
이름:<input type="text" name="name"><br>
주민등록번호:<input type="text" name="jumin"><br>
<input type="submit" value="아이디찾기">
</form>
</body>
</html>