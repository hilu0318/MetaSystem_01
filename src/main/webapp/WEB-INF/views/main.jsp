<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<jsp:include page="/resources/cmm/jsp/inBootHeadLink.jsp"/>
		<style media="screen">
	      .top-30 {
	        top:30px;
	      }
	      .mar-top-30 {
	        margin-top: 30px;
	      }
	      .input_align_right {
	        text-align: right;
	        padding-right:5px;
	      }
	      input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button {
	          -webkit-appearance: none;
	          margin: 0;
	      }
	    </style>
		<jsp:include page="/resources/cmm/jsp/inJqueryHeadScript.jsp"/>
	</head>
	<body>
		<div class="container mar-top-30">
			<div class="row">
				
				<form id="form_iqry_word" class="form-inline" method="get" action="/meta/word">
					<div class="form-group">
						<input type="text" class="form-control" id="word_nm" name="word_nm" placeholder="단어명" value="${ rIqryMetaWordGet.word_nm }">
					</div>
					<button type="submit" class="btn btn-default" id="btn_iqry_word" onclick="on_click_btn_iqry_word(event)">
						조회
					</button>
					<div class="form-group">
						<input type="text" class="form-control" id="word" name="word" placeholder="결과" value="${ rIqryMetaWordGet.word }" readonly>
					</div>
					<div hidden>
						<input type="text" id="word_seqno" name="word_seqno" value="${ rIqryMetaWordGet.word_seqno }" hidden>
					</div>
				</form>
				
			</div>
		</div>
		

	    <div class="container mar-top-30">
			<div class="row">
			
				<form id="form_rgst_word" class="form-inline" method="post" action="/meta/word">
					<div class="form-group">
						<input type="text" class="form-control" id="word1" name="word1" placeholder="단어">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="word_nm1" name="word_nm1" placeholder="단어명">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="word_cmnt" name="word_cmnt" placeholder="단어설명">
					</div>
					<div hidden>
						<input type="text" name="use_yn" value="Y" hidden>
						<input type="text" name="del_yn" value="N" hidden>
						<input type="text" name="rgst_user" value="hilu0318" hidden>
					</div>
					<button type="button" class="btn btn-default" id="btn_rgst_word" onclick="on_click_btn_rgst_word(event)">
						등록
					</button>
				</form>
				
			</div>
		</div>
		
	
	    <!-- 스크립트 시작 -->
	    <jsp:include page="/resources/cmm/jsp/inBottomBodyScriptDefault.jsp"/>
	    
	    <script type="text/javascript">
	    var form_iqry_word = document.getElementById("form_iqry_word");
	    var form_rgst_word = document.getElementById("form_rgst_word");
	    
	    function on_click_btn_iqry_word(event){
	    	var nWord		= document.getElementById("word").value;
	    	
	    	if(nWordNm == ""){
		    	alert("단어 명 입력 바랍니다.");
		    	return;
		    }
		    
			form_iqry_word.submit();
		    
	    }
	    
	    function on_click_btn_rgst_word(event){
	    	var nWord		= document.getElementById("word").value;
	    	var nWordNm 	= document.getElementById("word_nm").value;
	    	var nWordCmnt	= document.getElementById("word_cmnt").value;
	    	
		    if(nWord == "" || nWord == null){
		    	alert("단어 입력 바랍니다.");
		    	return;
		    }
	    	if(nWordNm == "" || nWordNm == null){
		    	alert("단어명 입력 바랍니다.");
		    	return;
		    }
		    
		    form_rgst_word.submit();
		    
	    }
	    </script>
		
		<jsp:include page="/resources/cmm/jsp/inBottomBodyScript.jsp"/>
	</body>
</html>