<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/resources/cmm/jsp/inHtmlHead.jsp"/>

<div class="container mar-top-30">
	<div class="row">

		<form id="form_iqry_term_lst" class="form-inline" method="post" action="/">
			<div class="form-group col-xs-5 col-sm-5 col-md-4 col-lg-4">
   				<input type="text" class="form-control" id="stndrd_term_nm" name="stndrd_term_nm" placeholder="표준용어명" value="">
   			</div>
   			<div class="form-group col-xs-5 col-sm-5 col-md-4 col-lg-4">
   				<input type="text" class="form-control" id="stndrd_term" name="stndrd_term" placeholder="표준용어" value="">
   			</div>
			<button type="button" class="btn btn-default" id="btn_iqry_term_lst" onclick="on_click_btn_iqry_term_lst(event)">
				조회
			</button>
			<div hidden>
				<input type="text" name="next_ord" id="" hidden>
			</div>
		</form>
		<table class="table table-hover" id="table_iqry_term_lst">
			<thead>
				<tr>
					<th id="no">No</th>
					<th id="name">STNDRD_TERM</th>
					<th id="age">STNDRD_TERM_NM</th>
					<th id="age">STNDRD_TERM_CMNT</th>
				</tr>
			</thead>
			
			<tbody>
				
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="4">
						<nav class="text-center">
							<ul class="pagination">
								
								<li <c:if test="${ 1 == 1 }">class="disabled"</c:if>>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<c:forEach var="i" begin="${ 1 }" end="${ 5 }">
								<li <c:if test="${ i == 1 }">class="active"</c:if>><a href="#">${ i }</a></li>
								</c:forEach>
								<li <c:if test="${ 1 == 2 }">class="disabled"</c:if>>
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

<div hidden>
  <input type="text" id="req_service" name="req_service" value="" hidden>
</div>

<!-- 스크립트 시작 -->
<script type="text/javascript">
	var $stndrd_term_nm       	= $('#stndrd_term_nm');
	var $stndrd_term 			= $('#stndrd_term');
	var $next_ord 				= $('#next_ord');
	
	var $table_iqry_term_lst	= $('#table_iqry_term_lst');
	
	var $btn_iqry_term_lst 		= $('#btn_iqry_term_lst');
	
	var $form_iqry_term_lst		= $('#form_iqry_term_lst');
</script>
   
<script type="text/javascript">

	function on_click_btn_iqry_term_lst(event){
		
		$form_iqry_term_lst.submit();
	}

</script>

<jsp:include page="/resources/cmm/jsp/inHtmlBottom.jsp"/>
		