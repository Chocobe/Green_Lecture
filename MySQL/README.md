# MySQL

## MySQL 다운 및 설치

>   ### 다운로드

    1. MySQL 검색
    
    1. 상단 메뉴 중, ``DOWNLOADS`` 선택
    
    1. 페이지 최하단의 ``MySQL Community (GPL) Downloads`` 선택
    
    1. ``MySQL Community Server`` 선택
    
    1. ``Windows (x86, 64-bit), ZIP Archive Debug Binaries & Test Suite`` 다운로드
    
---
    
>   ### 설치

    1. 설치파일 실행
    
    1. ``Developer Default`` 선택
    
    1. ``execute`` 선택
    
    1. ``execute`` 선택
    
---
    
>   ### 빌드패스 설정

    1. ``Program files``의 ``MyOracl`` -> ``server`` -> ``bin`` 폴더 경로를 빌드패스로 등록
    
    1. 예 : ``C:\Program Files\MySQL\MySQL Server 8.0\bin``
    
---
    
>   ### 설치 검사

    1. ``cmd`` 실행
    
    1. 명령 : ``mysql`` 입력 -> 엔터
    
    1. 결과로 ``연결할 수 없습니다``가 뜨면, 정상 설치 (``파일을 찾을 수 없습니다``가 뜨면 설치 실패)
    
        * ** 만약, ``mysql``입력으로 접미사가 ``mysql``로 바뀐다면, 비밀번호가 없이 생성된 상태다(설치 버그)

---

## Heidisql 다운로드 및 설치

>   ### 다운로드

1. ``heidi``검색

1. 다운로드

1. 기본 설정으로 설치

---

## Heidisql을 이용한 MySQL 사용하기

>   ### 세션 만들기

1. ``Heidisql``실행

1. ``세션이름``에 사용할 세션명 입력

1. ``사용자``, ``비밀번호``, ``포트번호`` 입력 후, **저장**

    * ``사용자``는 설치 시 기본 사용자인 ``root``와 설치 시 설정했던 ``비밀번호``, ``포트번호`` 사용

1. ``열기``

---

>   ### 데이터베이스 만들기

1. ``CREATE DATABASE 데이터베이스명;``