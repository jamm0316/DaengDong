# 프로젝트 개요 및 기여한 점
# 🐶 Daengdong
반려동물과 함꼐 여행을 계획해 보세요!

## 💁‍♀️ Authors
<table>
  <tr>
         <td align="center" width="16%">
            <a href="https://github.com/jamm0316"><img width="75%" src="readme/jm.png"/></a>
            <br />
            <a href="https://github.com/jamm0316">송재명</a>
        </td>
         <td align="center" width="16%">
            <a href="https://github.com/kseenyoung"><img width="75%" src="readme/sy.png"/></a>
            <br />
            <a href="https://github.com/kseenyoung">김신영</a>
        </td>
         <td align="center" width="16%">
            <a href="https://github.com/dmlcksghd"><img width="75%" src="readme/uc.png"/></a>
            <br />
            <a href="https://github.com/dmlcksghd">홍의찬</a>
        </td>
         <td align="center" width="16%">
            <a href="https://github.com/minyoung0302"><img width="75%" src="readme/my.png"/></a>
            <br />
            <a href="https://github.com/minyoung0302">정민영</a>
        </td>
         <td align="center" width="16%">
            <a href="https://github.com/yuseonghun"><img width="75%" src="readme/sh.png"/></a>
            <br />
            <a href="https://github.com/yuseonghun">유성훈</a>
        </td>
         <td align="center" width="16%">
            <a href="https://github.com/boseungdl"><img width="75%" src="readme/sb.png"/></a>
            <br />
            <a href="https://github.com/boseungdl">한승보</a>
        </td>
    </tr>
</table>

## ⚙️ Tech Stack

**Client:** Javascript, HTML, CSS

**Server:** Java, WebSocket, JSP

**Database:** MySQL 

## 🧱 Archetecture & Development Environment

