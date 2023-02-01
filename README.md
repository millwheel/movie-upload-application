# movie-edit-application

This is sample web application to practice REST API

Test application to pratice Spring and JPA

## 서비스 개요

### 영상을 편집하는 스마트폰 어플리케이션의 서버 구현 
(ex. Inshot, Youcut, Capcut 등)
 
### 주요 기능

- 사용자는 로그인할 수 있음
- 사용자는 로그인 후 홈 화면에서 작업 중인 영상 목록을 볼 수 있음
- 영상 목록에서 영상을 누르면 편집 화면으로 갈 수 있음
- 영상 목록에 영상이 없어도 영상을 등록하면 편집화면으로 갈 수 있음

## 비즈니스 요구사항 정리

- 데이터 모델
  1) 고객 (id, 이름, email, password, 멤버십 유무)
  2) 영상 (id, 마지막 편집날짜)

- 기능
    1) 로그인
    2) 파일목록 조회 
    3) 파일 등록
    4) 파일 편집
    
## 진행 상황

- 기능
    1) 로그인 (진행 완료)
    2) 파일 목록 조회 (진행 중)
    3) 파일 등록 (진행 예정)
    4) 파일 편집