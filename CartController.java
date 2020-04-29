package jp.co.internous.hope.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.hope.model.form.CartForm;
import jp.co.internous.hope.model.domain.TblCart;
import jp.co.internous.hope.model.domain.dto.CartDto;
import jp.co.internous.hope.model.mapper.TblCartMapper;
import jp.co.internous.hope.model.session.LoginSession;

@Controller
@RequestMapping("/hope/cart")
public class CartController {

	@Autowired
	private LoginSession loginSession;

	@Autowired
	private TblCartMapper cartMapper;

	private Gson gson = new Gson();

	@RequestMapping("/")
	public String index(Model m) {
		// ユーザーID,仮ユーザーIDを取得する
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

		// カート情報を取得する
		List<CartDto> carts = cartMapper.findByUserId(userId);
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("carts", carts);
		return "cart";

	}

	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		// ユーザーIDを取得する
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

		f.setUserId(userId);

		// カートテーブルに挿入,更新する
		TblCart cart = new TblCart(f);
		int result = 0;
		if (cartMapper.findCountByUserIdAndProductId(userId, f.getProductId()) > 0) {
			result = cartMapper.update(cart);
		} else {
			result = cartMapper.insert(cart);
		}
		if (result > 0) {
			List<CartDto> carts = cartMapper.findByUserId(userId);
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("carts", carts);
		}
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		// チェックボックスで選択されたカート情報を削除
		int result = 0;
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		for (String id : checkedIds) {
			result += cartMapper.deleteById(Integer.parseInt(id));
		}
		return result > 0;
	}
}