package com.hilu0318.meta.core.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.domain.MLData;
import com.hilu0318.meta.cmm.exception.DuplicateException;

@Repository
public class WordBsicDao {
	
	private static String namespace = "MT_WRD001";
	
	@Inject
	private SqlSession sqlSession;
	
	/**
	 *	logicalName	: iqryRgstWord
	 *	description	: 
	 */
	public MData iqryRgstWord(MData iData) throws NotFoundException{
		
		MData rData = new MData();
		
		rData = (MData)sqlSession.selectOne(namespace + ".iqryRgstWord", iData);
		System.out.println(rData == null);
		if(rData == null) {
			throw new NotFoundException("[( iqryRgstWord : rData is Null )]");
		}
		return rData;
	}
	
	/**
	 *	logicalName	: rgstMetaWord
	 *	description	: 
	 */
	public int rgstMetaWord(MData iData) throws DuplicateException {
		int rData = 0;
		rData = sqlSession.insert(namespace + ".rgstMetaWord",  iData);
		
		return rData;
	}
	
	/**
	 *	logicalName	: iqryLstMetaWord
	 *	description	: 
	 */
	public MLData iqryLstMetaWord(MData iData) {
		
//		List<MData> rDataLst = new ArrayList<MData>();
		MLData rDataLst = new MLData();
		
		rDataLst.setList(sqlSession.selectList(namespace + ".iqryLstMetaWord",  iData));
		
		return rDataLst;
	}
	
}
