package com.test_humanwares.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// * intellij community 에디터 설치 방법
// 참고 URL - https://blog.naver.com/PostView.naver?blogId=djusti&logNo=223143383341
// 참고 2 URL - https://priming.tistory.com/50
//
// * spring initializr 이용하여 프로젝트 생성
// 참고 URL - https://start.spring.io/
// 참고 2 URL - https://guns23.tistory.com/8
// 참고 3 URL - https://nohriter.tistory.com/115

// SpringBoot는 내부적으로 아파치 톰캣(Apache Tomcat) 웹서버 엔진을 이용하며 기본적으로 8080 포트(Port)에 띄워준다.
// 아래 URL 주소로 웹페이지 열면 아래와 같은 404 페이지가 뜨는 이유는 WebApplication.java 소스파일에서 내부적으로 코드를 짜서 개발하지 않았기 때문이다.
// http://localhost:8080/
// Whitelabel Error Page
// This application has no explicit mapping for /error, so you are seeing this as a fallback.
// Tue Jul 22 08:34:49 KST 2025
// There was an unexpected error (type=Not Found, status=404).

// 포트(Port)란 내 컴퓨터에 다른 사람들이 접속할 수 있게 만든 구멍이다.
// 컴퓨터 하나당 포트(Port)는 약 2만개 있다.
// (예) 내 컴퓨터에 다른 사람들이 접속할 수 있게 포트(Port) 8080 만들어 놓고
//      다른 사람들이 포트(Port) 8080으로 접속해면 내 컴퓨터에서 웹페이지 보내주면 그게 웹서버이다.

@SpringBootApplication
public class WebApplication {
	// 프로젝트 "web" 시작시 프로그램 시작 지점 (main 메서드)
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);    // Spring boot로 만든 웹서버 띄우기
	}

}
