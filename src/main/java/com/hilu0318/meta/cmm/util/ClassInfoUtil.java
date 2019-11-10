package com.hilu0318.meta.cmm.util;

public class ClassInfoUtil {

	public static String getRunMethodName(Object obj) {
		return obj.getClass().getEnclosingMethod().getName();
	}
	
}
