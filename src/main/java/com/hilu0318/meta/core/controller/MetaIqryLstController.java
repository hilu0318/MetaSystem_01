package com.hilu0318.meta.core.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.core.service.MetaIqryLstService;

@Controller
@RequestMapping(value = "/iqry")
public class MetaIqryLstController {

	@Inject
	private MetaIqryLstService service;
	
	/**
	 *	URL			: 
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/wordLst", method = RequestMethod.GET)
	public String iqryWordLstGet( @RequestParam Map<String, Object> iData, Model model
							 	, @RequestParam(name = "service", defaultValue = "N") String iServiceYn) {
		
		if(iServiceYn.equals("Y")) {
			System.out.println("iServiceYn : Y");
			MData rIqryWordLstGet	= new MData();
			MData iIqryWordLstGet	= new MData(iData);
			MData error 			= new MData();
			MData pageDto			= new MData();
			
			pageDto.setString("prev_yn"	, "N");
			pageDto.setInt("min_page"	, 0);
			pageDto.setInt("max_page"	, 0);
			pageDto.setString("next_yn"	, "N");
			
			if(iIqryWordLstGet.get("next_page") == null || iIqryWordLstGet.get("next_page").equals("0")) {
				pageDto.setString("prev_yn"	, "N");
				pageDto.setInt("min_page"	, 1);
			}
			
			rIqryWordLstGet = service.iqryLstWord(iIqryWordLstGet);
			
			model.addAttribute("pageDto"		, pageDto			);	//paging과 관련된 속성을 담은 객체.
			model.addAttribute("rIqryWordLstGet", rIqryWordLstGet	);
			model.addAttribute("service_name"	, "rIqryWordLstGet"	);
		}
		
		return "menu/iqryWordLst";
	}
}
