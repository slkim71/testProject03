package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	private WordDao wordDao;
	
	// parameter로 wordDao를 받고있네 ??
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
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
