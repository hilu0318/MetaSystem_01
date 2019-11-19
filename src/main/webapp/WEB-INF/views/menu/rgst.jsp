<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/resources/cmm/jsp/inHtmlHead.jsp"/>
<div class="container mar-top-30 word">
  <div class="row"><h2>단어등록</h2></div>
  <div class="row">

		<form id="form_iqry_word" class="form-inline" method="get" action="/meta/word">
			<div class="form-group">
				<input type="text" class="form-control" id="word_nm" name="word_nm" placeholder="단어명" value="f">
			</div>
			<button type="submit" class="btn btn-default" id="btn_iqry_word" onclick="on_click_btn_iqry_word(event)">
				조회
			</button>
			<div class="form-group">
				<input type="text" class="form-control" id="word" name="word" placeholder="결과" value="e" readonly>
			</div>
			<div hidden>
				<input type="text" id="word_seqno" name="word_seqno" value="d" hidden>
			</div>
		</form>

	</div>

	<div class="row">

		<form id="form_rgst_word" class="form-inline" method="post" action="/meta/word">
			<div class="form-group">
				<input type="text" class="form-control" id="word1" name="word1" placeholder="단어" value="c">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="word_nm1" name="word_nm1" placeholder="단어명" value="b">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="word_cmnt" name="word_cmnt" placeholder="단어설명" value="a">
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


<div class="container mar-top-30 term">
<div class="row"><h2>용어등록</h2></div>
  <div class="row">

		<form id="form_iqry_stndrd_term" class="form-inline" method="get" action="/meta/term">
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_nm" name="stndrd_term_nm" placeholder="단어명" value="4">
			</div>
			<button type="submit" class="btn btn-default" id="btn_iqry_stndrd_term" onclick="on_click_btn_iqry_stndrd_term(event)">
				조회
			</button>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term" name="stndrd_term" placeholder="결과" value="5" readonly>
			</div>
		</form>

	</div>

	<div class="row">

		<form id="form_rgst_stndrd_term" class="form-inline" method="post" action="/meta/term">
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term1" name="stndrd_term1" placeholder="용어" value="1">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_nm1" name="stndrd_term_nm1" placeholder="용어명" value="2">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_cmnt" name="stndrd_term_cmnt" placeholder="용어설명" value="3">
			</div>
			<div hidden>
				<input type="text" name="use_yn1" value="Y" hidden>
				<input type="text" name="del_yn1" value="N" hidden>
				<input type="text" name="rgst_user1" value="hilu0318" hidden>
			</div>
			<button type="button" class="btn btn-default" id="btn_rgst_stndrd_term" onclick="on_click_btn_rgst_stndrd_term(event)">
				등록
			</button>
		</form>

	</div>
</div>

<div hidden>
  <input type="text" id="req_service" name="req_service" value="" hidden>
</div>

<!-- 스크립트 시작 -->
<script type="text/javascript">
	var $word       = $('#word');
	var $word_nm    = $('#word_nm');
	var $word_seqno = $('#word_seqno');
	var $word1      = $('#word1');
	var $word_nm1   = $('#word_nm1');
	var $word_cmnt  = $('#word_cmnt');
	var $use_yn     = $('#use_yn');
	var $del_yn     = $('#del_yn');
	var $rgst_user  = $('#rgst_user');
	
	var $stndrd_term      = $('#stndrd_term');
	var $stndrd_term_nm   = $('#stndrd_term_nm');
	var $stndrd_term1     = $('#stndrd_term1');
	var $stndrd_term_nm1  = $('#stndrd_term_nm1');
	var $stndrd_term_cmnt = $('#stndrd_term_cmnt');
	var $use_yn1          = $('#use_yn1');
	var $del_yn1          = $('#del_yn1');
	var $rgst_user1       = $('#rgst_user1');
	
	var $btn_iqry_word        = $('#btn_iqry_word');
	var $btn_rgst_word        = $('#btn_rgst_word');
	var $btn_iqry_stndrd_term = $('#btn_iqry_stndrd_term');
	var $btn_rgst_stndrd_term = $('#btn_rgst_stndrd_term');
	
	var $form_iqry_word         = $('#form_iqry_word');
	var $form_rgst_word         = $('#form_rgst_word');
	var $form_iqry_stndrd_term  = $('#form_iqry_stndrd_term');
	var $form_rgst_stndrd_term  = $('#form_rgst_stndrd_term');
</script>
   
<script type="text/javascript">
	function on_click_btn_iqry_word(event){
		if(StringUtil.isEmpty($word_nm.val())){
			alert("$word_nm");
			return;
		}
		//$form_iqry_word.submit();
	}
	
	function on_click_btn_rgst_word(event){
		if(StringUtil.isEmpty($word1.val())){
			alert("$word1");
			return;
		}
		else if(StringUtil.isEmpty($word_nm1.val())){
			alert("$word_nm1");
			return;
		}
	  //$form_rgst_word.submit();
	}
	
	function on_click_btn_iqry_stndrd_term(event){
		if(StringUtil.isEmpty($stndrd_term_nm.val())){
			alert("$stndrd_term_nm");
			return;
		}
		//$form_iqry_stndrd_term.submit();
	}
	
	function on_click_btn_rgst_stndrd_term(event){
		if(StringUtil.isEmpty($stndrd_term1.val())){
			alert("$stndrd_term1");
			return;
		}
		else if(StringUtil.isEmpty($stndrd_term_nm1.val())){
			alert("$word_$stndrd_term_nm1nm1");
			return;
		}
		//$btn_rgst_stndrd_term.submit();
	}

</script>

<jsp:include page="/resources/cmm/jsp/inHtmlBottom.jsp"/>
		