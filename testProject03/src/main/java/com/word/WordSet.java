package com.word;

// 단어의 키워드와 value 로 set을 만든다
public class WordSet {
	private String wordKey;
	private String wordValue;
	
	public WordSet(String wordKey, String wordValue) {
		this.wordKey = wordKey;
		this.wordValue = wordValue;
	}
	
	public String getWordKey() {
		return wordKey;
	}
	
	public void setWordKey(String wordKey) {
		this.wordKey = wordKey;
	}
	
	public String getWordValue() {
		return wordValue;
	}
	
	public void setWordValue(String wordValue) {
		this.wordValue = wordValue;
	}
}
