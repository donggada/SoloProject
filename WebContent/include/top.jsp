<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>04_스노우_services</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
</head>


<body>
<%
request.setCharacterEncoding("UTF-8");
String id =(String)session.getAttribute("id"); 
%>
<div id="wrap">
    <div id="header">
    	        <h1 class="logo"><a href="../Main/Main.jsp">SNOW</a></h1>
        <div class="gnb">
            <ul>
               				 <li><a href="../services/services.jsp">Services</a></li>
               				 <li><a href="../DateRoom/DateList.jsp">ReferenceRoom</a></li>
                			 <li><a href="../Gallery/DateList.jsp">Gallery</a></li>
               				 <li><a href="../Mail/MailForm.jsp">Mail</a></li>
               				 <li><a href="../contact/contact.jsp">Contact</a></li>
      <%if(!(id==null)){ %>  <li><a href="../Main/MyPage.jsp">My page</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="../user/LogOut.jsp">LogOut</a></li>
                   <%}else{%><li><a href="../user/LoginForm.jsp">Login</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="../user/InsertForm.jsp">Join</a> </li><%} %>
                 			 
                 		 
            </ul>
               
        												
        </div>
              
        
        
        <div class="language">
            <a href="#" class="btn">한국어<span></span></a>
            <div class="select_list">
                <ul>
                    <li><a href="#">ENGLISH</a></li>
                    <li><a href="#">日本語</a></li>
                    <li class="on"><a href="#">한국어</a></li>
                    <li><a href="#">中文(繁體)</a></li>
                    <li><a href="#">中文(??)</a></li>
                </ul>
            </div>
        </div>
    </div>
    </div>
