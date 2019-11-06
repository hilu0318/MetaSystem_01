package com.hilu0318.meta.core.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.core.dao.WordBsicDao;

@Service
public class MetaWordIqryService {
	
	@Inject
	private WordBsicDao dao;
	
	public MData iqryMetaWordIqry(MData iData){
		//--------------------------------------------------//
		//변수 선언 및 초기화.
		//--------------------------------------------------//		
		MData rData 			= new MData();	//결과값
		MData iIqryRgstWord 	= new MData();	//i등록단어조회 
		MData rIqryRgstWord 	= new MData();	//r등록단어조회
		
		//--------------------------------------------------//
		//등록단어조회 입력값 세팅.
		//--------------------------------------------------//
		iIqryRgstWord.put("word_nm", iData.get("word_nm"));		//단어명 
		
		//--------------------------------------------------//
		//등록단어조회 Dao 호출.
		//--------------------------------------------------//
		rIqryRgstWord = dao.iqryRgstWord(iIqryRgstWord);
		System.out.println("rIqryRgstWord : " + rIqryRgstWord.toString());
		//--------------------------------------------------//
		//등록단어조회 결과값 세팅.
		//--------------------------------------------------//
		rData.put("word_seqno", rIqryRgstWord.get("word_seqno"));	//단어일련번호 
		rData.put("word"	  , rIqryRgstWord.get("word"	  ));	//단어
		rData.put("word_nm"	  , rIqryRgstWord.get("word_nm"	  ));	//단어명 
		System.out.println("Service rData : " + rData.toString());
		return rData;
	}
}
