package com.hilu0318.meta.core.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class WordBsicDao {
	
	private static String namespace = "MT_WRD001";
	
	@Inject
	private SqlSession sqlSession;
	
	public Map<String, Object> iqryRgstWord(Map<String, Object> iData){
		
		Map<String, Object> rData;
		
		rData = sqlSession.selectOne(namespace + ".iqryRgstWord", iData);
	
		return rData;
	}
}
