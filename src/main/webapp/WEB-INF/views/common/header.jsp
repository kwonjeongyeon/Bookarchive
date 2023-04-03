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
					<font size="30">�������ǽ� Ȩ������</font>
				</h1>
			</td>
		</tr>
	</table>

	<div class="header_wrap ">


		<div class="headertop">
			<div class="inner">
				<ul class="gnb" id="headerTop_gnb">
					<li id="#head_book_layer"><a href="#" title="��������">�����ܵ���</a>

						<div id="head_book_layer" class="header_layer_box"
							style="display: none;">
							<div class="category">
								<ul>
									<li><a href="#">IT/���ͳ�</a></li>
									<li><a href="#"><strong>����/�濵</strong></a></li>
									<li><a href="#">���б���</a></li>
									<li><a href="#">�ڱ���</a></li>
									<li><a href="#">�ڿ�����/����</a></li>
									<li><a href="#">����/�ι���</a></li>

								</ul>
							</div>

						</div></li>
				</ul>
			</div>

			<li id="#head_music_layer"><a href="#" title="����">����</a>
				<div id="head_music_layer" class="header_layer_box"
					style="display: none;">
					<div class="category">
						<ul>
							<li><a href="#">����</a></li>
							<li><a href="#">��</a></li>
							<li><a href="#">Ŭ����</a></li>
							<li><a href="#">��������</a></li>
							<li><a href="#">����</a></li>
							<li><a href="#">��Ÿ</a></li>
						</ul>
					</div>
				</div></li>
		</div>
		<ul class="util" id="headerTop_util">
			<li><a href="${contextPath}/member/loginForm.do" title="�α���">�α���</a></li>
			<li><a href="#" title="ȸ������">ȸ������</a></li>
			<li id="#head_myaccount_layer"><a href="#" title="����������"
				class="arr">����������</a>
				<div id="head_myaccount_layer" style="width: 100px; display: none;"
					class="hdr">
					<table border="0" cellspacing="4" cellpadding="3">
						<tbody>
							<tr>
								<td valign="top">
									<table>
										<tbody>
											<tr>
												<td><a href="#">���ǰ���</a></td>
											</tr>
											<tr>
												<td><a href="#">�ֹ�/�����ȸ</a></td>
											</tr>
											<tr>
												<td><a href="#">������</a></td>
											</tr>
											<tr>
												<td><a href="#">������</a></td>
											</tr>
											<tr>
												<td><a href="#">���Ǽ���</a></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div></li>
			<li><a href="#" title="������">������</a></li>
			<li id="headerBasketBtn"><a href="#" title="��ٱ���">��ٱ��� <span
					id="basketItemCount">(0)</span></a>
				<div id="head_layer_accunt_container"
					style="position: relative; z-index: 9999; margin-top: -5px;">
					<div id="headerBasketLayerWrap" style="display: none;">
						<div id="headerBasketLayer" class="nh_basket">
							<table width="243" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<td><img src="./��ī�̺�_files/nh_basket01.gif" width="243"
											height="7" style="visibility: hidden"></td>
									</tr>
									<tr>
										<td>
											<div id="headerBasketItems">
												<div style="text-align: center; vertical-align: baseline">
													<img src="./��ī�̺�_files/loading_on.gif" width="16"
														height="16">
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td><img src="./��ī�̺�_files/nh_basket01.gif" width="243"
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