![archtecture](https://github.com/user-attachments/assets/5350d9b2-f6d0-498c-adf9-d7e6371bb83d)

`IDE` Intellij

`JDK` >= 11

`OS` mac, window

## 🔥 해결한 문제
### 1. 사용자 요구 기반 기능 구현 우선순위 설정 (구글 폼 설문 활용)
#### 문제인식
- 기획 단계에서 어떤 기능이 우선되어야 할지 판단이 어려웠고, 사용자 관점에서 필요한 기능이 무엇인지 명확하지 않았음.

#### 진단
- 54명을 대상으로 한 설문조사 결과, 다수가 2인 이상 여행(85%)을 하며 여행 중 꿀팁(62.3%)을 중요하게 여김을 확인.
  <img height="400" alt="image" src="https://github.com/user-attachments/assets/96a47d99-5d1e-4259-b502-67e30bfe2aea" />
  <img height="400" alt="image" src="https://github.com/user-attachments/assets/d52c0a99-c707-411d-a5f2-86f3210d8dfd" />



#### 판단 및 해결
- 실시간 여행 공유 기능(WebSocket 기반)과 계획 등록, 초대 기능, 커뮤티니 기능 등 소통 중심 기능을 우선 구현이라 판단.
- 커뮤니티 게시판에는 꿀팁 카테고리를 별도로 구성해, 차별화된 콘텐츠 정보 제공 기능 강화로 설계.

#### 성과
✅ **사용자 니즈 기반으로 기능 우선순위를 정하고 실시간 공유 및 정보 제공 기능을 설계, 구현하여 사용자 중심의 서비스 완성도 향상.**

---

### 2. 실시간 채팅 내역 유지 이슈 해결 (WebSocket + Supabase 활용)
#### 문제인식
- 기존 DB설계 시 채팅 내역 저장 테이블 설계가 없었음.
- 대화 내역이 저장되지 않아 UX 불편이 발생.

#### 진단
- 연속된 대화의 흐름이 단절되고, 개발된 DB 구조상 재설계 시 비용, 일정 리스크 존재
  
#### 판단 및 해결
- 로컬/서버 저장 방식과 외부스토리지 방식 비교 후, 기존 DB 수정 없이 확장 가능한 외부 스토리지(Supabase) 채택
- Supabase를 활용해 채팅 메시지를 실시간 저장 및 조회 가능하도록 구현
  <img width="620" alt="image" src="https://github.com/user-attachments/assets/eecdbff1-d7bc-4146-a845-e29d254355a3" />


#### 성과
✅ **DB 구조 변경 없이도 채팅 내역 유지 기능을 안정적으로 구현하여 UX 불편 해소**

---

### 3. Kakao Map API 한계를 극복한 썸네일 자동 로딩 개선(JSoup 크롤링)
#### 문제인식
- 사용자가 등록한 여행지 목록에 대표 이미지가 노출되지 않아 시각적 완성도와 정보성이 낮았음.

#### 진단
- Kakao Map API는 장소 상세이페이지 URL까지만 제공하며, 대표 이미지의 src 경로는 포함하지 않음.
- 따라서 웹 크롤링 없이 이미지를 가져올 수 없다는 기술적 제약 존재.

#### 판단 및 해결
- 상세페이지 URL의 패턴을 분석하고 place_id 기반의 URL 동적 생성.
- JSoup을 활용해 해당 URL의 HTML 구조를 분석, img 태그의 src 속성을 크롤링해 이미지 경로 획득.
  <img width="1369" height="430" alt="image" src="https://github.com/user-attachments/assets/040e64c7-69d9-49d6-83fa-7663e9163677" />

#### 성과
- ✅ **외부 API 제약을 자체 기술로 극복하여, 썸네일 자동 로딩으로 UX 완성도 향상**<br>
  <img width="320" alt="image" src="https://github.com/user-attachments/assets/b4bb50b5-af7b-4be8-9e67-47f942a01376" />

---
<br>
<br>

# 프로젝트 상세 설명

## 스크린샷

### 여행기능
![My Movie 1 (1)](https://github.com/user-attachments/assets/51c494f4-baad-4f22-8796-57afd424b254)

### 채팅기능
![chatting](https://github.com/user-attachments/assets/993836cb-478e-41ba-8c8c-e8076b1d39d9)

### 커뮤니티기능
![My Movie 1](https://github.com/user-attachments/assets/5f04e492-5388-4f40-b431-547c3416f31c)

### 회원가입
![signUp](https://github.com/user-attachments/assets/f0accd6a-7575-49c3-8a1f-a4bdb1646ac5)

### 마이페이지 프로필
![My Movie 1 (1)](https://github.com/user-attachments/assets/d492fa13-e51b-4174-9847-45ac6efdf8bb)
![My Movie 1 (2)](https://github.com/user-attachments/assets/49cc3bfa-9410-408a-9932-9b001ccf1511)

## 디렉토리 구조

### java
``` text
├── java
│   └── com
│       └── shinhan
│           └── daengdong
│               ├── chat
│               │   ├── controller
│               │   │   └── ChatController.java
│               │   ├── dto
│               │   │   └── ChatMessageDTO.java
│               │   ├── model
│               │   │   ├── ChatParticipant.java
│               │   │   ├── ChatRoom.java
│               │   │   ├── repository
│               │   │   │   └── ChatRoomRepository.java
│               │   │   └── service
│               │   │       └── ChatService.java
│               │   └── websocket
│               │       ├── ChatWebSocketConfig.java
│               │       ├── ChatWebSocketHandler.java
│               │       ├── HttpSessionInterceptor.java
│               │       ├── SessionInfo.java
│               │       └── WebSocketSessionManager.java
│               ├── home
│               │   └── controller
│               │       └── HomeController.java
│               ├── member
│               │   ├── controller
│               │   │   ├── MemberController.java
│               │   │   ├── MemberRestController.java
│               │   │   └── OauthController.java
│               │   ├── dto
│               │   │   ├── FavoritePlaceDTO.java
│               │   │   ├── FollowDTO.java
│               │   │   ├── ImageDTO.java
│               │   │   ├── LikePostsDTO.java
│               │   │   ├── MemberDTO.java
│               │   │   ├── NotificationDTO.java
│               │   │   ├── PetImageDTO.java
│               │   │   ├── RelationshipsDTO.java
│               │   │   └── SignUpDTO.java
│               │   ├── model
│               │   │   ├── repository
│               │   │   │   ├── MemberRepositoryImpl.java
│               │   │   │   └── MemberRepositoryInterface.java
│               │   │   └── service
│               │   │       ├── GoogleOauthService.java
│               │   │       ├── KakaoOauthService.java
│               │   │       ├── MemberServiceImpl.java
│               │   │       └── MemberServiceInterface.java
│               │   └── vo
│               │       ├── MemberPostsVO.java
│               │       └── MemberVO.java
│               ├── notification
│               │   ├── controller
│               │   ├── dto
│               │   ├── model
│               │   │   ├── repository
│               │   │   └── service
│               │   └── vo
│               ├── pet
│               │   └── dto
│               │       └── PetDTO.java
│               ├── photocard
│               │   ├── controller
│               │   ├── dto
│               │   ├── model
│               │   │   ├── repository
│               │   │   └── service
│               │   └── vo
│               ├── place
│               │   ├── controller
│               │   │   └── PlaceController.java
│               │   ├── dto
│               │   │   ├── FavoriteDTO.java
│               │   │   ├── PlaceDTO.java
│               │   │   ├── PlanPlaceDTO.java
│               │   │   └── RegionDTO.java
│               │   ├── model
│               │   │   ├── repository
│               │   │   │   ├── PlaceRepositoryImpl.java
│               │   │   │   └── PlaceRepositoryInterface.java
│               │   │   └── service
│               │   │       ├── PlaceServiceImpl.java
│               │   │       └── PlaceServiceInterface.java
│               │   └── vo
│               ├── plan
│               │   ├── controller
│               │   │   └── PlanController.java
│               │   ├── dto
│               │   │   ├── MemberPlanDTO.java
│               │   │   ├── PlanDTO.java
│               │   │   ├── PlanDetailsDTO.java
│               │   │   └── PlanRelationshipsDTO.java
│               │   ├── model
│               │   │   ├── repository
│               │   │   │   ├── PlanRepositoryImpl.java
│               │   │   │   └── PlanRepositoryInterface.java
│               │   │   └── service
│               │   │       ├── PlanServiceImpl.java
│               │   │       └── PlanServiceInterface.java
│               │   ├── vo
│               │   │   └── PlanVO.java
│               │   └── websoket
│               │       ├── PlanHandshakeInterceptor.java
│               │       └── PlanWebSocketHandler.java
│               ├── post
│               │   ├── controller
│               │   │   ├── PostController.java
│               │   │   └── PostRestController.java
│               │   ├── dto
│               │   │   ├── CommentDTO.java
│               │   │   ├── LikeDTO.java
│               │   │   ├── PostDTO.java
│               │   │   └── PostIMGDTO.java
│               │   ├── model
│               │   │   ├── repository
│               │   │   │   ├── PostRepositoryImpl.java
│               │   │   │   └── PostRepositoryInterface.java
│               │   │   └── service
│               │   │       ├── PostServiceImpl.java
│               │   │       └── PostServiceInterface.java
│               │   └── vo
│               │       ├── CommentVO.java
│               │       ├── LikeVO.java
│               │       └── PostVO.java
│               ├── review
│               │   └── dto
│               │       └── ReviewDTO.java
│               └── util
│                   ├── JacksonConfig.java
│                   ├── WebSocketConfig.java
│                   └── awsS3
│                       ├── S3Config.java
│                       ├── S3Controller.java
│                       └── S3Service.java
├── resources
│   ├── application.properties
│   ├── daengdong.sql
│   ├── dump.sql
│   ├── keystore.p12
│   ├── log4j.xml
│   └── mybatis
│       ├── mappers
│       │   ├── memberMapper.xml
│       │   ├── placeMapper.xml
│       │   ├── planMapper.xml
│       │   └── postMapper.xml
│       └── sqlMapConfig.xml
```

### webapp
``` text
├── WEB-INF
│   ├── root-context.xml
│   ├── root-contextDB.xml
│   ├── servlet-context.xml
│   ├── views
│   │   ├── chat
│   │   │   └── chatFragment.jsp
│   │   ├── common
│   │   │   └── header.jsp
│   │   ├── home.jsp
│   │   ├── member
│   │   │   ├── editNickName.jsp
│   │   │   ├── followerModal.jsp
│   │   │   ├── followingModal.jsp
│   │   │   ├── header.jsp
│   │   │   ├── login.jsp
│   │   │   ├── mypage.jsp
│   │   │   ├── petCreateProfileModal.jsp
│   │   │   ├── petProfileModal.jsp
│   │   │   ├── post.html
│   │   │   ├── profileFragment.jsp
│   │   │   ├── semiCategory
│   │   │   │   ├── photoCard.jsp
│   │   │   │   ├── save
│   │   │   │   │   ├── favoritePlaceFragment.jsp
│   │   │   │   │   ├── likePostsFragment.jsp
│   │   │   │   │   ├── myPostsFragment.jsp
│   │   │   │   │   ├── reviewFragment.jsp
│   │   │   │   │   └── reviewUpdateModal.jsp
│   │   │   │   ├── save.jsp
│   │   │   │   ├── trip
│   │   │   │   │   ├── completeTravelFragment.jsp
│   │   │   │   │   ├── planningFragment.jsp
│   │   │   │   │   └── travelingFragment.jsp
│   │   │   │   └── trip.jsp
│   │   │   ├── signUp.jsp
│   │   │   └── userProfileImageModal.jsp
│   │   ├── photocard
│   │   ├── place
│   │   │   └── searchPlace.jsp
│   │   ├── plan
│   │   │   ├── createPlan.jsp
│   │   │   ├── myPlace.jsp
│   │   │   └── newPlan.jsp
│   │   └── post
│   │       ├── post.jsp
│   │       ├── postCol.jsp
│   │       └── postDetail.jsp
│   └── web.xml
├── css
│   ├── chat
│   │   └── chat.css
│   ├── header.css
│   ├── member
│   │   ├── favoritePlace.css
│   │   ├── followModal.css
│   │   ├── likePosts.css
│   │   ├── login.css
│   │   ├── myPlan.css
│   │   ├── myPost.css
│   │   ├── mypage.css
│   │   └── reviews.css
│   ├── photoCard
│   ├── plan
│   │   ├── searchPlace.css
│   │   └── searchPlceImpl.css
│   ├── post
│   │   ├── post.css
│   │   └── postDetail.css
│   └── signUp.css
├── images
│   ├── banner.jpg
│   ├── community.png
│   ├── header_arlam.png
│   ├── header_community.png
│   ├── header_plan.png
│   ├── header_user.png
│   ├── image 16.png
│   ├── love.png
│   ├── modal.png
│   ├── one-svgrepo-com.svg
│   ├── plan.png
│   └── user.png
├── img
│   ├── Downloads
│   │   ├── day08
│   │   │   └── day08
│   │   │       ├── AbstractTest.java
│   │   │       ├── AppCDInfo.java
│   │   │       ├── Audio.java
│   │   │       ├── CDInfo.java
│   │   │       ├── Changeable.java
│   │   │       ├── Colorable.java
│   │   │       ├── EMailSender.java
│   │   │       ├── Inheritance.java
│   │   │       ├── InterfaceTest.java
│   │   │       ├── Lendable.java
│   │   │       ├── MessageSender.java
│   │   │       ├── Moveable.java
│   │   │       ├── MyBox.java
│   │   │       ├── MyInterface.java
│   │   │       ├── MyInterfaceImpl1.java
│   │   │       ├── MyInterfaceImpl2.java
│   │   │       ├── Prob1.java
│   │   │       ├── RemoteController.java
│   │   │       ├── RemoteController2.java
│   │   │       ├── Resizable.java
│   │   │       ├── SMSSender.java
│   │   │       ├── SeparateVolume.java
│   │   │       ├── Television.java
│   │   │       ├── TranformImpl.java
│   │   │       └── Transformable.java
│   │   ├── movie
│   │   │   └── movie
│   │   │       ├── movieController
│   │   │       │   ├── MovieController.java
│   │   │       │   ├── ReserveController.java
│   │   │       │   └── UserController.java
│   │   │       ├── movieDAO
│   │   │       │   ├── MovieDAO.java
│   │   │       │   ├── ReserveDAO.java
│   │   │       │   └── UserDAO.java
│   │   │       ├── movieDTO
│   │   │       │   ├── MovieDTO.java
│   │   │       │   ├── ReserveDTO.java
│   │   │       │   └── UserDTO.java
│   │   │       ├── movieService
│   │   │       │   ├── MovieService.java
│   │   │       │   ├── ReserveService.java
│   │   │       │   └── UserService.java
│   │   │       └── movieView
│   │   │           ├── MovieView.java
│   │   │           ├── ReserveView.java
│   │   │           └── UserView.java
│   │   ├── pet
│   │   │   ├── PretendardVariable.woff2
│   │   │   ├── images
│   │   │   │   ├── banner.jpg
│   │   │   │   ├── community.png
│   │   │   │   ├── image 16.png
│   │   │   │   ├── love.png
│   │   │   │   ├── one-svgrepo-com.svg
│   │   │   │   ├── plan.png
│   │   │   │   └── user.png
│   │   │   ├── main.css
│   │   │   ├── main2.html
│   │   │   ├── pet.code-workspace
│   │   │   ├── post.css
│   │   │   └── post.html
│   │   └── pro15
│   │       └── pro15
│   │           └── src
│   │               └── sec01
│   │                   ├── ex01
│   │                   │   └── FileUpload.java
│   │                   └── ex02
│   │                       └── FileDownload.java
│   ├── Like.png
│   ├── Likefull.png
│   ├── comment.png
│   ├── daengdong_dog.jpeg
│   ├── empty_like_icon.png
│   ├── empty_star.png
│   ├── fullLike.png
│   ├── kakao_login.png
│   ├── kseenyoungProfile.jpeg
│   ├── left-arrow.png
│   ├── login.png
│   ├── main2.png
│   ├── main3.png
│   ├── main4.png
│   ├── main5.png
│   ├── modal.png
│   ├── more.png
│   ├── plan_create.jpg
│   ├── plan_create2.jpg
│   ├── profile10.jpg
│   ├── profile7.jpg
│   ├── profile8.jpg
│   ├── profile9.jpg
│   ├── right-arrow.png
│   ├── shorlock.jpeg
│   └── star.png
├── index.jsp
├── js
│   ├── addCompanion.js
│   ├── chat
│   │   ├── chat.js
│   │   └── planChat.js
│   ├── finalSend.js
│   ├── main.js
│   ├── member
│   │   └── mypage.js
│   ├── photoCard
│   ├── planWebSocket.js
│   ├── post
│   │   ├── like.js
│   │   └── postImageUpload.js
│   ├── searchPlace_app.js
│   ├── signUp.js
│   ├── uploadFile.js
│   └── websocket.js
├── main2.jsp
├── style2.css
└── upload
    ├── cat1_1736831296666.jpg
    ├── cat2_1736831263308.jpg
    ├── cat3_1736831263307.jpg
    └── cat4_1736831263306.jpg
```
<!-- ## API Reference

### Auth

#### login page

```http
  GET /auth/login.do
```

#### login

```http
  POST /auth/login.do
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `member_id` | `string` | **Required**. Id of member |
| `password`  | `string` | **Required**. password of member |


### Room

#### room page

```http
  GET /room/rooms.do
```

### Chat

#### chat page

```http
  GET /chat/chat.do?chatId
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `chatId` | `int` | **Required**. chatId for enter chat |
-->

## Run Locally

project Clone

```bash
  git clone https://github.com/kseenyoung/DaengDong
```

Tomcat start
port:5555
context:daengdong

main url
```
http://localhost:5555/daengdong/
```

