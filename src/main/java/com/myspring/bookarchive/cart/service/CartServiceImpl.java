package com.myspring.bookarchive.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.bookarchive.cart.dao.CartDAO;
import com.myspring.bookarchive.cart.vo.CartVO;
import com.myspring.bookarchive.goods.vo.GoodsVO;

@Service("cartService")
@Transactional(propagation = Propagation.REQUIRED)
public class CartServiceImpl implements CartService {
	//장바구니 담기 --> 장바구니 테이블에는 해당 상품의 상품 번호만 저장 
	//장바구니 페이지에 상품 정보를 같이 표시하려면 장바구니 테이블에 저장된 상품 번호를 이용해 상품 정보를 따로 조회한 후 장바구니 페이지로 전달해서 표시
	
	@Autowired
	private CartDAO cartDAO;

	public Map<String, List> myCartList(CartVO cartVO) throws Exception {
		Map<String, List> cartMap = new HashMap<String, List>();
		
		//장바구니 페이지에 표시할 장바구니 정보를 조회
		List<CartVO> myCartList = cartDAO.selectCartList(cartVO);
		
		if (myCartList.size() == 0) { // 카트에 저장된 상품이없는 경우 null 반환
			return null;
		}
		
		//장바구니 페이지에 표시할 상품 정보 조회
		List<GoodsVO> myGoodsList = cartDAO.selectGoodsList(myCartList);
		
		//장바구니 정보와 상품 정보를 cartMap에 저장한 후 컨트롤러로 반환
		cartMap.put("myCartList", myCartList);
		cartMap.put("myGoodsList", myGoodsList);
		return cartMap;
	}

	
	//테이블에 추가하기 전에 동일한 상품 번호와 개수를 조회
	public boolean findCartGoods(CartVO cartVO) throws Exception {
		return cartDAO.selectCountInCart(cartVO);

	}

	
	//장바구니에 추가
	public void addGoodsInCart(CartVO cartVO) throws Exception {
		cartDAO.insertGoodsInCart(cartVO);
	}

	public boolean modifyCartQty(CartVO cartVO) throws Exception {
		boolean result = true;
		cartDAO.updateCartGoodsQty(cartVO);
		return result;
	}

	public void removeCartGoods(int cart_id) throws Exception {
		cartDAO.deleteCartGoods(cart_id);
	}

}
