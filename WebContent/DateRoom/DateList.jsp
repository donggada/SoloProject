<%@page import="DateRoom.DateRoomDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DateRoom.DateRoomDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>04_스노우_career</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
<link href="../css/content.css" rel="stylesheet">
</head>

<body>

<%
request.setCharacterEncoding("UTF-8");
DateRoomDAO bdao=new DateRoomDAO();

int count=bdao.getdateCount();

int pageSize=3;
								
String pageNum= request.getParameter("pageNum");

if(pageNum==null){
	pageNum="1";
}
// pageNum -> 정수형 
int currentPage=Integer.parseInt(pageNum);

int startRow= (currentPage-1)*pageSize
;

int endRow=currentPage*pageSize;

ArrayList<DateRoomDTO> list=null;

%>
<jsp:include page="../include/top.jsp"/><!--#header-->

         <div id="container">
        <div class="subTop">
            <h2>ReferenceRoom</h2>
        </div>
        <div class="career">
            <div class="set_area">                            
 				<div class="set_btn">
                    <a href="fileUploadForm.jsp" class="apply_qna">
                        <span></span>
                        게시물올리기 
                    </a>
                </div>
            </div> <!--.set_area-->
            <div class="list_area">
            <table>
      
       <%list=bdao.DateList(startRow,pageSize);
for(int i=0;i<list.size();i++){
	DateRoomDTO bb=list.get(i);%>

         <div class="list_area">
                <ul>
                    <li>
                    <div class="list_tab">
                            <p class="title"><%=bb.getNum()%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="fileCheck.jsp?num=<%=bb.getNum()%>"><%=bb.getSubject() %></a></p>                     	   
                    	    <p class="date">작성자 <%=bb.getName() %>  조회수 <%=bb.getReadcount() %></p>
                            <p class="icon"></p>
                            </div>
                            </li>
                            </ul>                                                 
                            </div>                            
                        <%}
                               
           

int pageCount= count/pageSize+(count%pageSize==0?0:1);

int pageBlock=3;

int startPage= (currentPage-1)/pageBlock*pageBlock+1;

int endPage= startPage + pageBlock -1;

if(endPage > pageCount){
	endPage=pageCount;
}
%><div class="centerline">
<%
if(startPage > pageBlock){
	%><a href="DateList.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a><%
}


for(int i=startPage;i<=endPage;i++){
	%> <a href="DateList.jsp?pageNum=<%=i%>"><%=i%></a> <%
}


if(endPage < pageCount){
	%><a href="DateList.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a><%
}
%>

   </div>      
   <br>
<!--#container-->
   <jsp:include page="../include/bottom.jsp"/>
</body>
</html>