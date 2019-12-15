package com.hilu0318.meta.cmm.domain;

import java.util.ArrayList;
import java.util.List;

public class MLData extends ArrayList<MData> {

	public MLData() {
		super();
	}
	
	public void setList(List<Object> iList) {
		for(Object tObj : iList) {
			super.add((MData)tObj);
		}
	}
}
