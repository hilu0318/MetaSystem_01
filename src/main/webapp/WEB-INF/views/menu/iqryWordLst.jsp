<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/resources/cmm/jsp/inHtmlHead.jsp"/>

<div class="container mar-top-30">
	<div class="row">

		<form id="form_iqry_word_lst" class="form-inline" method="get" action="/iqry/wordLst">
			<div class="form-group col-xs-5 col-sm-5 col-md-4 col-lg-4">
   				<input type="text" class="form-control" id="word_nm" name="word_nm" placeholder="단어명" value="">
   			</div>
   			<div class="form-group col-xs-5 col-sm-5 col-md-4 col-lg-4">
   				<input type="text" class="form-control" id="word" name="word" placeholder="단어" value="">
   			</div>
			<button type="button" class="btn btn-default" id="btn_iqry_word_lst" onclick="on_click_btn_iqry_word_lst(event)">
				조회
			</button>
			<button type="button" class="btn btn-default" id="btn_next_iqry_word_lst" >
				Next
			</button>
			<div hidden>
				<input type="text" name="next_ord" 	id="next_ord"	value="" 	hidden>
				<input type="text" name="next_page" id="next_page"	value="" 	hidden>
				<input type="text" name="row_size" 	id="row_size" 	value="25" 	hidden>
				<input type="text" name="service"	id="service" 	value="" 	hidden>
			</div>
		</form>
		
		<table class="table table-hover" id="table_iqry_word_lst">
			<thead>
				<tr>
					<th class="no" 			>No</th>
					<th class="word" 		>단어</th>
					<th class="word_nm" 	>단어명</th>
					<th class="word_cmnt"	>단어설명</th>
					<th class="use_yn"		>사용여부</th>
					<th class="del_yn"		>삭제여부</th>
					<th class="rgst_user"	>등록사용자</th>
				</tr>
			</thead>
			
			<tbody>
			
			<c:forEach items="${ rIqryWordLstGet.iqryLstWord }" var="list">
				<tr <c:if test="${ 1 == 2 }">hidden</c:if>>
					<th class="no" 			>${ list.no }</th>
					<th class="word" 		>${ list.word }</th>
					<th class="word_nm" 	>${ list.word_nm }</th>
					<th class="word_cmnt"	>${ list.word_cmnt }</th>
					<th class="use_yn"		>${ list.use_yn }</th>
					<th class="del_yn"		>${ list.del_yn }</th>
					<th class="rgst_user"	>${ list.rgst_user }</th>
				</tr>
			</c:forEach>
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="7">
						<nav class="text-center">
							<ul class="pagination">
								
								<li <c:if test="${ pageDto.prev_yn == N }">class="disabled"</c:if>>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<c:forEach var="i" begin="${ 1 }" end="${ 5 }">
								<li class="page_li<c:if test="${ i == pageDto.min_page }"> active</c:if>" onclick="on_click_paging(event)"><a href="#" onclick="">${ i }</a></li>
								</c:forEach>
								<li <c:if test="${ pageDto.next_yn == N }">class="disabled"</c:if>>
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
								
							</ul>
						</nav>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

<div id="result" hidden>
  <input type="text" id="service_name" 	name="service_name" value="${ service_name }" 	hidden>
  <input type="text" id="error_yn" 		name="error_yn" 	value="${ error.yn }" 		hidden>
  <input type="text" id="error_type" 	name="error_type" 	value="${ error.type }" 	hidden>
  <input type="text" id="error_msg" 	name="error_msg" 	value="${ error.msg }" 		hidden>
</div>

<!-- 스크립트 시작 -->

<script type="text/javascript">

function on_click_btn_iqry_word_lst(event){
	
	$('#service').val("Y");
	$('#form_iqry_word_lst').submit();
}

function on_click_paging(event){
    var nPageNo = event.currentTarget.children[0].innerHTML;
    //alert(nPageNo);
    $('li.page_li').removeClass("active");
    $(event.currentTarget).addClass("active");
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
	if(service_name == "rIqryWordLstGet"){
		var nnn = ${rIqryWordLstGet.iqryLstWord};
	}	
}

</script>

<jsp:include page="/resources/cmm/jsp/inHtmlBottom.jsp"/>
		