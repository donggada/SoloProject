<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gallery</title>
</head>
 
<center>
<%
request.setCharacterEncoding("UTF-8");
String id=(String)session.getAttribute("id");
if(id==null){
%><script type="text/javascript">

alert("로그인인 필요합니다");
location.href="../user/LoginForm.jsp";
</script>

<%
}


%>
<jsp:include page="../include/top.jsp"/><!--#header-->
    <div id="container">
        <div class="subTop">
            <h2>Gallery</h2>
        </div>

    <!--
        파일업로드를 위해선 반드시 method="post" enctype="Multipart/form-data"여야함!
     -->
    <form action="../Gallery/fileUpload.jsp" method="post" enctype="Multipart/form-data">
        <input type="hidden" name="id" value="<%=id%>">
        제목        : <input type="text" name="subject" /><br/>
        내용        : <input type="text" name="content" /><br/>
        <!--
            파일 업로드는 input type="file"로 지정한다.
         --> 
         <select name="type">
         <option value="">사진종류선택</option>
         <option value="1">SNOW</option>
         <option value="2">Foodie</option>
         <option value="3">B612</option>
         <option value="4">Looks</option>
         <option value="5">LINE CAMERA</option>
         </select>
       사진파일  : <input type="file" name="fileName1" /><br/>
        <input type="submit" value="전송" />  
        <input type="reset" value="취소" />
    </form>
</center>

<jsp:include page="../include/bottom.jsp"></jsp:include>