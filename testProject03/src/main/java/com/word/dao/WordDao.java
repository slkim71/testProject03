package com.word.dao;

// 아직 연결한 DB가 없으니까 Map 데이터를 사용한다
import java.util.HashMap;
import java.util.Map;

import com.word.WordSet;

public class WordDao {
	private Map<String, WordSet> wordDB = new HashMap<String, WordSet>();
	
	public void insert(WordSet wordSet) {
		wordDB.put(wordSet.getWordKey(), wordSet);
	}
	
	public WordSet select(String wordKey) {
		return wordDB.get(wordKey);
	}
	
	public void update(WordSet wordKey) {
		wordDB.put(wordKey.getWordKey(), wordKey);
	}
	
	public void delete(String sNum) {
		wordDB.remove(sNum);
	}
	
	public Map<String, WordSet> getWordDB() {
		return wordDB;
	}
}
