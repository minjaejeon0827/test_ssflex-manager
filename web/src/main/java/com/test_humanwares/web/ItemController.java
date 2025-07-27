package com.test_humanwares.web;   // 파일 상단에 package 파일경로;(com 폴더 -> test_humanwares 폴더 -> web 폴더) 라고 적어줘야 다른 파일에서도 여기 있던 코드를 사용가능하다.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 용어 정리
// API - 어떤 프로그램의 사용법
// 웹서버 API - 어떤 웹서버 프로그램의 사용법
// '컨트롤러'(@Controller) 역할 - 유저의 요청을 @Controller가 사용된 클래스 안에 구현된 여기저기 Rest API로 안내하는 역할

// @Controller만 잘 붙이면 WebApplication.java -> main 함수에 안넣어도 알아서 제때 ItemController 잘 실행 해준다.
@Controller   // @Controller 사용하면 springframework가 알아서 아래 코드(public class ItemController { ... }) 가져와서 ShopApplication 클래스 main 함수에 집어 넣어서 아래 웹서버 코드 실행
// 접근 제어자 "public" 없으면 같은 폴더(패키지) 안에서만 해당 클래스 사용가능
// 접근 제어자 "public" 붙이면 다른 폴더(패키지) 에서도 해당 클래스 사용 가능
public class ItemController {
    // 여기서 웹서버기능 제작가능

    // 웹서버 API - 상품목록 웹페이지("/list")
    @GetMapping("/list")   // Method - @GetMapping URL - "/list"
    // @ResponseBody   // html 파일("list.html")을 유저 웹브라우저로 전송하고 싶으면 @ResponseBody를 빼줘야 함.
    String list(Model model) {  // Thymeleaf 템플릿 엔진(Thymeleaf 문법) 사용하기 위해 파라미터 Model model 추가
        model.addAttribute("name", "홍길동");  // html 파일에 보내고 싶은 웹서버데이터 이름 "name", 값 "홍길동" 메서드 addAttribute 사용해서 집어넣기

        // Thymeleaf 문법(Thymeleaf 템플릿 엔진 외부 라이브러리 설치해야 사용 가능한 문법.)을 사용하고 싶으면
        // list.html 기본 상위 폴더 경로를
        // (기존) static 폴더
        // (변경) templates 폴더 -> templates 폴더 (폴더 경로 - "D:\minjae\test_ssflex-manager\web\src\main\resources\templates")로 html 파일을 옮겨야 잘 동작한다.
        // 2. html 파일("list.html")을 유저에게 보내주세요.
        return "list.html";
    }

    // 웹서버 API - Thymeleaf 템플릿 엔진(Thymeleaf 문법) 사용해서 웹서버데이터를 html에 박아서 보내주는 웹서버 API
    // @GetMapping("/list")
    // @ResponseBody   // html 파일("list.html")을 유저 웹브라우저로 전송하고 싶으면 @ResponseBody를 빼줘야 함.
    // String list(Model model) {  // Thymeleaf 템플릿 엔진(Thymeleaf 문법) 사용하기 위해 파라미터 Model model 추가
    //     model.addAttribute("name", "홍길동");  // html 파일에 보내고 싶은 웹서버데이터 이름 "name", 값 "홍길동" 메서드 addAttribute 사용해서 집어넣기
    //     return "list.html";
    // }

    // 웹서버 API 작성 예시
    // @GetMapping("/list")
    // String list(){
    //     return "list.html";
    // }
}
