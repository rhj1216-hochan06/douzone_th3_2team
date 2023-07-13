
# douzone_th3_2team

프로젝트 2 - 스프링 프로젝트
팀명: 더존비즈온 3기 운동잘하조(2팀)

## 개발 환경
|개발환경  | 내용                                    |
| ----- | ------------------------------------- |
| 언어 | Java |
| 프레임워크 | Spring Framework |
| 데이터베이스 | Oracle |
| 개발 도구 | Eclipse, Spring Tool Suite(STS) |
| 빌드 도구 | Maven |
| 버전 관리 | Git |


## 팀 구성원

| 이름  | 역할                                          |
| ----- | --------------------------------------------- |
| 류호진 | 프로젝트 총괄, 로그인 기능, 회원가입, 설문 등   |
| 박승민 | 서브 기능 총괄, 관리자 페이지, 상품 검색 ,사용자 게시판 등  |
| 안예지 | 관리자 페이지, 회원조회, 상품관리 등           |
| 홍건호 | 메인 프레임 총괄, 영양제 구독, 장바구니 구현 등 |

## 개요

기존의 헬스장 개념을 벗어나 영양제 구독 서비스, 맞춤형 식단과 음료, 용품 등을 고객에게 제공하는 프로젝트입니다.

## 구성
![image](https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/ae147339-d2d8-4928-8d6a-00d67793fbb2)

프로젝트는 다음과 같은 기능들로 구성되어 있습니다:
- 영양제 구독 서비스 제공
- 물품 구매 기능
- 식단 구매 기능
- 로그인을 활용한 개인 맞춤 추천 서비스
- 장바구니를 통한 구매 기능
- 구매 목록 확인 기능
- Q&A (1대1 문의)
- 관리자 페이지에서의 수정, 추가, 삭제

## 흐름도
![image](https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/21515925-e3c9-4b27-ae94-907ea968f453)

## 개발 내용

- 로그인 및 회원가입 기능 구현
- 본인인증을 통한 회원가입 절차
- 관리자 페이지 구현 (회원조회, 상품관리, 주문조회, Q&A 확인 등)
- 메인 페이지와 각 하위 페이지 구현 (소개, 문의, 마이페이지, 상품, Q&A)
- 설문조사 및 인바디 입력을 통한 맞춤 상품 추천 기능 구현
- 장바구니 기능 구현
- 구매 기능 (신용카드 구매, 카카오 페이 구매) 구현

## 활동 결과
Java Spring을 사용하여 웹 애플리케이션을 개발하고, MVC 패턴에 익숙해지기 위함입니다. 
MVC 패턴은 소프트웨어 개발에서 구조화된 코드 작성을 위한 중요한 디자인 패턴 중 하나입니다. 이를 통해 코드의 재사용성, 유지 보수성, 확장성을 향상시킬 수 있습니다.<br />
프로젝트에서는 Java Spring 프레임워크를 활용하여 MVC 아키텍처를 구현하고, 각 요소인 모델, 뷰, 컨트롤러를 분리하여 개발합니다. 이를 통해 코드의 가독성과 유지 보수성을 향상시킬 수 있습니다.<br />
또한, 오라클 데이터베이스와의 연동을 통해 데이터를 저장하고 조회할 수 있습니다. 데이터베이스는 웹 애플리케이션에서 중요한 역할을 수행하며, 오라클로의 접속을 통해 데이터의 안정적인 관리와 조작을 가능하게 합니다.<br />
이를 통해 개발자는 Java Spring을 활용하여 웹 애플리케이션을 구현하고, MVC 패턴을 적용하며 오라클 데이터베이스와의 연동을 경험하면서 실무에 필요한 기술과 개발 스킬을 향상시킬 수 있습니다.<br />
<br />

운동하는 고객들의 맞춤형 건강식 및 영양제 구독 서비스를 제공하며, 여러 협력 업체들과의 협업 및 가맹점 추가로 인한 기대수익 증가를 목적 <br />

프로젝트 진행에 있어 팀원들은 기능과 역할을 분담하였으며, 매일 오전에 회의를 통해 작업 진행 상황을 공유하였습니다. <br />
문제가 발생한 경우 소통을 통해 문제 해결 방법을 논의하였고, Git을 사용하여 작업 내용을 관리하였습니다.<br />
 회의록 및 추가 작업 내용은 Notion에 정리하여 공유하였습니다.<br />

