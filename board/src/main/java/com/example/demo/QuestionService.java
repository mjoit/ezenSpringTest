package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionResponsitory qr;
	
	public List<Question> getList(){
		return this.qr.findAll();
	}
	
	public Question getQuestion(Integer id) throws PpakchimException {
		// 도전과제
		// 존재하지 않는 데이터를 조회할때는
		// 데이터를 찾을 수 없습니다 라는
		// PpakchimException을 구현해볼 것
		Optional<Question> q1 = this.qr.findById(id);
		if(q1.isPresent()) {
			return q1.get();
		}else {
			throw new PpakchimException("데이터를 찾을 수 없습니다");
		}
		
	}

	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.qr.save(q);
		
		
	}
	

}
