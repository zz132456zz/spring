package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {
	
//	@Autowired
//	@Qualifier("usedDao")
//	private WordDao wordDao;
	
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;
	
	public WordSearchService() {
		
	}
	
	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}