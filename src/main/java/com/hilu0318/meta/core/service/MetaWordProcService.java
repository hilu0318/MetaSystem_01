package com.hilu0318.meta.core.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.exception.DuplicateException;
import com.hilu0318.meta.cmm.exception.ValidationException;
import com.hilu0318.meta.cmm.util.MStringUtils;
import com.hilu0318.meta.core.dao.WordBsicDao;

@Service
public class MetaWordProcService {
	
	@Inject
	private WordBsicDao dao;
	
	/**
	 * @logicalName	: iqryMetaWordIqry
	 * @description	: 
	 * @throws 		: DuplicateException, EmptyException
	 */
	public MData iqryMetaWordIqry(MData iData) throws NotFoundException{
		//--------------------------------------------------//
		//변수 선언 및 초기화.
		//--------------------------------------------------//		
		MData rData				= new MData();	//결과값
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
		rData.put("word"	  , rIqryRgstWord.get("word"	  ));	//단어
		rData.put("word_nm"	  , rIqryRgstWord.get("word_nm"	  ));	//단어명
		rData.put("word_cmnt" , rIqryRgstWord.get("word_cmnt" ));	//단어명
		return rData;
	}
	
	/** 
	 * @logicalName	: rgstMetaWord
	 * @description	: 
	 * @throws 		: DuplicateException, EmptyException
	 */
	public MData rgstMetaWord(MData iData) throws DuplicateException, ValidationException{
		//--------------------------------------------------//
		//변수 선언 및 초기화.
		//--------------------------------------------------//		
		MData rData				= new MData();				
		MData iRgstMetaWord 	= new MData();	//i등록단어조회 
		MData rRgstMetaWord 	= new MData();	//r등록단어조회 
		
		
		//--------------------------------------------------//
		//필수값 체크
		//--------------------------------------------------//
		if(MStringUtils.isTrimNEmpty((String)iData.get("word1"))){
			throw new ValidationException("word");
		}
		if(MStringUtils.isTrimNEmpty((String)iData.get("word_nm1"))){
			throw new ValidationException("word_nm");
		}
//		일단, 사용자 정보 프로그램 미개발로 나중에 해당 조건 적용하기.
//		if(MStringUtils.isTrimNEmpty((String)iData.get("rgst_user"))){
//			throw new EmptyException();
//		}
		
		try {
			//--------------------------------------------------//
			//메타단어등록 입력값 세팅.
			//--------------------------------------------------//
			iRgstMetaWord.setString("word"		, iData.get("word1"		));		//단어
			iRgstMetaWord.setString("word_nm"	, iData.get("word_nm1"	));		//단어명
			iRgstMetaWord.setString("word_cmnt"	, iData.get("word_cmnt"	));		//단어설명
			iRgstMetaWord.setString("use_yn"	, iData.get("use_yn"	));		//사용여부 
			iRgstMetaWord.setString("del_yn"	, iData.get("del_yn"	));		//삭제여부 
			iRgstMetaWord.setString("rgst_user"	, iData.get("rgst_user"	));		//등록자용자 
			
			//--------------------------------------------------//
			//메타단어등록 Dao 호출.
			//--------------------------------------------------//
			dao.rgstMetaWord(iRgstMetaWord);
			
//			rData.setString("word"		, iRgstMetaWord.get("word"		));		//단어
//			rData.setString("word_nm"	, iRgstMetaWord.get("word_nm"	));		//단어명
//			rData.setString("word_cmnt"	, iRgstMetaWord.get("word_cmnt"	));		//단어설명
//			rData.setString("use_yn"	, iRgstMetaWord.get("use_yn"	));		//사용여부 
//			rData.setString("del_yn"	, iRgstMetaWord.get("del_yn"	));		//삭제여부 
//			rData.setString("rgst_user"	, iRgstMetaWord.get("rgst_user"	));		//등록자용자 
		}catch (Exception e) {
			// TODO: handle exception
			throw new DuplicateException();
		}
		return rData;
	}
}
