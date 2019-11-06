package com.hilu0318.meta.core.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hilu0318.meta.core.service.MetaWordIqryService;

@Controller
@RequestMapping(value = "/meta")
public class MetaWordServiceController {
	
	@Inject
	private MetaWordIqryService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		
		System.out.println(iData.toString());
		//Map<String, Object> rData = service.iqryMetaWordIqry(iData);
		
		return "main";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/word", method = RequestMethod.GET)
	public String iqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		
		System.out.println(iData.toString());
		//Map<String, Object> rData = service.iqryMetaWordIqry(iData);
		
		return "main";
	}
}
