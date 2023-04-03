<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>header</title>
</head>
<body>
	<table border="0" width="100%">
		<tr>
			<td><a href="${contextPath}/main.do"> <img
					src="${contextPath}/resources/image/racoon.jpg" />
			</a></td>
			<td>
				<h1>
					<font size="30">스프링실습 홈페이지</font>
				</h1>
			</td>
		</tr>
	</table>

	<div class="header_wrap ">


		<div class="headertop">
			<div class="inner">
				<ul class="gnb" id="headerTop_gnb">
					<li id="#head_book_layer"><a href="#" title="국내도서">국내외도서</a>

						<div id="head_book_layer" class="header_layer_box"
							style="display: none;">
							<div class="category">
								<ul>
									<li><a href="#">IT/인터넷</a></li>
									<li><a href="#"><strong>경제/경영</strong></a></li>
									<li><a href="#">대학교재</a></li>
									<li><a href="#">자기계발</a></li>
									<li><a href="#">자연과학/공학</a></li>
									<li><a href="#">역사/인문학</a></li>

								</ul>
							</div>

						</div></li>
				</ul>
			</div>

			<li id="#head_music_layer"><a href="#" title="음반">음반</a>
				<div id="head_music_layer" class="header_layer_box"
					style="display: none;">
					<div class="category">
						<ul>
							<li><a href="#">가요</a></li>
							<li><a href="#">록</a></li>
							<li><a href="#">클래식</a></li>
							<li><a href="#">뉴에이지</a></li>
							<li><a href="#">재즈</a></li>
							<li><a href="#">기타</a></li>
						</ul>
					</div>
				</div></li>
		</div>
		<ul class="util" id="headerTop_util">
			<li><a href="${contextPath}/member/loginForm.do" title="로그인">로그인</a></li>
			<li><a href="#" title="회원가입">회원가입</a></li>
			<li id="#head_myaccount_layer"><a href="#" title="마이페이지"
				class="arr">마이페이지</a>
				<div id="head_myaccount_layer" style="width: 100px; display: none;"
					class="hdr">
					<table border="0" cellspacing="4" cellpadding="3">
						<tbody>
							<tr>
								<td valign="top">
									<table>
										<tbody>
											<tr>
												<td><a href="#">나의계정</a></td>
											</tr>
											<tr>
												<td><a href="#">주문/배송조회</a></td>
											</tr>
											<tr>
												<td><a href="#">보관함</a></td>
											</tr>
											<tr>
												<td><a href="#">구매함</a></td>
											</tr>
											<tr>
												<td><a href="#">나의서재</a></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div></li>
			<li><a href="#" title="고객센터">고객센터</a></li>
			<li id="headerBasketBtn"><a href="#" title="장바구니">장바구니 <span
					id="basketItemCount">(0)</span></a>
				<div id="head_layer_accunt_container"
					style="position: relative; z-index: 9999; margin-top: -5px;">
					<div id="headerBasketLayerWrap" style="display: none;">
						<div id="headerBasketLayer" class="nh_basket">
							<table width="243" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<td><img src="./북카이브_files/nh_basket01.gif" width="243"
											height="7" style="visibility: hidden"></td>
									</tr>
									<tr>
										<td>
											<div id="headerBasketItems">
												<div style="text-align: center; vertical-align: baseline">
													<img src="./북카이브_files/loading_on.gif" width="16"
														height="16">
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td><img src="./북카이브_files/nh_basket01.gif" width="243"
											height="7" style="visibility: hidden"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div></li>
		</ul>
	</div>
</body>
</html>