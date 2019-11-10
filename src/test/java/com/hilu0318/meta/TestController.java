package com.hilu0318.meta;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hilu0318.meta.cmm.util.ClassInfoUtil;
import com.hilu0318.meta.core.dao.WordBsicDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class TestController {
	
	@Inject
	private DataSource dataSource;
	
	private static String namespace = "test";
	
	@Inject
	private SqlSessionFactory sessionFactory;
	
	@Inject
	private WordBsicDao dao;
	
	@Test
	public void testControll() {
//		Map<String, Object> iData = new HashMap<String, Object>();
//		Map<String, Object> rData = new HashMap<String, Object>();
//		iData.put("word_nm", "단어");
//		///rData = dao.iqryRgstWord(iData);
//		System.out.println(rData.toString());
		if(this.getClass() == null) {
			System.out.println("Null");
		}else {
			System.out.println("Not Null");
		}
		
		
		
//		System.out.println();
//		System.out.println(ClassInfoUtil.getRunMethodName(this.getClass()));
		
	}
		
}
