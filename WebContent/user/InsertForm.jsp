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
<%request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id"); 
String roadFullAdd=request.getParameter("roadFullAdd");
if(id==null){
	id="";
} 
%>
  <div id="container">
        <div class="subTop">
            <h2>회원가입</h2>
        </div>
<form action="OverLapCheck.jsp" method="post">
아이디:<input type="text" name="id" value="<%=id%>"> <input type="submit" value="중복체크 ">
</form>
<form action="InsertPro.jsp" method="post" name="insert">
<input type="hidden" name=id value="<%=id%>">
비밀번호:<input type="password" name="pass"><br>
비밀번호확인:<input type="password" name="pass1"><br>
이름:<input type="text" name="name"><br>
주민등록번호:<input type="text" name="jumin"><br>
성별:<input type="radio" name="gender" value="men">남자
	<input type="radio" name="gender" value="women">여자<br>
주소:<input type="text" style="width:500px" name="address" id=address value="">  <input type="button" value="주소검색" onclick="goPopup()"><br>
전화번호:<input type="tel" name="tel"><br>
이메일:<input type="text" name="email"><br>
<input type="submit" value="회원가입">
</form>
<script type="text/javascript">
function goPopup(){

	var pop = window.open("../JUSO/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	
}

function jusoCallBack(roadFullAddr){
	
	document.insert.address.value=roadFullAddr;
}

function idcheck() {
	  window.open("OverLapCheck.jsp", "pop", 'width=600, height=500, fullscreen=no scrollbars=no, status=yes'); 
	fr.target = "pop"; 
	  fr.fid.submit("OverLapCheck.jsp"); 
   
   
   
}
</script>
<script type="text/javascript">

</script>
<jsp:include page="../include/bottom.jsp"></jsp:include>
</body>
</html>





