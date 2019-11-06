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
				<form class="form-inline" method="get" action="/meta/word">
					<div class="form-group">
						<input type="text" class="form-control" id="word_nm" name="word_nm" placeholder="단어명" value="${ rIqryMetaWordGet.word_nm }">
					</div>
					<button type="submit" class="btn btn-default">조회</button>
					<div class="form-group">
						<input type="text" class="form-control" id="word" name="word" placeholder="결과" value="${ rIqryMetaWordGet.word }" readonly>
						<input type="text" id="word_seqno" name="word_seqno" value="${ rIqryMetaWordGet.word_seqno }" hidden>
					</div>
				</form>
			</div>
		</div>

	    <div class="container mar-top-30">
			<div class="row">
				<form class="form-inline" method="post" action="/login">
					<div class="form-group">
						<input type="text" class="form-control" id="word" placeholder="단어" value="">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="word_nm" placeholder="단어명">
					</div>
					<button type="button" class="btn btn-default">등록</button>
				</form>
			</div>
		</div>
	
	
	
	    <!-- 스크립트 시작 -->
	
	    <script type="text/javascript">
	
	
	    </script>
		
		<jsp:include page="/resources/cmm/jsp/inBottomBodyScript.jsp"/>
	</body>
</html>