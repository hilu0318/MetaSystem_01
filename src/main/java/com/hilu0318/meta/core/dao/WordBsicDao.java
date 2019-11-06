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
		System.out.println("Dao In");
		rData = (MData)sqlSession.selectOne(namespace + ".iqryRgstWord", iData);
		System.out.println("Dao Out");
		System.out.println("rData : " + rData.toString());
		
		return rData;
	}
}
