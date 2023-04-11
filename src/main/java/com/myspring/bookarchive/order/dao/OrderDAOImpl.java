package com.myspring.bookarchive.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.bookarchive.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO { // 한 번에 한 개의 상품을 주문하든 여러 개의 상품을 주문하든 각 주문 상품의 주문 번호 동일하게 설정
	@Autowired
	private SqlSession sqlSession;

	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws DataAccessException {
		List<OrderVO> orderGoodsList = new ArrayList<OrderVO>();
		orderGoodsList = (ArrayList) sqlSession.selectList("mapper.order.selectMyOrderList", orderVO);
		return orderGoodsList;
	}

	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException {
		int order_id = selectOrderID(); // 각 orderVO에 설정할 주문번호를 가져옴

		for (int i = 0; i < myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO) myOrderList.get(i);
			orderVO.setOrder_id(order_id);
			sqlSession.insert("mapper.order.insertNewOrder", orderVO);
		} // 주문 목록에서 차례대로 orderVO를 가져와 주문 번호를 설정

	}

	public OrderVO findMyOrder(String order_id) throws DataAccessException {
		OrderVO orderVO = (OrderVO) sqlSession.selectOne("mapper.order.selectMyOrder", order_id);
		return orderVO;
	} // 장바구니에서 주문한 경우 해당 상품을 장바구니에서 삭제

	public void removeGoodsFromCart(OrderVO orderVO) throws DataAccessException {
		sqlSession.delete("mapper.order.deleteGoodsFromCart", orderVO);
	}

	public void removeGoodsFromCart(List<OrderVO> myOrderList) throws DataAccessException {
		for (int i = 0; i < myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO) myOrderList.get(i);
			sqlSession.delete("mapper.order.deleteGoodsFromCart", orderVO);
		}
	}

	private int selectOrderID() throws DataAccessException {
		return sqlSession.selectOne("mapper.order.selectOrderID");
		// 테이블에 저장할 주문 번호를 가져옴
	}
}
