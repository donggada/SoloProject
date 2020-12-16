
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Comment.CommentDTO"%>
<%@page import="Comment.CommentDAO"%>
<%@page import="ImgDate.ImgDataDTO"%>
<%@page import="ImgDate.ImgDateDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일체크 JSP 페이지</title>
</head>
 <%
 request.setCharacterEncoding("UTF-8");
	int num=Integer.parseInt(request.getParameter("num"));
	String id=(String)session.getAttribute("id");
SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm");
 %>
 <jsp:include page="../include/top.jsp"></jsp:include>
    <div id="container">
        <div class="subTop">
            <h2>Gallery</h2>
        </div>
   
    <%
        // post방식에 대한 한글 인코딩 방식 지정 get방식은 서버의 server.xml에서 Connector태그에 URIEncoding="UTF-8" 추가
      
   System.out.print(num);
    
    ImgDateDAO ddto=new ImgDateDAO();
    ArrayList arr= new ArrayList();
    
    arr=ddto.ImgLook(num);
         for(Object o:arr){
        	 ImgDataDTO dd= (ImgDataDTO)o;
         
        // input type="name" 의 value값을 가져옴
        String name =dd.getName() ;
        // input type="subject" 의 value값을 가져옴
        String subject = dd.getSubject();
        // 중복방지용으로 만들어져 넘겨진 파일명을 가져옴
        String fileName1 = dd.getFileName1();
        // 본래의 파일명을 가져오
        String originalName1 =dd.getOriginalName1();
  %>
  <table border="1">
  <tr><th colspan="4"><%=dd.getSubject() %></th></tr>
<tr><th>ID</th><th><%=dd.getId() %></th><th>조회수</th><th><%=dd.getReadcount() %></th></tr>
<tr><th colspan="3"><a id="downA" href="#">이미지다운받기</a></th><th>좋아요 <%=dd.getLikecount() %>개</th></tr>
<tr><th colspan="4"><a href="../GalleryDate/<%=originalName1%>"><img src="../GalleryDate/<%=originalName1%>" width="600" height="700"/></a> </th></tr>
</table>   
     
     
    <!-- 파일 다운로드 링크 클릭시 다운로드 될 수 있도록 fileDown1.jsp 페이지에서 처리 뒤에 쿼리문자열을 통해 중복 방지용 이름 fileName1 값을 같이 넘겨준다. -->
     
    
    <script type="text/javascript">
        // 영문파일은 그냥 다운로드 클릭시 정상작동하지만 한글파일명을 쿼리문으로 날릴경우 인코딩 문제가 발생할 수 있다. 한글이 깨져 정상작동하지 않을 수 있음
        // 따라서, 쿼리문자열에 한글을 보낼 때는 항상 인코딩을 해서 보내주도록 하자.
        document.getElementById("downA").addEventListener("click", function(event) {
            event.preventDefault(); // a 태그의 기본 동작을 막음
            event.stopPropagation(); // 이벤트의 전파를 막음
            // fileName1을 utf-8로 인코딩한다.
            var fName = encodeURIComponent("<%=originalName1%>");
            // 인코딩된 파일이름을 쿼리문자열에 포함시켜 다운로드 페이지로 이동
            window.location.href = "fileDown1.jsp?file_name="+fName;
        });
      
         
        
    </script>
    
<%
}
%>
<br><br><br><br><br><br><br>
<%
CommentDAO cdao=new CommentDAO();
ArrayList arr2= new ArrayList();
arr2=cdao.selectcomment(num,2);
for(Object o:arr2){ CommentDTO cdto=(CommentDTO)o;
%>
<hr>
<table>
<tr><td>ID</td><td><%=cdto.getId() %></td></tr>
<tr><td><%=cdto.getContent() %></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%=sdf.format(cdto.getDate()) %></td></tr>
</table>

<%
}
%>
<hr>
<form action="CommentPro.jsp" method="post">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="idx" value="<%=2%>">
<textarea rows="2" cols="20" name="comment"></textarea> <input type="submit" value="댓글달기">
</form>