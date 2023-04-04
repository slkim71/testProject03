package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import javax.annotation.Resource;
import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	// 이런식으로 생성자 외에 property에도 Autowired를 넣어줄 수 있다
//	@Autowired
//	@Qualifier("usedDao")
//	@Resource
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;
	
	// 단, property나 method에 Autowird를 사용하고 싶다면 반.드.시 default 생성자를 명시해줘야한다
	public WordRegisterService() {
		// 디폴트 생성자 없이 예를들어 아래처럼 파라미터 한개 받는 생성자만 존재하고 있다면,
		//			public WordRegisterService(WordDao wordDao) {
		//				this.wordDao = wordDao;
		//			}
		// @Autowired가 파라미터 받는곳에 없으니까 못찾겠지?
	}
	
	// parameter로 wordDao를 받고있네 ??
	// @Autowired
	// @Resource
	// Resource는 생성자에는 못쓰고, property 또는 method에 사용 가능
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey= wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered");
		}
	}
	
	// 중복된 키워드가 있는지 검사해!
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	// 또는 이런 method에도 Autowired를 넣어줄 수 있겠지
	//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
