package com.hilu0318.meta.core.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hilu0318.meta.cmm.domain.MData;

@Repository
public class WordBsicDao {
	
	private static String namespace = "MT_WRD001";
	
	@Inject
	private SqlSession sqlSession;
	
	public MData iqryRgstWord(MData iData){
		
		MData rData = new MData();
		
		rData = (MData)sqlSession.selectOne(namespace + ".iqryRgstWord", iData);
		
		return rData;
	}
	
	public int rgstMetaWord(MData iData) {
		int rData = 0;
		rData = sqlSession.insert(namespace + ".rgstMetaWord",  iData);
		return rData;
	}
}
