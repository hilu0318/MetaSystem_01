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
	 * description 	: text�� null�̰ų� ������ ��� true ����.
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
