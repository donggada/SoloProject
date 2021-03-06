<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>04_스노우</title>
<link href="../css/notosanskr.css" rel="stylesheet">
<link href="../css/comman.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
</head>

<body>



<div id="wrap">
   <jsp:include page="../include/top.jsp"></jsp:include> <!--#header-->
    <div id="container">
        <div class="mainVisual">
            <video width="100%" height="640" autoplay loop muted  poster="img/mv_start.jpg" preload="auto"> 		
                <source src="https://snowcorp.com/snowcorp_/video/snowcorp_201703_sdfsd.mp4" type="video/mp4"> 
                <img src="img/no_support.jpg" width="100%" height="" alt="Your browser does not support the video tag.">
            </video>
            <!--
            * 영상정보를 처리하는 video태그
            <video>
                <source src="비디오경로" type="video/비디오확장자이름">
            </video>

            * video태그의 속성
            autoplay속성 : 브라우저를 열었을 때 영상이 자동으로 재생됨.
            loop속성 : 비디오를 무한반복시킴.
            muted속성 : 음소거.
            poster속성 : 만약 비디오가 멈춰진 상태로 제공될 때 화면에 
                        출력될 대표이미지를 지정
            preload속성 : 만약 비디오가 멈춰진 상태로 제공될 때 영상에 대한
                         정보를 미리 불러올것인가를 설정.

            * video태그 안에 포함 된 img태그의 경우 브라우저에서 비디오가 출력되지 못할 경우 대체해서 사용될 이미지를 저장시켜놓음.
        -->
            <div class="bg1"></div>
            <div class="bg2"></div>
        </div> <!--.mainVisual-->
        <div class="mainInfo">
            <h3>SNOW Corp.</h3>
            <div class="box">
                <p>
                    스노우는 2015년 9월 서비스 출시 이후 한국, 일본, 대만을 비롯한 아시아 시장에서 폭발적 성장을 바탕으로, 출시 이후 약 1년 반만에 1억 가입자를 달성했습니다.
                    <br>
                    우리는 가장 재미있고 편리하게 소통할 수 있는 방식을 스노우를 통해 만들어 나가고 있습니다.
                    <br>
                    자신을 표현하고, 즐거운 순간을 공유하며, 함께하는 듯한 생생함을 전달하기 위해 오늘도 치열하게 가슴 뛰는 도전을 펼치고 있습니다.
                </p>
                <a href="services/services.jsp" target="_blank">서비스 보기</a>
            </div>
        </div> <!--.mainInfo-->
        <div class="mainCareer">
            <div class="inner">
                <h3>Gallery</h3>
                <div class="box">
                    <p>
                        사용자 니즈에 민감하게 반응하며, 변화에 누구보다 앞서 대응하고
                        <br>
                        도전을 주저하지 않고, 가장 빠르게 생각하고 움직이는 사람들과 함께합니다.
                        <br>
                        사람들의 소통 방식을 더욱 즐겁게 표현하고, 순간을 공유하는 스노우에 지금 지원해보세요!
                    </p>
                    <a href="../Gallery/DateList.jsp" target="_blank">지원하기</a>
                </div>
            </div>
        </div> <!--.mainCareer-->
        <div class="mainNews">
            <h3>NEWS</h3>
            <div class="list">
                <ul>
                    <li><a href="#">
                        <p class="title">동영상 메신저 스노우(SNOW), 일본 10대 사이에서 가장 유행하는 앱 1위 선정</p>
                        <p class="date">2017.04.03</p>
                        <p class="memo">최근 가입자 수가 5천만 명을 돌파하며 아시아 시장에서 돌풍을 일으키고 있는 동영상 메신저 스노우가 닛케이 신문과 리서치 회사 모니타스가 발표한...</p>
                    </a></li>
                    <li><a href="#">
                        <p class="title">동영상 메신저 스노우(SNOW), 아시아의 차세대 메시징 트렌드로 떠올라</p>
                        <p class="date">2017.04.03</p>
                        <p class="memo">WSJ, 아시아 지역 메신저 시장에서 스노우의 순조로운 성장세 주목. 일본, 한국 등 10대 이용자 다수… 중국 시장에서도 꾸준한 성장세</p>
                    </a></li>
                </ul>
            </div>
        </div> <!--.mainNews-->
    </div> <!--#container-->
    <jsp:include page="../include/bottom.jsp"></jsp:include>
</div>
<script type="text/javascript">
function Login() {
	function idcheck() {
		  window.open("", "pop3", 'width=600, height=500, fullscreen=no scrollbars=no, status=yes'); 
		fr.target = "pop3"; 
		  fr.submit();    
	}
}
</script>
</body>
</html>