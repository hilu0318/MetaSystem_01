<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/resources/cmm/jsp/inHtmlHead.jsp"/>

<div class="container mar-top-30">
	<div class="row">
		
		<div class="list-group">
			<a href="/rgst" 		class="list-group-item">단어/용어 등록/조회.</a>
			<a href="/iqryWordLst" 	class="list-group-item">단어 목록 조회.</a>
			<a href="/iqryTermLst" 	class="list-group-item">용어 목록 조회.</a>
		</div>
		
	</div>
</div>

<!-- 스크립트 시작 -->
   
<script type="text/javascript">
	
	var form_iqry_word = $("#form_iqry_word"); 	//document.getElementById("form_iqry_word");
	var form_rgst_word = $("#form_rgst_word");	//document.getElementById("form_rgst_word");
	  
	function on_click_btn_iqry_word(event){
		var nWord		= $("#word").val();		//document.getElementById("word").value;
	  	
		if(nWordNm == ""){
			alert("단어 명 입력 바랍니다.");
			return;
		}
		$(form_iqry_word).submit();
	}
	   
	function on_click_btn_rgst_word(event){
		var nWord		= $("#word").val();			//document.getElementById("word").value;
		var nWordNm 	= $("#word_nm").val(); 		//document.getElementById("word_nm").value;
		var nWordCmnt	= $("#word_cmnt").val(); 	//document.getElementById("word_cmnt").value;
		
		if(nWord == "" || nWord == null){
			alert("단어 입력 바랍니다.");
			return;
		}
		if(nWordNm == "" || nWordNm == null){
			alert("단어명 입력 바랍니다.");
			return;
		}
		
		$(form_rgst_word).submit();
	    
	}
	
	//DomUtil.setValueForElemntByName("word_cmnt", "TEST");
	
</script>

<jsp:include page="/resources/cmm/jsp/inHtmlBottom.jsp"/>
		