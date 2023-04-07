<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>

<style type="text/css">
.header_wrap .head_link {
	display: flex;
	justify-content: space-between;
	position: relative;
	z-index: 9999;
	height: 38px;
	background-color: #33afe9;
	border-bottom: 1px solid #4496D9;
	box-sizing: border-box;
	border-bottom: 1px solid #4496D9;
}
</style>

<script type="text/javascript">
	var loopSearch = true;
	function keywordSearch() {
		if (loopSearch == false)
			return;
		var value = document.frmSearch.searchWord.value;
		$.ajax({
			type : "get",
			async : true, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/goods/keywordSearch.do",
			data : {
				keyword : value
			},
			success : function(data, textStatus) {
				var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다." + data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");

			}
		}); //end ajax	
	}

	function displayResult(jsonInfo) {
		var count = jsonInfo.keyword.length;
		if (count > 0) {
			var html = '';
			for ( var i in jsonInfo.keyword) {
				html += "<a href=\"javascript:select('" + jsonInfo.keyword[i]
						+ "')\">" + jsonInfo.keyword[i] + "</a><br/>";
			}
			var listView = document.getElementById("suggestList");
			listView.innerHTML = html;
			show('suggest');
		} else {
			hide('suggest');
		}
	}

	function select(selectedKeyword) {
		document.frmSearch.searchWord.value = selectedKeyword;
		loopSearch = false;
		hide('suggest');
	}

	function show(elementId) {
		var element = document.getElementById(elementId);
		if (element) {
			element.style.display = 'block';
		}
	}

	function hide(elementId) {
		var element = document.getElementById(elementId);
		if (element) {
			element.style.display = 'none';
		}
	}
</script>
</head>
<body>
	<div id="logo">
		<a href="${contextPath}/main/main.do"> <img width="240"
			height="60" alt="bookarchive"
			src="${contextPath}/resources/image/bookarchive.PNG">
		</a>
	</div>

	<div class="header_wrap ">


		<div id="head_link">
			<ul>
				<c:choose>
					<c:when test="${isLogOn==true and not empty memberInfo}">
					<!-- 로그인시 로그아웃을 표시 -->
						<li><a href="${contextPath}/member/logout.do">로그아웃</a></li>
						<li><a href="${contextPath}/mypage/myPageMain.do">마이페이지</a></li>
						<li><a href="${contextPath}/cart/myCartList.do">장바구니</a></li>
						<li><a href="#">주문배송</a></li>
					</c:when>
					<c:otherwise> <!-- 로그아웃시 로그인을 표시 -->
						<li><a href="${contextPath}/member/loginForm.do">로그인</a></li>
						<li><a href="${contextPath}/member/memberForm.do">회원가입</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="#">고객센터</a></li>
				<c:if test="${isLogOn==true and memberInfo.member_id =='admin'}">
				<!-- 관리자로 로그인시 로그인시 관리자를 표시 -->
					<li class="no_line"><a
						href="${contextPath}/admin/goods/adminGoodsMain.do">관리자</a></li>
				</c:if>

			</ul>
		</div>
		<br>
		<div id="search">
			<form name="frmSearch" action="${contextPath}/goods/searchGoods.do">
				<input name="searchWord" class="main_input" type="text"
					onKeyUp="keywordSearch()"> <input type="submit"
					name="search" class="btn1" value="검 색">
			</form>
		</div>
		<div id="suggest">
			<div id="suggestList"></div>
		</div>
	</div>
</body>
</html>