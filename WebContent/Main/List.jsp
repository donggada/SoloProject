<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="member.MemberDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

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
<jsp:include page="../include/top.jsp"></jsp:include>
<div id="container">
        <div class="subTop">
            <h2>회원목록</h2>
        </div>
<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
if(id==null){
	response.sendRedirect("../User/LoginForm.jsp");
}else if(!(id.equals("admin"))){
	response.sendRedirect("Main.jsp");
}
MemberDAO mdao=new MemberDAO();
ArrayList list=mdao.selectMember();
int count=mdao.getMember();
int pageSize=5;

String pageNum= request.getParameter("pageNum");

if(pageNum==null){
	pageNum="1";
}

int currentPage=Integer.parseInt(pageNum);

int startRow= (currentPage-1)*pageSize;

int endRow=currentPage*pageSize;

%>
<table><tr><th>회원수</th><th><%=count %>명</th><tr></table>
<table border="1">
<tr><td>아이디</td><td>이름</td> <td>주민번호</td> </tr>
<% for(Object o:list){   
	MemberDTO mb=(MemberDTO)o;
	%>
<tr><td><%=mb.getId() %></td><td><%=mb.getName() %></td><td><%=mb.getJumin() %></td></tr>

<%}%>

</table>

<%
int pageCount= count/pageSize+(count%pageSize==0?0:1);

int pageBlock=3;

int startPage= (currentPage-1)/pageBlock*pageBlock+1;

int endPage= startPage + pageBlock -1;

if(endPage > pageCount){
	endPage=pageCount;
}

if(startPage > pageBlock){
	%><a href="List.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a><%
}


for(int i=startPage;i<=endPage;i++){
	%> <a href="List.jsp?pageNum=<%=i%>"><%=i%></a> <%
}


if(endPage < pageCount){
	%><a href="List.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a><%
}

%>  
<br>
<input type="button"  value="뒤로가기" onclick="history.back();">
</body>
</html>