<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reference Room</title>
</head>
<center>
<%
request.setCharacterEncoding("UTF-8");
String id=(String)session.getAttribute("id");
if(id==null){
	%>
	<script type="text/javascript">
	alert("로그인이필요합니다");
	location.href="../user/LoginForm.jsp";
	</script>
	<%
}


%>

    <!--
        파일업로드를 위해선 반드시 method="post" enctype="Multipart/form-data"여야함!
     -->
      <jsp:include page="../include/top.jsp"></jsp:include>
      <div id="container">
        <div class="subTop">
            <h2>REFERENCE ROOM</h2>
            </div>
    <form action="../DateRoom/fileUpload.jsp" method="post" enctype="Multipart/form-data">
        <input type="hidden" name="name" value="<%=id %>" /><br/>
        제목<br><input type="text" name="subject" /><br>
        내용<br/><textarea rows="8" cols="18" name="content"></textarea><<br>
        <!--
            파일 업로드는 input type="file"로 지정한다.
         -->
        파일명1 : <input type="file" name="fileName1" /><br/>
        <input type="submit" value="전송" />  
        <input type="reset" value="취소" />
    </form>
</center>

 <jsp:include page="../include/bottom.jsp"></jsp:include>