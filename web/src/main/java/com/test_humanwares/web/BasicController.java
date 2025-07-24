package com.test_humanwares.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

// @Controller만 잘 붙이면 WebApplication.java -> main 함수에 안넣어도 알아서 제때 BasicController 잘 실행 해준다.
@Controller   // @Controller 사용하면 springframework가 알아서 아래 코드(public class BasicController { ... }) 가져와서 ShopApplication 클래스 main 함수에 집어 넣어서 아래 웹서버 코드 실행
public class BasicController {
    // 여기서 웹서버기능 제작가능

    // 웹서버 API - 테스트 웹페이지("/test")
    @GetMapping("/test")
    // @ResponseBody   // html 파일("test/test.html)을 유저 웹브라우저로 전송하고 싶으면 @ResponseBody를 빼줘야 함.
    String test() {
        // Thymeleaf 문법(Thymeleaf 템플릿 엔진 외부 라이브러리 설치해야 사용 가능한 문법.)을 사용하고 싶으면
        // index.html 기본 상위 폴더 경로를
        // (기존) static 폴더
        // (변경) templates 폴더 -> test 폴더 (폴더 경로 - "D:\minjae\test_ssflex-manager\web\src\main\resources\templates\test")로 html 파일을 옮겨야 잘 동작한다.
        // 2. html 파일("test/test.html")을 유저에게 보내주세요.
        return "test/test.html";   // test.html 기본 상위 폴더 경로 (기존) static 폴더 -> (변경) templates 폴더 -> test 폴더
    }

    // 웹서버 API - 메인 웹페이지("/")
    @GetMapping("/")   // 1. 메인 웹페이지 URL("/")로 HTTP - GET method 요청(접속) 날리면
    // @ResponseBody   // html 파일(index.html)을 유저 웹브라우저로 전송하고 싶으면 @ResponseBody를 빼줘야 함.
    String hello() {
        // Thymeleaf 문법(Thymeleaf 템플릿 엔진 외부 라이브러리 설치해야 사용 가능한 문법.)을 사용하고 싶으면
        // index.html 기본 상위 폴더 경로를
        // (기존) static 폴더
        // (변경) templates 폴더(폴더 경로 - "D:\minjae\test_ssflex-manager\web\src\main\resources\templates")로 html 파일을 옮겨야 잘 동작한다.
        // 2. html 파일("index.html")을 유저에게 보내주세요.
        return "index.html";   // index.html 기본 상위 폴더 경로 (기존) static 폴더 -> (변경) templates 폴더
    }

    // 웹서버 API - 메인 웹페이지("/")
    // @GetMapping("/")   // 1. 메인 웹페이지 URL("/")로 HTTP - GET method 요청(접속) 날리면
    // @ResponseBody   // 메서드 hello 몸체 안 return문 오른쪽에 있는 문자열(간단한 문자 말고 html 코드 "<h4>안녕하쇼</h4>") 그대로 유저에게 전송
    // String hello() {
    //    return "<h4>안녕하쇼</h4>";   // 2. 이제 메인 웹페이지 URL("/")로 유저가 웹페이지 방문했을 때 유저에게 그 데이터(메세지)(간단한 문자 말고 html 코드 "<h4>안녕하쇼</h4>")를 보내준다.
    // }

    // 웹서버 API - 메인 웹페이지("/")
    // @GetMapping("/")   // 1. 메인 웹페이지 URL("/")로 HTTP - GET method 요청(접속) 날리면
    // @ResponseBody   // 메서드 hello 몸체 안 return문 오른쪽에 있는 문자열("안녕하쇼") 그대로 유저에게 전송
    // String hello() {
    //    return "안녕하쇼";   // 2. 이제 메인 웹페이지 URL("/")로 유저가 웹페이지 방문했을 때 유저에게 그 데이터(메세지)("안녕하쇼")를 보내준다.
    // }

    // 웹서버 API - 피싱사이트 소개글 웹페이지("/about")
    @GetMapping("/about")   // 1. 피싱사이트 소개글 웹페이지("/about")로 HTTP - GET method 요청(접속) 날리면
    @ResponseBody  // 메서드 about 몸체 안 return문 오른쪽에 있는 문자열("피싱사이트에요") 그대로 유저에게 전송
    String about() {
        return "피싱사이트에요";   // 2. 피싱사이트 소개글 웹페이지("/about")로 유저가 웹페이지 방문했을 때 유저에게 그 데이터(메세지)("피싱사이트에요")를 보내준다.
    }

    // 웹서버 API - 마이페이지 소개글 웹페이지("/mypage")
    @GetMapping("mypage")   // 1. 마이페이지 소개글 웹페이지("/mypage")로 HTTP - GET method 요청(접속) 날리면
    @ResponseBody   // 메서드 mypage 몸체 안 return문 오른쪽에 있는 문자열("마이페이지입니다") 그대로 유저에게 전송
    String mypage() {
        return "마이페이지입니다";   // 2. 마이페이지 소개글 웹페이지("/mypage")로 유저가 웹페이지 방문했을 때 유저에게 그 데이터(메세지)("마이페이지입니다")를 보내준다.
    }

    // 오늘의 숙제 :
    // 누가 /date 로 접속하면 현재 날짜와 시간을 보내주는 기능을 만들어봅시다.
    // http://localhost:8080/date로 접속시 날짜와 시간이 대충 아무렇게나 보이면 성공입니다.
    // 굳이 HTML 말고 날짜 데이터만 보내줘도 됩니다.
    @GetMapping("/date")
    @ResponseBody   // 메서드 date 몸체 안 return문 오른쪽에 있는 문자열(현재 날짜와 시간 - ZonedDateTime.now().toString()) 그대로 유저에게 전송
    String date() {
        // 현재 날짜와 시간 구하기
        // return LocalDateTime.now().toString();
        return ZonedDateTime.now().toString();

        // TODO: 자바스프링(Java Spring) 현재 날짜와 시간 구하기 (2025.07.24 minjae)
        // 참고 URL - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Date.html#%3Cinit%3E()
        // 참고 2 URL - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html#%3Cinit%3E(java.lang.String)
        // 참고 3 URL - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/Format.html#format(java.lang.Object)
        // 참고 4 URL - https://devsmaru.tistory.com/22
        // 참고 5 URL - https://greenyellow-s.tistory.com/30

        // Date today = new Date();
        // SimpleDateFormat formatMethod = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm:ss");
        // String todayDateStr = formatMethod.format(today);
        // return todayDateStr;
    }

    // 웹서버 API 작성 예시
    // @GetMapping("/경로")   // @GetMapping() 안에 웹페이지 경로("/경로") 적기
    // @ResponseBody
    // String hello() {
    //     return "유저에게 보내줄데이터"; // 이제 "/경로"로 유저가 웹페이지 방문했을 때 유저에게 그 데이터(메세지)("유저에게 보내줄데이터")를 보내준다.
    // }
} 
