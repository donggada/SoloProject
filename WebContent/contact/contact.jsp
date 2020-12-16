<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CONTACT</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/sub.css" rel="stylesheet">
</head>

<jsp:include page="../include/top.jsp"></jsp:include> <!--#header-->
    <div id="sub_img">
    	<div class="sub_img_in">
        	<h2 class="contact">contact</h2>
        </div>
    </div>
    <div id="sub_contents">
    	<div class="contact_info">
        	<div class="info_box">
            	<h3>찾아오시는 길</h3>
                <p class="cont01">경기도 성남시 분당구 대왕판교로 644번길 49<br>
DTC타워 9층, 13493</p>
                <p class="info_email"><em>e-mail : <a href="mailto:support@snow.me">support@snow.me</a></em></p>
            </div>
            <div class="info_box">
            	<h3>제휴 제안</h3>
                <p class="cont01">스노우와 다양한 협업을 통해 내일의 <br>
새로운 가능성을 만나보세요.</p>
                <a href="" class="btn_info">제휴제안</a>
            </div>
        </div>
        <div class="map">
        	<!-- * Daum 지도 - 지도퍼가기 -->
<!-- 1. 지도 노드 -->
<div id="daumRoughmapContainer1543805323918" class="root_daum_roughmap root_daum_roughmap_landing"></div>

<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>

<!-- 3. 실행 스크립트 -->
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1543805323918",
		"key" : "r6i3",
		"mapWidth" : "711",
		"mapHeight" : "400"
	}).render();
</script>
        </div>
    </div>
   <jsp:include page="../include/bottom.jsp"></jsp:include>







</body>
</html>