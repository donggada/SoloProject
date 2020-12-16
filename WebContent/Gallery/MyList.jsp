
<%@page import="ImgDate.ImgDataDTO"%>
<%@page import="ImgDate.ImgDateDAO"%>
<%@page import="java.util.ArrayList"%>

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
String id=(String)session.getAttribute("id");
request.setCharacterEncoding("UTF-8");
String a=request.getParameter("type");
String likeco=request.getParameter("num");
if(id==null){%><script type="text/javascript">alert("로그인이필요합니다");location.href="../user/LoginForm.jsp";</script>	<%}
if(likeco==null){likeco="0";}
int num=Integer.parseInt(likeco);

if(a==null){a="0";}
int type=Integer.parseInt(a);
ImgDateDAO ddao=new ImgDateDAO();
ddao.likecount(num); //좋아요 
ArrayList<ImgDataDTO> arr= new ArrayList<ImgDataDTO>(); //리스
int i=0,j=0;
String TY="";
switch(type){
case 0: TY="전체"; break;
case 1: TY="SHOW";break;
case 2: TY="Foodie";break;
case 3: TY="B612";break;
case 4: TY="Looks";break;
case 5: TY="LINE CAMERA";break;

};

arr=ddao.myloadList(type,id);
%>
<jsp:include page="../include/top.jsp"/><!--#header-->
    <div id="container">
        <div class="subTop">
            <h2>Gallery</h2>
        </div>
        <div class="career">
            <div class="set_area">
                <div class="selectBox">
                    <a href="#" class="btn">
                        <%=TY %>
                        <span></span>
                    </a>
                    <div class="sel_list">
                        <ul>
                        	
                        	<li><a href="MyList.jsp?type=0">내가올린게시물전체보기 </a></li>
                            <li><a href="MyList.jsp?type=1">SNOW</a></li>
                            <li><a href="MyList.jsp?type=2">Foodie</a></li>
                            <li><a href="MyList.jsp?type=3">B612</a></li>
                            <li><a href="MyList.jsp?type=4">Looks</a></li>
                            <li><a href="MyList.jsp?type=5">LINE CAMERA</a></li>                         
                        </ul>
                    </div>
                </div>
                <div class="set_btn">
                    <a href="DateList.jsp" class="myApply">
                        <span> </span>
                        전체게시물 보기
                    </a>
                    <a href="fileUploadForm.jsp" class="apply_qna">
                        <span></span>
                        게시물올리기 
                    </a>
                </div>
            </div> <!--.set_area-->
            <div class="list_area">
            <table>
                <%int x=0,y=0;
for(Object o:arr){ ImgDataDTO  ddto=(ImgDataDTO)o; y++;
if(x==0){
	%><tr><%
	x++; y=0;
}
int qwen=ddto.getType();
String qwe="";
switch(qwen){
case 1: qwe="SHOW";break;
case 2: qwe="Foodie";break;
case 3: qwe="B612";break;
case 4: qwe="Looks";break;
case 5: qwe="LINE CAMERA";break;
}
%>	      
	<td>
	<table border="1">
			<tr><th><a href="../Gallery/fileCheck.jsp?num=<%=ddto.getNum()%>"><%=ddto.getSubject() %></a></th><th><%=ddto.getId() %></th></tr>
			<tr><th colspan="2"><%=qwe%></th></tr>
			<tr><th colspan="2"><a href="../Gallery/fileCheck.jsp?num=<%=ddto.getNum()%>"><img src="../GalleryDate/<%=ddto.getOriginalName1()%>" width="350" height="350"></a></th></tr>
			<tr><th><input type="button" value="Like" onclick="location.href='MyList.jsp?num=<%=ddto.getNum()%>'"></th><th>좋아요 <%=ddto.getLikecount() %>개</th></tr>

	</table>      
	</td>	                                                
  <%
  if(y==2){
	  %></tr><%
		x=0;
	}  
} %>
  </table>                                                       
                                                            
             
         
    </div> <!--#container-->
   <jsp:include page="../include/bottom.jsp"/>
</body>
</html>

</body>
</html>