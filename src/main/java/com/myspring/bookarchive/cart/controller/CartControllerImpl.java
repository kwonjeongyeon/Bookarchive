package com.myspring.bookarchive.cart.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.bookarchive.cart.service.CartService;
import com.myspring.bookarchive.cart.vo.CartVO;
import com.myspring.bookarchive.common.base.BaseController;
import com.myspring.bookarchive.goods.vo.GoodsVO;
import com.myspring.bookarchive.member.vo.MemberVO;

@Controller("cartController")
@RequestMapping(value = "/cart")
public class CartControllerImpl extends BaseController implements CartController {
	// 조회한 장바구니 목록과 상품 정보 목록을 Map에 저장, 장바구니 목록을 표시하는 페이지에서 상품을 주문할 경우에 대비해 상품 정보를 미리
	// 세션에 바인딩

	@Autowired
	private CartService cartService;
	@Autowired
	private CartVO cartVO;
	@Autowired
	private MemberVO memberVO;

	@RequestMapping(value = "/myCartList.do", method = RequestMethod.GET)
	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		String member_id = memberVO.getMember_id();
		cartVO.setMember_id(member_id);

		// 장바구니 페이지에 표시할 상품 정보를 조회
		Map<String, List> cartMap = cartService.myCartList(cartVO);

		session.setAttribute("cartMap", cartMap);// 장바구니 목록 화면에서 상품 주문 시 사용하기 위해서 장바구니 목록을 세션에 저장한다.
		// mav.addObject("cartMap", cartMap);
		return mav;
	}

	@RequestMapping(value = "/addGoodsInCart.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String addGoodsInCart(@RequestParam("goods_id") int goods_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception { // 전송된 상품 번호를 받음
		// 브라우저에서 전송된 상품 번호를 이용해 상품이 장바구니 테이블에 이미 추가된 상품인지 확인, 장바구니에 없으면 상품 번호를 장바구니
		// 테이블에 추가
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("memberInfo");
		String member_id = memberVO.getMember_id();

		cartVO.setMember_id(member_id);
		// 카트 등록전에 이미 등록된 제품인지 판별한다.
		cartVO.setGoods_id(goods_id);

		// 상품 번호가 장바구니 테이블에 있는지 조회
		boolean isAreadyExisted = cartService.findCartGoods(cartVO);
		System.out.println("isAreadyExisted: " + isAreadyExisted);

		// 상품 번호가 이미 장바구니 테이블에 있으면 이미 추가되었다는 메시지를 브라우저로 전송, 없으면 장바구니 테이블에 추가
		if (isAreadyExisted == true) {
			return "already_existed";
		} else {
			cartService.addGoodsInCart(cartVO);
			return "add_success";
		}
	}

	@RequestMapping(value = "/modifyCartQty.do", method = RequestMethod.POST)
	public @ResponseBody String modifyCartQty(@RequestParam("goods_id") int goods_id,
			@RequestParam("cart_goods_qty") int cart_goods_qty, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO) session.getAttribute("memberInfo");
		String member_id = memberVO.getMember_id();
		cartVO.setGoods_id(goods_id);
		cartVO.setMember_id(member_id);
		cartVO.setCart_goods_qty(cart_goods_qty);
		boolean result = cartService.modifyCartQty(cartVO);

		if (result == true) {
			return "modify_success";
		} else {
			return "modify_failed";
		}

	}

	@RequestMapping(value = "/removeCartGoods.do", method = RequestMethod.POST)
	public ModelAndView removeCartGoods(@RequestParam("cart_id") int cart_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		cartService.removeCartGoods(cart_id);
		mav.setViewName("redirect:/cart/myCartList.do");
		return mav;
	}
}
