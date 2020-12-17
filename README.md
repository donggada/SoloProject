# SoloProject
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
* **DB 연동** : MySql DB를 사용하여 로그인 및 게시판 구현
* **게시판 만들기** : 갤러리 게시판 및 커뮤니티 게시판 구현

---


## 프로젝트 핵심기능
* **로그인 기능** : DB를 사용하여 로그인 기능 구현
* **이미지 업로드 및 다운** : cos.jar lib 를 사용하여 이미지 업로드 및 다운 기능구현
* **댓글 달기** : 게시물에 댓글 달기 기능 구현
* **이메일 보내기** : Mail.jar lib 를 사용하여 메일보내기 기능구현
---


## 개발환경
- 언어
  - Java EE
  - HTML5 / CSS3
  - JavaScript 'ES5'
    
- 서버
  - Apach Tomcat v9.0   

- 개발도구
  - Eclipse -JEE -Mars -2
  - MySQL WorkBench
  - Github  
---
## 데이터베이스
<img width="600" alt="스크린샷 2020-11-08 오후 2 50 38" src="https://user-images.githubusercontent.com/68542404/98458288-62d66a80-21d2-11eb-960a-eca594077f28.png">


## 기능구현
 - [로그인](#로그인)
 - [이미지-업로드-및-다운](#이미지-업로드-및-다운)
 - [댓글달기](#댓글달기)
 - [메일보내기](#메일보내기)
 



 ## 로그인
 - MySql DB를 사용하여 로그인 기능 구현
<img width="600" alt="스크린샷 2020-11-09 오후 2 30 52" src="https://user-images.githubusercontent.com/68542404/98503679-7e0bad80-2298-11eb-9ca4-410bb14aa9d2.png">

 
- 해당 사이트 로그인 성공시 고유 값을 아이디값으로 받아 DB에 저장후 로그인 수행
<img width="600" alt="스크린샷 2020-11-09 오후 2 32 36" src="https://user-images.githubusercontent.com/68542404/98503852-e35f9e80-2298-11eb-9717-c4f6b273e767.png">


## 이미지 업로드 및 다운
- 갤러리 게시판에 이미지업로드 및 다운 기능 (cos.jar lib 사용)
 <img width="600" alt="스크린샷 2020-11-08 오후 5 06 38" src="https://user-images.githubusercontent.com/68542404/98460144-f153e780-21e4-11eb-8c4c-becd9ffd0302.png">

 
 ## 메일보내기
  - 메일보내기 기능 구현 (Mail.jar lib 사용)
  <img width="600" alt="스크린샷 2020-11-08 오후 5 56 10" src="https://user-images.githubusercontent.com/68542404/98461122-fddc3e00-21ec-11eb-99a3-f03312884506.png">
  <img width="600" alt="스크린샷 2020-11-08 오후 5 59 04" src="https://user-images.githubusercontent.com/68542404/98461120-f9178a00-21ec-11eb-954a-ad36209803b0.png">
