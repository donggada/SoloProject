# SoloProject

<img width="600" alt="스크린샷 2020-12-17 오전 10 40 32" src="https://user-images.githubusercontent.com/68542404/102427416-a97e7680-4054-11eb-85c6-58b873e4f2b7.png">


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
* **회원가입 및 로그인 기능** : DB를 사용하여 로그인 기능 구현
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
<img width="600" alt="스크린샷 2020-12-17 오전 11 06 08" src="https://user-images.githubusercontent.com/68542404/102434495-37a82c00-4058-11eb-986a-b71f9d907764.png">


## 기능구현
 - [회원가입 및 로그인 기능](#회원가입-및-로그인-기능)
 - [이미지 업로드 및 다운](#이미지-업로드-및-다운)
 - [댓글달기](#댓글달기)
 - [메일보내기](#메일보내기)
 



 ## 회원가입 및 로그인 기능
 - DB를 사용하여 회원등록
<img width="600" alt="스크린샷 2020-12-17 오전 10 41 14" src="https://user-images.githubusercontent.com/68542404/102427472-c6b34500-4054-11eb-9dfb-445df062f47e.png">

- DB를 사용하여 회원확인
<img width="600" alt="스크린샷 2020-12-17 오전 10 40 56" src="https://user-images.githubusercontent.com/68542404/102427507-da5eab80-4054-11eb-8840-fc984647046e.png">


## 이미지 업로드 및 다운
 - 갤러리 게시판에 이미지업로드 및 다운 기능 (cos.jar lib 사용)
 <img width="600" alt="스크린샷 2020-12-17 오전 10 48 13" src="https://user-images.githubusercontent.com/68542404/102427810-6d97e100-4055-11eb-8e34-abc26a1e3331.png">
 
 - 이미지 업로드 하기
<img width="600" alt="스크린샷 2020-12-17 오전 11 22 21" src="https://user-images.githubusercontent.com/68542404/102435571-2e1fc380-405a-11eb-989f-2d0828f85a08.png">

 - 갤러리에 올릴 파일 선택
 <img width="600" alt="스크린샷 2020-12-17 오전 11 18 39" src="https://user-images.githubusercontent.com/68542404/102435313-bb164d00-4059-11eb-8751-0701bf11f19d.png">
 
 - 업로드 성공
 <img width="600" alt="스크린샷 2020-12-17 오전 11 17 37" src="https://user-images.githubusercontent.com/68542404/102435320-bf426a80-4059-11eb-93ab-d80dd167b6c0.png">

 
 ## 메일보내기
  - 메일보내기 기능 구현 (Mail.jar lib 사용)
 <img width="600" alt="스크린샷 2020-12-17 오전 11 24 05" src="https://user-images.githubusercontent.com/68542404/102435919-ce75e800-405a-11eb-9ebb-4c41369ae4e7.png">
 - 메일 보내기 성공
 <img width="600" alt="스크린샷 2020-12-17 오전 11 26 42" src="https://user-images.githubusercontent.com/68542404/102435926-d2a20580-405a-11eb-8b5c-b811d9483fd5.png">

  
 ## 댓글달기
  - MySql DB를 사용하여 로그인 기능 구현
  - 댓글은 시간별로 정렬하여 최신댓글을 위로 올라가도록 구현 
<img width="600" alt="스크린샷 2020-12-17 오전 10 51 15" src="https://user-images.githubusercontent.com/68542404/102429204-d7b08600-4055-11eb-93d3-65c52e105590.png">
