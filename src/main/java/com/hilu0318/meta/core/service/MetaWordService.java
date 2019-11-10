package com.hilu0318.meta.core.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.exception.EmptyException;
import com.hilu0318.meta.cmm.util.MStringUtils;
import com.hilu0318.meta.core.dao.WordBsicDao;

@Service
public class MetaWordService {
	
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
		iIqryRgstWord.setString("word_nm", iData.get("word_nm"));		//단어명 
		
		//--------------------------------------------------//
		//등록단어조회 Dao 호출.
		//--------------------------------------------------//
		rIqryRgstWord = dao.iqryRgstWord(iIqryRgstWord);
		//--------------------------------------------------//
		//등록단어조회 결과값 세팅.
		//--------------------------------------------------//
		rData.put("word_seqno", rIqryRgstWord.get("word_seqno"));	//단어일련번호 
		rData.put("word"	  , rIqryRgstWord.get("word"	  ));	//단어
		rData.put("word_nm"	  , rIqryRgstWord.get("word_nm"	  ));	//단어명
		return rData;
	}
	
	public MData rgstMetaWord(MData iData) throws EmptyException{
		//--------------------------------------------------//
		//변수 선언 및 초기화.
		//--------------------------------------------------//		
		MData rData 			= new MData();	//결과값
		MData iRgstMetaWord 	= new MData();	//i등록단어조회 
		int   rRgstMetaWord 	= 0;	//r등록단어조회
		
		//--------------------------------------------------//
		//필수값 체크
		//--------------------------------------------------//
		if(MStringUtils.isTrimNEmpty((String)iData.get("word1"))){
			throw new EmptyException("word");
		}
		if(MStringUtils.isTrimNEmpty((String)iData.get("word_nm1"))){
			throw new EmptyException("word_nm");
		}
//		일단, 사용자 정보 프로그램 미개발로 나중에 해당 조건 적용하기.
//		if(MStringUtils.isTrimNEmpty((String)iData.get("rgst_user"))){
//			throw new EmptyException();
//		}
		
		//--------------------------------------------------//
		//메타단어등록 입력값 세팅.
		//--------------------------------------------------//
		iRgstMetaWord.setString("word"		, iData.get("word1"		));		//단어명
		iRgstMetaWord.setString("word_nm"	, iData.get("word_nm1"	));		//단어명
		iRgstMetaWord.setString("word_cmnt"	, iData.get("word_cmnt"	));		//단어명
		iRgstMetaWord.setString("use_yn"	, iData.get("use_yn"	));		//단어명
		iRgstMetaWord.setString("del_yn"	, iData.get("del_yn"	));		//단어명
		iRgstMetaWord.setString("rgst_user"	, iData.get("rgst_user"	));		//단어명
		
		//--------------------------------------------------//
		//메타단어등록 Dao 호출.
		//--------------------------------------------------//
		rRgstMetaWord = dao.rgstMetaWord(iRgstMetaWord);
		
		//--------------------------------------------------//
		//메타단어등록 결과값 세팅.
		//--------------------------------------------------//
		rData.put("result_cnt", rRgstMetaWord);
		return rData;
	}
}
