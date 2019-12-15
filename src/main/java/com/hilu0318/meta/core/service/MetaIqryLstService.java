package com.hilu0318.meta.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.domain.MLData;
import com.hilu0318.meta.cmm.util.MStringUtils;
import com.hilu0318.meta.core.dao.WordBsicDao;

@Service
public class MetaIqryLstService {

	@Inject
	private WordBsicDao dao;
	
	/**
	 * @logicalName	: iqryLstWord
	 * @description	: 
	 * @throws 		: 
	 */
	public MData iqryLstWord(MData iData) {
		//--------------------------------------------------//
		//변수 선언 및 초기화.
		//--------------------------------------------------//		
		MData 	rData				= new MData();	//결과값
		MData 	iIqryLstMetaWord 	= new MData();				//i등록단어조회
		MLData	rIqryLstMetaWord	= new MLData();				//r등록단어조회
		
		//MData tIqryLstMetaWord 			= new MData();
		
		//--------------------------------------------------//
		//등록단어조회 입력값 세팅.
		//--------------------------------------------------//
		if(!MStringUtils.isEmpty((String)iData.get("word"))) {
			iIqryLstMetaWord.setString("word"	, iData.get("word"		));		//단어
		}
		if(!MStringUtils.isEmpty((String)iData.get("word_nm"))) {
			iIqryLstMetaWord.setString("word_nm", iData.get("word_nm"	));		//단어명 
		}
		
		rIqryLstMetaWord = dao.iqryLstMetaWord(iIqryLstMetaWord);
		
		//--------------------------------------------------//
		//등록단어조회 결과값 세팅.
		//--------------------------------------------------//
		List<MData> _t_IqryLstMetaWord 	= new ArrayList<MData>();	//r등록단어조회
		
		for(MData tIqryLstMetaWord : rIqryLstMetaWord) {
			MData t_iqryLstMetaWord = new MData();
			t_iqryLstMetaWord.setString("no"		, tIqryLstMetaWord.get("no"			));
			t_iqryLstMetaWord.setString("word"		, tIqryLstMetaWord.get("word"		));
			t_iqryLstMetaWord.setString("word_nm"	, tIqryLstMetaWord.get("word_nm"	));
			t_iqryLstMetaWord.setString("word_cmnt"	, tIqryLstMetaWord.get("word_cmnt"	));
			t_iqryLstMetaWord.setString("use_yn"	, tIqryLstMetaWord.get("use_yn"		));
			t_iqryLstMetaWord.setString("del_yn"	, tIqryLstMetaWord.get("del_yn"		));
			t_iqryLstMetaWord.setString("rgst_user"	, tIqryLstMetaWord.get("rgst_user"	));
			_t_IqryLstMetaWord.add(t_iqryLstMetaWord);
		}
		
		rData.setList("iqryLstWord", _t_IqryLstMetaWord);
		return rData;
	}
}
