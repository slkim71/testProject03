package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import javax.annotation.Resource;
import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	// �̷������� ������ �ܿ� property���� Autowired�� �־��� �� �ִ�
//	@Autowired
//	@Qualifier("usedDao")
//	@Resource
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;
	
	// ��, property�� method�� Autowird�� ����ϰ� �ʹٸ� ��.��.�� default �����ڸ� ���������Ѵ�
	public WordRegisterService() {
		// ����Ʈ ������ ���� ������� �Ʒ�ó�� �Ķ���� �Ѱ� �޴� �����ڸ� �����ϰ� �ִٸ�,
		//			public WordRegisterService(WordDao wordDao) {
		//				this.wordDao = wordDao;
		//			}
		// @Autowired�� �Ķ���� �޴°��� �����ϱ� ��ã����?
	}
	
	// parameter�� wordDao�� �ް��ֳ� ??
	// @Autowired
	// @Resource
	// Resource�� �����ڿ��� ������, property �Ǵ� method�� ��� ����
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
	
	// �ߺ��� Ű���尡 �ִ��� �˻���!
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	// �Ǵ� �̷� method���� Autowired�� �־��� �� �ְ���
	//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
