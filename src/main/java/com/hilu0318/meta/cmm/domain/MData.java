package com.hilu0318.meta.cmm.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.type.Alias;

@Alias("mdata")
public class MData extends HashMap<String, Object>{

	public MData() {
		super();
	}
	
	public MData(Map<String, Object> iMap) {
		setMap(iMap);
	}
	
	public Object put(String key, Object value) {
		return super.put(key.toLowerCase(), value);
	}
	
	public void setMap(Map<String, Object> iMap) {
		Iterator<String> iter = iMap.keySet().iterator();
		String key = "";
		while(iter.hasNext()) {
			key = iter.next();
			super.put(key, iMap.get(key));
		}
		System.out.println("setMap.toString : " + super.toString());
	}
}
