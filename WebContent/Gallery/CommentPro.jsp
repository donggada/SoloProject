<%@page import="java.sql.Timestamp"%>
<%@page import="Comment.CommentDAO"%>
<%@page import="Comment.CommentDTO"%>
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
request.setCharacterEncoding("UTF-8");
String id=(String)session.getAttribute("id");
int num=Integer.parseInt(request.getParameter("num"));
int idx=Integer.parseInt(request.getParameter("idx"));
String content=request.getParameter("comment");
Timestamp timedate=new Timestamp(System.currentTimeMillis());
if(id!=null){
CommentDTO cdto=new CommentDTO();
CommentDAO cdao=new CommentDAO();
cdto.setContent(content);
cdto.setId(id);
cdto.setIdx(idx);
cdto.setDate(timedate);
cdto.setNum(num);
cdao. insertComment(cdto);
response.sendRedirect("fileCheck.jsp?num="+num);

}else{
%>
<script type="text/javascript">
alert("로그인이필요합니다"); 
location.href="../user/LoginForm.jsp"; 
</script>
<%
}
%>
</body>
</html>