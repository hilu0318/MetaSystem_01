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
import com.hilu0318.meta.core.service.MetaWordIqryService;

@Controller
public class MetaWordServiceController {
	
	@Inject
	private MetaWordIqryService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/meta", method = RequestMethod.GET)
	public String loadIqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		
		return "main";
	}
	
	/**
	 *	URL			: 
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/meta/word", method = RequestMethod.GET)
	public String iqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		MData rIqryMetaWordGet 	= new MData();
		
		rIqryMetaWordGet = service.iqryMetaWordIqry(new MData(iData));
		
		//Map<String, Object> rData = service.iqryMetaWordIqry(iData);
		model.addAttribute("rIqryMetaWordGet", rIqryMetaWordGet);
		System.out.println("rIqryMetaWordGet : " + rIqryMetaWordGet.toString());
		return "main";
	}
}
