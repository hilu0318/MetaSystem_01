<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/resources/cmm/jsp/inHtmlHead.jsp"/>
<div class="container mar-top-30 word">
  <div class="row"><h2>단어등록</h2></div>
  <div class="row">

		<form id="form_iqry_word" class="form-inline" method="get" action="/rgst/word">
			<div class="form-group<c:if test="${ error.iqry_word == true }"> has-error</c:if>">
				<input type="text" class="form-control" id="word_nm" name="word_nm" placeholder="단어명" value="${ rIqryMetaWord.word_nm }">
			</div>
			<button type="button" class="btn btn-default" id="btn_iqry_word" onclick="on_click_btn_iqry_word(event)">
				조회
			</button>
			<div class="form-group">
				<input type="text" class="form-control" id="word" name="word" placeholder="결과" value="${ rIqryMetaWord.word }" readonly>
			</div>
			<div hidden>
				
			</div>
		</form>

	</div>

	<div class="row">

		<form id="form_rgst_word" class="form-inline" method="post" action="/rgst/word">
			<div class="form-group">
				<input type="text" class="form-control" id="word1" name="word1" placeholder="단어" value="${ rRgstMetaWordPost.word }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="word_nm1" name="word_nm1" placeholder="단어명" value="${ rRgstMetaWordPost.word_nm }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="word_cmnt" name="word_cmnt" placeholder="단어설명" value="${ rRgstMetaWordPost.word_cmnt }">
			</div>
			<div hidden>
				<input type="text" name="use_yn" value="<c:choose><c:when test="${ rRgstMetaWordPost.use_yn == null }">Y</c:when><c:otherwise>${ rRgstMetaWordPost.use_yn }</c:otherwise></c:choose>" hidden>
				<input type="text" name="del_yn" value="<c:choose><c:when test="${ rRgstMetaWordPost.del_yn == null }">Y</c:when><c:otherwise>${ rRgstMetaWordPost.del_yn }</c:otherwise></c:choose>" hidden>
				<input type="text" name="rgst_user" value="<c:choose><c:when test="${ rRgstMetaWordPost.rgst_user == null }">hilu0318</c:when><c:otherwise>${ rRgstMetaWordPost.rgst_user }</c:otherwise></c:choose>" hidden>
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

		<form id="form_iqry_stndrd_term" class="form-inline" method="get" action="/rgst/term">
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_nm" name="stndrd_term_nm" placeholder="단어명" value="">
			</div>
			<button type="button" class="btn btn-default" id="btn_iqry_stndrd_term" onclick="on_click_btn_iqry_stndrd_term(event)">
				조회
			</button>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term" name="stndrd_term" placeholder="결과" value="" readonly>
			</div>
		</form>

	</div>

	<div class="row">

		<form id="form_rgst_stndrd_term" class="form-inline" method="post" action="/rgst/term">
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term1" name="stndrd_term1" placeholder="용어" value="">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_nm1" name="stndrd_term_nm1" placeholder="용어명" value="">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="stndrd_term_cmnt" name="stndrd_term_cmnt" placeholder="용어설명" value="">
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

<div id="result" hidden>
  <input type="text" id="service_name"	name="service_name" value="${ service_name }" 	hidden>
  <input type="text" id="error_yn" 		name="error_yn" 	value="${ error.yn }" 		hidden>
  <input type="text" id="error_type" 	name="error_type" 	value="${ error.type }" 	hidden>
  <input type="text" id="error_msg" 	name="error_msg" 	value="${ error.msg }" 		hidden>
</div>

<!-- 스크립트 시작 -->
<script type="text/javascript">
	
	//단어조회 서비스 
	function on_click_btn_iqry_word(event){
		if(StringUtil.isEmpty($('#word_nm').val())){
			
			return;
		}
		
		$('#word').val('');
		$('#form_iqry_word').submit();
	}
	
	function on_click_btn_rgst_word(event){
		if(StringUtil.isEmpty($('#word1').val())){
			alert("$word1");
			return;
		}
		else if(StringUtil.isEmpty($('#word_nm1').val())){
			alert("$word_nm1");
			return;
		}
	  $('#form_rgst_word').submit();
	}
	
	function on_click_btn_iqry_stndrd_term(event){
		if(StringUtil.isEmpty($('#stndrd_term_nm').val())){
			alert("$stndrd_term_nm");
			return;
		}
		$('#form_iqry_stndrd_term').submit();
	}
	
	function on_click_btn_rgst_stndrd_term(event){
		if(StringUtil.isEmpty($('#stndrd_term1').val())){
			alert("$stndrd_term1");
			return;
		}
		else if(StringUtil.isEmpty($('#stndrd_term_nm1').val())){
			alert("$word_$stndrd_term_nm1nm1");
			return;
		}
		$('#form_rgst_stndrd_term').submit();
	}
	

</script>

<script type="text/javascript" id="service_complete">
var service_name 	= $('#service_name').val();
var error_yn		= $('#error_yn').val();
var error_type		= $('#error_type').val();
var error_msg		= $('#error_msg').val();

if(error_yn == "Y"){
	alert(error_msg);
}else{
	if(service_name == "rIqryMetaWord"){
		
	}
	else if(service_name == "rRgstMetaWordPost"){
		alert("정상 등록되었습니다.");
	}	
}

</script>

<jsp:include page="/resources/cmm/jsp/inHtmlBottom.jsp"/>
		