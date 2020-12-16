
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
</head>
<body>
   <div id="container">
        <div class="subTop">
            <h2>로그인</h2>
        </div>
<form action="LoginPro.jsp" method="post">
아이디:<input type="text" name="id"><br>
비밀번호:<input type="password" name="pass"><br>

<input type="submit" value="로그인"><br>
<input type="button" value="아이디찾기"  onclick="IdFind()"><input type="button" value="비밀번호찾기"  onclick="PassFind()"><br>
<input type="button" value="회원가입"  onclick="location.href='InsertForm.jsp'">
</form>
<script type="text/javascript">
function IdFind() {
	  window.open("IDFindForm.jsp", "pop1", ' top=150,left=500 width=600, height=500, fullscreen=no scrollbars=no, status=yes'); 
	fr.target = "pop1";
}
function PassFind() {
	  window.open("PassFindForm.jsp", "pop2", ' top=150,left=500 width=600, height=500, fullscreen=no scrollbars=no, status=yes'); 
	fr.target = "pop2";
}

</script>
</body>
</html>
