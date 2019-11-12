package com.hilu0318.meta.cmm.util;

public class MStringUtils {

	public static boolean isTrimNEmpty(String txt) {
		boolean result = true;
		if(txt != null && txt.trim() != "") {
			result = false;
		}
		return result;
	}
	
	/*
	 * description	: 문자열이 null이거나 공란일 경우 true를 리턴.
	 * return type	: boolean
	 */
	public static boolean isEmpty(String txt) {
		boolean result = true;
		if(txt != null && txt != "") {
			result = false;
		}
		return result;
	}
}
