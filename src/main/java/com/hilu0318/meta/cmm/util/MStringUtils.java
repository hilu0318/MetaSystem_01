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
	 * description 	: text가 null이거나 공백일 경우 true 리턴.
	 * return 		: boolean
	 */
	public static boolean isEmpty(String txt) {
		boolean result = true;
		if(txt != null && txt != "") {
			result = false;
		}
		return result;
	}
}
