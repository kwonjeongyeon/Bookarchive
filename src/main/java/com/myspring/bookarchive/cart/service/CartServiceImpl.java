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
	//��ٱ��� ��� --> ��ٱ��� ���̺��� �ش� ��ǰ�� ��ǰ ��ȣ�� ���� 
	//��ٱ��� �������� ��ǰ ������ ���� ǥ���Ϸ��� ��ٱ��� ���̺� ����� ��ǰ ��ȣ�� �̿��� ��ǰ ������ ���� ��ȸ�� �� ��ٱ��� �������� �����ؼ� ǥ��
	
	@Autowired
	private CartDAO cartDAO;

	public Map<String, List> myCartList(CartVO cartVO) throws Exception {
		Map<String, List> cartMap = new HashMap<String, List>();
		
		//��ٱ��� �������� ǥ���� ��ٱ��� ������ ��ȸ
		List<CartVO> myCartList = cartDAO.selectCartList(cartVO);
		
		if (myCartList.size() == 0) { // īƮ�� ����� ��ǰ�̾��� ��� null ��ȯ
			return null;
		}
		
		//��ٱ��� �������� ǥ���� ��ǰ ���� ��ȸ
		List<GoodsVO> myGoodsList = cartDAO.selectGoodsList(myCartList);
		
		//��ٱ��� ������ ��ǰ ������ cartMap�� ������ �� ��Ʈ�ѷ��� ��ȯ
		cartMap.put("myCartList", myCartList);
		cartMap.put("myGoodsList", myGoodsList);
		return cartMap;
	}

	
	//���̺� �߰��ϱ� ���� ������ ��ǰ ��ȣ�� ������ ��ȸ
	public boolean findCartGoods(CartVO cartVO) throws Exception {
		return cartDAO.selectCountInCart(cartVO);

	}

	
	//��ٱ��Ͽ� �߰�
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
