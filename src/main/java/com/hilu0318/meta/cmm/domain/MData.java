package com.hilu0318.meta.cmm.domain;

import java.math.BigDecimal;
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
	
	public Object set(String key, Object value) {
		return this.put(key, value);
	}
	
	public Object setString(String key, Object value) {
		return this.put(key, (String)value);
	}
	
	public Object setInt(String key, Object value) {
		return this.put(key, (int)value);
	}
	public Object setLong(String key, Object value) {
		return this.put(key, (long)value);
	}
	public Object setBigDecimal(String key, Object value) {
		return this.put(key, (BigDecimal)value);
	}
	public Object setFloat(String key, Object value) {
		return this.put(key, (float)value);
	}
	public Object setDouble(String key, Object value) {
		return this.put(key, (double)value);
	}
	public Object setBoolean(String key, Object value) {
		return this.put(key, (boolean)value);
	}
}
