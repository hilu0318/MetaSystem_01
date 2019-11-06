package com.hilu0318.meta.core.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hilu0318.meta.core.dao.WordBsicDao;

@Service
public class MetaWordIqryService {
	
	@Inject
	private WordBsicDao dao;
	
	public Map<String, Object> iqryMetaWordIqry(Map<String, Object> iData){
		Map<String, Object> rData = new HashMap<String, Object>();
		rData = dao.iqryRgstWord(iData);
		return rData;
	}
}
