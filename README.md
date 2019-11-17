# Web Infomation System

## :closed_book: 두 정수 사칙연산
### 주제 : 입력받은 두 정수를 선택된 사칙연산(+, -, *, /)으로 계산한 결과를 출력하기
![사칙연산 실행예시](https://github.com/tunaep5/web-infomation-system/blob/master/Image/hw3.JPG)

### 기능
  - 입력받은 값이 정수가 맞는지 확인
  - 모든 칸을 입력했는지 확인
  - '정수 / 0' 입력 오류 처리
  - 계산 가능 범위 초과 안내

## :orange_book: 회원가입 & 로그인
### 주제 : 회원가입과 로그인 기능 구현하기
- 아이디는 e-mail로 받음
![Join 실행예시](https://github.com/tunaep5/web-infomation-system/blob/master/Image/Join.JPG)
![Login 실행예시](https://github.com/tunaep5/web-infomation-system/blob/master/Image/Login.JPG)
### 기능
  #### 회원가입
  - 필수입력, 선택입력 구분
  - 아이디 '중복확인' 후 결과 문구 출력
    - 이메일을 입력되었는지 확인
    - 이메일 형식이 올바른지 확인
    - 이미 사용중인 메일인지 확인
  - 비밀번호, 비밀번호 확인 칸의 입력이 같은지 확인 후 안내 문구 출력
  - '가입하기' 선택시 아이디 중복확인과 비밀번호 확인이 완료되었는지 확인
  - '가입하기'에 실패(DB연결 실패)한 경우 안내 문구 출력
  - 성공적으로 회원가입을 마치면 로그인페이지로 이동
  
  #### 로그인
  - 아이디, 비밀번호가 모두 입력되었는지 확인
  - 로그인에 실패(DB연결 실패, 올바르지 않은 입력)한 경우 안내 문구 출력
  
  #### 로그아웃
