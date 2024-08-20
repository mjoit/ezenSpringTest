package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//Type: DB로 저장할 테이블의 엔티티를 기재, ID: 해당 테이블 엔티티에 @ID 적용되어있는 속성의 타입을 기재
//JPA리파지토리 인터페이스
//- JPA가 제공하는 인터페이스 중 하나
//- CRUD( Create Read Update Delete) 작업을 처리하는 메서드들이 이미 내장
public interface QuestionResponsitory extends JpaRepository<Question, Integer>{

}


