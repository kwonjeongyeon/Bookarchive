package com.myspring.bookarchive.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.bookarchive.common.base.BaseController;
import com.myspring.bookarchive.goods.service.GoodsService;
import com.myspring.bookarchive.goods.vo.GoodsVO;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainController extends BaseController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/main/main.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session;
		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);

		session = request.getSession();
		session.setAttribute("side_menu", "user");
		// 속성 side_menu의 값에 따라 화면 왼쪽에 표시되는 메뉴 항목을 다르게 한다.
		Map<String, List<GoodsVO>> goodsMap = goodsService.listGoods();
		// 베스트셀러, 신간, 스테디셀러의 정보를 조회해 Map에 저장
		mav.addObject("goodsMap", goodsMap);
		// 메인 페이지로 상품 정보를 전달
		return mav;
	}

}
