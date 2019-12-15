package com.hilu0318.meta.core.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hilu0318.meta.cmm.domain.MData;
import com.hilu0318.meta.cmm.exception.DuplicateException;
import com.hilu0318.meta.cmm.exception.ValidationException;
import com.hilu0318.meta.core.service.MetaWordProcService;

@Controller
@RequestMapping(value = "/rgst")
public class MetaRgstController {
	@Inject
	private MetaWordProcService service;
	
	/**
	 *	URL			: /rgst
	 *	method		: get
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadRgstGet(@RequestParam Map<String, Object> iData, Model model){
//		MData rIqryMetaWordGet 	= new MData();
//		MData error 			= new MData();
		
		return "menu/rgst";
	}
	
	/**
	 *	URL			: /rgst/word
	 *	method		: get
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/word", method = RequestMethod.GET)
	public String iqryMetaWordGet(@RequestParam Map<String, Object> iData, Model model){
		MData rIqryMetaWord = new MData();
		MData iIqryMetaWord	= new MData(iData);
		MData error 		= new MData();
		
		try {
			rIqryMetaWord = service.iqryMetaWordIqry(iIqryMetaWord);
			//Map<String, Object> rData = service.iqryMetaWordIqry(iData);
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			rIqryMetaWord = iIqryMetaWord;
			error.setString("yn", "Y");
			error.setString("type", "warn");
			error.setString("msg", "조회 결과가 없습니다.");
			e.printStackTrace();
			model.addAttribute("error", error);
		}
//		rIqryMetaWord.setBoolean("exists", true);
		model.addAttribute("rIqryMetaWord", rIqryMetaWord);
		model.addAttribute("service_name", "rIqryMetaWord");
		
		return "menu/rgst";
	}
	
	/**
	 *	URL			: /rgst/word
	 *	method		: post
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/word", method = RequestMethod.POST)
	public String rgstMetaWordPost(@RequestParam Map<String, Object> iData, Model model){
		MData iRgstMetaWordPost = new MData(iData);
		MData rRgstMetaWordPost = new MData();
		MData error 			= new MData();
		try {
			rRgstMetaWordPost = service.rgstMetaWord(iRgstMetaWordPost);
			
		} catch (ValidationException e) {
			//error.setBoolean(e.getMessage(), true);
			error.setString("yn", "Y");
			error.setString("type", "warn");
			error.setString("msg", "[" + e.getMessage() + "] 필수 입력값입니다.");
			e.printStackTrace();
			model.addAttribute("error", error);
			
			rRgstMetaWordPost = iRgstMetaWordPost;
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			error.setString("yn", "Y");
			error.setString("type", "warn");
			error.setString("msg", "이미 등록된 단어입니다.");
			e.printStackTrace();
			model.addAttribute("error", error);
		}
//		rRgstMetaWordPost.setBoolean("exists", true);
		model.addAttribute("rRgstMetaWordPost", rRgstMetaWordPost);
		model.addAttribute("service_name", "rRgstMetaWordPost");
		return "menu/rgst";
	}
	
	/**
	 *	URL			: /rgst/term
	 *	method		: get
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/term", method = RequestMethod.GET)
	public String iqryMetaTermGet(@RequestParam Map<String, Object> iData, Model model) {
		MData rIqryMetaTerm 	= new MData();
		
		//rIqryMetaTerm = service.iqryMetaWordIqry(new MData(iData));
		
		//Map<String, Object> rData = service.iqryMetaWordIqry(iData);
		model.addAttribute("rIqryMetaTerm", rIqryMetaTerm);
		System.out.println("rIqryMetaTerm : " + rIqryMetaTerm.toString());
		
		return "menu/rgst";
	}
	
	/**
	 *	URL			: /rgst/term
	 *	method		: post
	 *	logicalName	: 
	 *	veiwPath	: 
	 */
	@RequestMapping(value = "/term", method = RequestMethod.POST)
	public String rgstMetaTermPost(@RequestParam Map<String, Object> iData, Model model) {
		MData rIqryMetaTerm 	= new MData();
		MData error 			= new MData();
		try {
			rIqryMetaTerm = service.rgstMetaWord(new MData(iData));
			model.addAttribute("rIqryMetaTerm", rIqryMetaTerm);
			
		} catch (ValidationException e) {
			error.setBoolean(e.getMessage(), true);
			e.printStackTrace();
			model.addAttribute("error", error);
			return "menu/rgst";
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "menu/rgst";
	}
}
