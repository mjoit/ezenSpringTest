package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jayway.jsonpath.Option;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private QuestionResponsitory qRepo;
	
	@Test
	void contextLoads() {
		
		Question q1 = new Question();
		q1.setSubject("군침도는 메뉴 추천해주세요");
		q1.setContent("저는 오이 알레르기가 있어요." + " 근데 오이향은 좋아해요.");
		
		q1.setCreateDate(LocalDateTime.now());
		this.qRepo.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("감기 조심하세요");
		q2.setContent("요즘 독감이 유행하고 있습니다.");
		
		q2.setCreateDate(LocalDateTime.now());
		this.qRepo.save(q2);
		
		// findAll : 데이터 전체조회(해당 리파지토리에 있는)
		List<Question> sel = this.qRepo.findAll();
		
		System.out.println(sel.toString());
		
		Question q = sel.get(1);
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		
		//assertEquals
		// 기댓값이 실제값과 똑같은지 체크하는 메서드
		// 데이터를 가늠잡고 싶을때 주로 사용
		// 2024.07.23일을 기준으로 현 DB에 데이터 수는 3건
		// 하지만 기댓값을 100으로 적으니 데이터 수가 맞지 않아
		// JUnit 테스트 결과가 Failure로 뜸
		// assertEquals(100, sel.size());
		// assertEquals("군침이싹도노", q.getSubject());
		
		// 데이터 수정
		// findById
//		Optional<Question> oq = this.qRepo.findById(1);
//		Question q2 = oq.get();
//		q2.setSubject("점심메뉴 추천좀요");
//		this.qRepo.save(q2);
		
		// 데이터 삭제
		// delete
		Optional<Question> oq = this.qRepo.findById(1);
		Question q3= oq.get();
		this.qRepo.delete(q3);
		
	}

}
