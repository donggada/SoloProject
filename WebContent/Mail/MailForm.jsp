<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../include/top.jsp"></jsp:include>

<div id="container">
        <div class="subTop">
            <h2>Mail</h2>
        </div>
        <div class="news">
        </div>
    </div> <!--#container-->
    <div>
        <form action="SendMail.jsp" method="post">
            <table>
                <tr><th colspan="2">건의사항</th></tr>
                <tr><td>보내는메일</td><td><input type="text" name="from" value="@naver.com"></td></tr>
                 <tr><td>비밀번호</td><td><input type="password" name="pass" /></td></tr>
                <tr><td>대표메일</td><td><input type="text" name="to" value="koem0425@naver.com" /></td></tr>
                <tr><td>제목</td><td><input type="text" name="subject" /></td></tr>
                <tr><td>내용</td><td><textarea name="content" style="width:170px; height:200px;"></textarea></td></tr>
                <tr><td colspan="2" style="text-align:right;"><input type="submit" value="보내기"/></td></tr>
            </table>
        </form>
    </div>
</body>
</html>

