package com.hilu0318.meta.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.exception.ValidationException;
import com.hilu0318.meta.core.service.MetaWordProcService;

@Controller
public class MetaPageLoadController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		
		return "main";
	}
	
	
	/**
	 *	URL			: 
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/iqryTermLst", method = RequestMethod.GET)
	public String loadIqryTermLstGet(@RequestParam Map<String, Object> iData, Model model){
//		MData rIqryMetaWordGet 	= new MData();
//		MData error 			= new MData();
		
		return "menu/iqryTermLst";
	}
}
