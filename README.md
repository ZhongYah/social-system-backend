# **社群媒體系統功能流程** *****`Social System`*****

- [**社群媒體系統功能流程** *****`Social System`*****](#社群媒體系統功能流程-social-system)
  - [\[專案介紹 ── Description\]](#專案介紹--description)
    - [\[前端-敘述 ── Frontend Description\]](#前端-敘述--frontend-description)
      - [專案設定](#專案設定)
      - [啟動前端](#啟動前端)
      - [打包指令](#打包指令)
    - [\[後端-敘述 ── Backend Description\]](#後端-敘述--backend-description)
      - [功能API](#功能api)
  - [\[功能流程 ── Functional Flow\]](#功能流程--functional-flow)

## [專案介紹 ── Description]
此專案為簡易社群媒體平台。

>前端（Frontend）：Vue.js、JavaScript

>後端（Backend）：Spring Boot、Java

### [前端-敘述 ── Frontend Description] 

>### [功能示意圖 ── Function Diagram]
>
>![Image Description](/images/initScreen.png)


#### 專案設定
```
npm install
```

#### 啟動前端
```
npm run serve
```

#### 打包指令
```
npm run build
```
### [後端-敘述 ── Backend Description]

RESTful API 設計風格。

`(註) 圖片暫以文字代替。`

#### 功能API


> (1) 註冊功能: 
> - `POST` 
> - `http://localhost:8080/register`
> - `requestBody :`
>```javaScript
> {
>  "userName":"test1",
>  "phone":"0900000001",
>  "email":"test1@gmail.com",
>  "password":"test1",
>  "coverImage":"cover1.jpg",
>  "biography":"Hello, I'm test1. Nice to meet you!"
>}

> (2) 登入功能: 
> - `POST` 
> - `http://localhost:8080/userLogin`
> - `Authorization: `
>```javaScript
>      Type: Basic Auth
>      Username: 手機門號 (自行設定)
>      Password: 密碼 (自行設定)

> (3) 取得貼文功能: 
> - `GET` 
> - `http://localhost:8080/posts/${post.id}`

> (4) 新增貼文功能: 
> - `POST` 
> - `http://localhost:8080/posts`
> - `requestBody: ` 
>```javaScript
> {
>  "userId": 1,
>  "content": "Good morning everyone! How's your day going?",
>  "image": "morning.jpg"
>}

> (5) 編輯貼文功能: 
> - `PUT` 
> - `http://localhost:8080/posts/${post.id}`
> - `requestBody: `
>```javaScript
> {
>  "userId": 1,
>  "content": "Hello World!",
>  "image": "dog.jpg"
>}

> (6) 刪除貼文功能: 
> - `DELETE` 
> - `http://localhost:8080/users/${user.id}/posts/${post.id}`
> - `requestBody: `  
>```javaScript
> {
>  "userId": 1,
>  "content": "Hello World!",
>  "image": "dog.jpg"
>}

> (7) 取得評論功能: 
> - `GET` 
> - `http://localhost:8080/posts/${post.id}/comments`


## [功能流程 ── Functional Flow]

>### [初始畫面]
>![Image Description](/images/initScreen.png)

>### [註冊畫面]
>![Image Description](/images/registerScreen.png)

>### [註冊成功燈箱畫面]
>![Image Description](/images/modalScreen.png)

>### [登入畫面]
>![Image Description](/images/loginScreen.png)

>### [使用者畫面]
>![Image Description](/images/profileScreen.png)

>### [查看貼文評論畫面]
>![Image Description](/images/detailScreen.png)

>`(註) 發文功能、留言功能、API串接...等，未完待續。`