[깃 프로젝트 링크](https://github.com/rhj1216-hochan06/douzone_th3_2team) https://github.com/rhj1216-hochan06/douzone_th3_2team <br />
[Notion 링크](https://zealous-loaf-1f0.notion.site/2-f233f21483664ca7ae3b1afbdcbb8d39) https://zealous-loaf-1f0.notion.site/2-f233f21483664ca7ae3b1afbdcbb8d39 <br />

## 실행 방법

1. `com.hwf.config` 디렉토리에 있는 `oracledb.properties` 파일을 수정합니다. <br />
데이터베이스의 쿼리문은 <br />
[Notion 링크](https://zealous-loaf-1f0.notion.site/DB-112d26ba8ff24aa5930621c2fff187a7) https://zealous-loaf-1f0.notion.site/DB-112d26ba8ff24aa5930621c2fff187a7 <br />
에서 확인할 수 있습니다.

2. `webapp` 디렉토리에서 `Main.jsp` 파일을 실행합니다.

3. 관리자 페이지로 이동하려면 아이디 `admin`과 비밀번호 `oracle`로 로그인하거나 `adminmain` 파일을 실행합니다.

## DB 정보
![image](https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/bd837ea6-da8f-47be-a43a-84913198194e)

## 시연

![스크린샷 2023-07-13 오후 4 06 45](https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/bfcdb3d8-aa02-4e8b-96bc-5aafc4a0e1b2)
![스크린샷 2023-07-13 오후 4 07 31](https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/8c4976d4-c1b9-4991-ba88-633af2e3b198)
<img width="944" alt="스크린샷 2023-07-13 오후 4 07 43" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/c1ad58e4-a7e8-491b-af26-dbc33ac5d94f">
<img width="934" alt="스크린샷 2023-07-13 오후 4 08 10" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/754b44df-b16b-4837-9fea-3643e87a5985">
<img width="380" alt="스크린샷 2023-07-13 오후 4 08 33" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/0387db4c-4580-466a-8024-96e070fbfc66">
<img width="387" alt="스크린샷 2023-07-13 오후 4 08 45" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/25fb647f-5605-4b64-8029-df364ccf0c1f">

<img width="1012" alt="스크린샷 2023-07-13 오후 4 09 09" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/edf861b4-6ddc-4ad6-9a1b-afd08a30e7bc">
<img width="372" alt="스크린샷 2023-07-13 오후 4 09 43" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/e890c18f-b848-4a1d-b758-c3cea6bb6115">
<img width="354" alt="스크린샷 2023-07-13 오후 4 10 07" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/1ff1f558-a794-4701-8752-5cf7d2e631b0">
<img width="295" alt="스크린샷 2023-07-13 오후 4 10 37" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/7cb5d3dc-c3c1-41e4-8c5f-6ee9b9b608d7">
<img width="967" alt="스크린샷 2023-07-13 오후 4 11 01" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/0ae3c8ca-48af-476a-8c6e-346fae997ac9">
<img width="458" alt="스크린샷 2023-07-13 오후 4 11 07" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/c2293efa-0f3f-4265-a282-3e9e392cdc35">
<img width="971" alt="스크린샷 2023-07-13 오후 4 11 54" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/1715787f-50b1-489a-9a7d-9f865972f0e3">
<img width="432" alt="스크린샷 2023-07-13 오후 4 12 19" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/af15f891-8c62-4058-a455-9f825cc570e9">
<img width="945" alt="스크린샷 2023-07-13 오후 4 12 38" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/b571ac1f-a5fd-489b-8679-6946e76a80e8">
<img width="740" alt="스크린샷 2023-07-13 오후 4 12 53" src="https://github.com/rhj1216-hochan06/douzone_th3_2team/assets/83914448/6715e150-e6a7-4fb0-99d6-6375046b051d">


https://zealous-loaf-1f0.notion.site/signed/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F5fad9abf-3c25-4d19-be13-152ca8a51d14%2F%25EB%25B0%259C%25ED%2591%259C%25EC%2598%2581%25EC%2583%2581.zip?id=99119caf-fca4-4825-aac1-42170b4e8093&table=block&spaceId=fffb2b01-29d5-4fec-aa14-2d329b3dd6c4&name=%EB%B0%9C%ED%91%9C%EC%98%81%EC%83%81.zip&cache=v2

발표영상입니다.


