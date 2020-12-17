# SoloProject
RentCar-Service 
===
<img width="600" alt="스크린샷 2020-11-08 오후 7 27 42" src="https://user-images.githubusercontent.com/68542404/98462578-988e4a00-21f8-11eb-9b38-423c168a2c85.png">

## 목차
  1. [프로그램 목표](#프로젝트-목표)
  1. [프로그램 핵심기능](#프로젝트-핵심기능)
  1. [개발환경](#개발환경)
  1. [데이터베이스](#데이터베이스)
  1. [기능구현](#기능구현)
---


## 프로젝트 목표
* **간편하게 서비스 이용가능** : 간편하게 차량대여가 가능한 렌트카 서비스가 목적
* **코로나 위험지역 인지** : 렌트카를 빌리는 고객이 위험지역을 인지할 수 알려줌
* **데이터 시각화** : 관리자에게 서비스 데이터를 시각적 그래프로 보여 줌 

---


## 프로젝트 핵심기능
* **SNS 아이디로 로그인(카카오톡,네이버 )** : 회원가입 없이 서비스를 이용가능 
* **코로나 지도** : 지도를 통해 현재 코로나 감염자 수를 시각화로 표현
* **매출그래프** :매출을 그래프로 표현
* **결제 서비스** : 카드와 무통장입금으로 결제가능
---


## 개발환경
- 언어
  - Java EE
  - HTML5 / CSS3
  - JavaScript 'ES5'

- 프레임 워크
  - Jquery v.3.2.1
  - Bootstrap
    
- 서버
  - Apach Tomcat v8.5   

- 개발도구
  - Eclipse -JEE -Mars -2
  - MySQL WorkBench
  - Github  
---
## 데이터베이스
<img width="600" alt="스크린샷 2020-11-08 오후 2 50 38" src="https://user-images.githubusercontent.com/68542404/98458288-62d66a80-21d2-11eb-960a-eca594077f28.png">


## 기능구현
 - [SNS 로그인](#SNS-로그인)
 - [코로나 지도](#코로나-지도)
 - [결제 서비스](#결제-서비스)
 - [매출 그래프](#매출-그래프)
 - [실시간 채팅 & FAQ](#실시간-채팅-&-FAQ)


 ## SNS 로그인
 - Kakao , Naver 로그인 API 를 이용하여 로그인 기능을 구현
<img width="600" alt="스크린샷 2020-11-09 오후 2 30 52" src="https://user-images.githubusercontent.com/68542404/98503679-7e0bad80-2298-11eb-9ca4-410bb14aa9d2.png">

 
- 해당 사이트 로그인 성공시 고유 값을 아이디값으로 받아 DB에 저장후 로그인 수행
<img width="600" alt="스크린샷 2020-11-09 오후 2 32 36" src="https://user-images.githubusercontent.com/68542404/98503852-e35f9e80-2298-11eb-9717-c4f6b273e767.png">


## 코로나 지도
- 공공데이터 코로나 확진자 데이터를 파싱하여 확진자 수 에 따라 지도에 색깔별로 표기
 <img width="600" alt="스크린샷 2020-11-08 오후 5 06 38" src="https://user-images.githubusercontent.com/68542404/98460144-f153e780-21e4-11eb-8c4c-becd9ffd0302.png">

 
 ## 결제 서비스
  - 이니시스 결제 API 사용하여  결제서비스 구현(신용카드,무통장)
  <img width="600" alt="스크린샷 2020-11-08 오후 5 56 10" src="https://user-images.githubusercontent.com/68542404/98461122-fddc3e00-21ec-11eb-99a3-f03312884506.png">
  <img width="600" alt="스크린샷 2020-11-08 오후 5 59 04" src="https://user-images.githubusercontent.com/68542404/98461120-f9178a00-21ec-11eb-954a-ad36209803b0.png">
  
  


## 매출 그래프 


 - 예약 데이터를  받아  매출금액을  선,막대 그래프로 구현
  <img width="600" alt="스크린샷 2020-11-08 오후 5 26 33" src="https://user-images.githubusercontent.com/68542404/98460513-7bea1600-21e8-11eb-911e-e804f5c9102e.png">
  <img width="600" alt="스크린샷 2020-11-08 오후 5 37 11" src="https://user-images.githubusercontent.com/68542404/98460599-19454a00-21e9-11eb-857d-3090746a13b6.png">


- 차량 데이터 와 예약 데이터를 SQL Join문을 사용하여 매출 TOP5 차량 데이터를 받아 그래프로 구현


  <img width="600" alt="스크린샷 2020-11-08 오후 5 25 27" src="https://user-images.githubusercontent.com/68542404/98460662-a7213500-21e9-11eb-80c8-98733daba1c0.png">

  <img width="600" alt="스크린샷 2020-11-08 오후 5 41 06" src="https://user-images.githubusercontent.com/68542404/98460672-b7d1ab00-21e9-11eb-9bb2-9c83f9ee8442.png">

## 실시간 채팅 & FAQ


 - FAQ 질문 키워드 검색하면 답변글 (최대 2개) 나오도록 구현

  <img width="600" alt="스크린샷 2020-11-09 오후 3 34 02" src="https://user-images.githubusercontent.com/68542404/98507516-14dc6800-22a1-11eb-9d11-e5158b33f786.png">
  <img width="600" alt="스크린샷 2020-11-08 오후 6 27 20" src="https://user-images.githubusercontent.com/68542404/98461562-7d1f4100-21f0-11eb-8147-d4fdad67e62c.png">
  <img width="600" alt="스크린샷 2020-11-08 오후 6 26 24" src="https://user-images.githubusercontent.com/68542404/98461612-e8691300-21f0-11eb-97e3-23c81d3fb71b.png">


  - WebSocket 을 사용하여 관리자와 사용자간의 실시간 채팅 구현


  <img width="600" alt="스크린샷 2020-11-08 오후 7 20 56" src="https://user-images.githubusercontent.com/68542404/98462481-0a19c880-21f8-11eb-8197-9c6d222f5b6f.png">
