
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
<link href="../css/content.css" rel="stylesheet">
</head>
<body>
<%
String id=(String)session.getAttribute("id");
request.setCharacterEncoding("UTF-8");
String a=request.getParameter("type");
if(a==null){a="0";}
int type=Integer.parseInt(a);

ImgDateDAO ddao=new ImgDateDAO();
String likeco=request.getParameter("num");
if(likeco==null){likeco="0";}
int num=Integer.parseInt(likeco);
ddao.likecount(num);// 좋아요
ArrayList<ImgDataDTO> arr= new ArrayList<ImgDataDTO>(); //리스트

int count=ddao.getdateCount();

int pageSize=6;
								
String pageNum= request.getParameter("pageNum");

if(pageNum==null){
	pageNum="1";
}
// pageNum -> 정수형 
int currentPage=Integer.parseInt(pageNum);

int startRow= (currentPage-1)*pageSize;

int endRow=currentPage*pageSize;

ArrayList<ImgDataDTO> list=null;

String TY="";
switch(type){
case 0: TY="전체"; break;
case 1: TY="SHOW";break;
case 2: TY="Foodie";break;
case 3: TY="B612";break;
case 4: TY="Looks";break;
case 5: TY="LINE CAMERA";break;
}
arr=ddao.ImgUploadList(startRow,pageSize,type);
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
                            <li><a href="DateList.jsp?type=0">전체</a></li>                       
                            <li><a href="DateList.jsp?type=1">SNOW</a></li>
                            <li><a href="DateList.jsp?type=2">Foodie</a></li>
                            <li><a href="DateList.jsp?type=3">B612</a></li>
                            <li><a href="DateList.jsp?type=4">Looks</a></li>
                            <li><a href="DateList.jsp?type=5">LINE CAMERA</a></li>                         
                        </ul>
                    </div>
                </div>
                <div class="set_btn">
                    <a href="MyList.jsp?id=<%=id %>" class="myApply">
                        <span> </span>
                        내가올린 게시물 찾기 
                    </a>
                    <a href="fileUploadForm.jsp" class="apply_qna">
                        <span></span>
                        게시물올리기 
                    </a>
                </div>
            </div> <!--.set_area-->
     <table class="b">
 <%int x=0 ,y=0;
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
			<tr><th colspan="2"><%=qwe%></th></tr>
			<tr><th><a href="../Gallery/fileCheck.jsp?num=<%=ddto.getNum()%>"><%=ddto.getSubject() %></a></th><th><%=ddto.getId() %></th></tr>			
			<tr><th colspan="2"><a href="../Gallery/fileCheck.jsp?num=<%=ddto.getNum()%>"><img src="../GalleryDate/<%=ddto.getOriginalName1()%>" width="350" height="350"></a></th></tr>
			<tr><th><a href="../Gallery/DateList.jsp?num=<%=ddto.getNum()%>"><button><img src="../img/common-2.jpeg" width="15" height="15"></button></a></th><th>좋아요 <%=ddto.getLikecount() %>개</th></tr>
		
	</table>      
	</td>	                                                
  <%
  if(y==2){
	  %></tr><%
		x=0;
	}  
} %>
  </table> 
      <%
  int pageCount= count/pageSize+(count%pageSize==0?0:1);

  int pageBlock=2;

  int startPage= (currentPage-1)/pageBlock*pageBlock+1;

  int endPage= startPage + pageBlock -1;

  if(endPage > pageCount){
  	endPage=pageCount;
  }
  %><div class="centerline"><%
  if(startPage > pageBlock){
  	%><a href="DateList.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a><%
  }


  for(int i=startPage;i<=endPage;i++){
  	%> <a class="btn"href="DateList.jsp?pageNum=<%=i%>"><%=i%></a> <%
  }


  if(endPage < pageCount){
  	%><a href="DateList.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a><%
  }
  
  %>           
  
   </div>      
   <br>
   <jsp:include page="../include/bottom.jsp"/>
</body>
</html>

</body>
</html>