# **社群媒體系統功能** *****`Social System`*****

- [**社群媒體系統功能** *****`Social System`*****](#社群媒體系統功能流程-social-system)
  - [\[專案介紹 ── Description\]](#專案介紹--description)
    - [\[後端-敘述 ── Backend Description\]](#後端-敘述--backend-description)
      - [功能API](#功能api)
  - [\[功能流程 ── Functional Flow\]](#功能流程--functional-flow)

## [專案介紹 ── Description]
此專案為社群媒體系統功能後端程式。

>後端框架（framework）：Spring Boot、Spring Security

>後端語言（backend language）：Java

### [後端-敘述 ── Backend Description]

RESTful API 設計風格。

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