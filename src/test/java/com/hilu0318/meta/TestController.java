package com.hilu0318.meta;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.core.dao.WordBsicDao;
import com.hilu0318.meta.core.service.MetaIqryLstService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class TestController {
	
	@Inject
	private WordBsicDao dao;
	
	@Inject
	private MetaIqryLstService service;
	
	@Inject
	private DataSource datasource;
	
	@Test
	public void testControll() {
		Map<String, Object> iData = new HashMap<String, Object>();
		Map<String, Object> rData = new HashMap<String, Object>();
		List<MData> list = new ArrayList<MData>();
		MData inData = new MData();
		MData reData = new MData();
//		inData.setString("word_nm", "단어");
//		dao.iqryLstMetaWord(inData);
		service.iqryLstWord(inData);
//		System.out.println();
//		System.out.println(ClassInfoUtil.getRunMethodName(this.getClass()));
		
	}
		
}
