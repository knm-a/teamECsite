package jp.co.internous.hope.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.hope.model.domain.MstDestination;
import jp.co.internous.hope.model.mapper.MstDestinationMapper;
import jp.co.internous.hope.model.mapper.TblCartMapper;
import jp.co.internous.hope.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.hope.model.session.LoginSession;

@Controller
@RequestMapping("/hope/settlement")
public class SettlementController {
	
	@Autowired
	LoginSession loginSession;
	
	@Autowired
	MstDestinationMapper distinationMapper;
	
	@Autowired
	TblCartMapper cartMapper;
	
	@Autowired
	TblPurchaseHistoryMapper purchaseHistoryMapper;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		//ユーザーIDを取得
		int userId = loginSession.getUserId();
		
		//userIdと一致する宛先情報を取得
		List<MstDestination> destinations = distinationMapper.findByUserId(userId);
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("destinations", destinations);
		return "settlement";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/complete")
	@ResponseBody
	public boolean complete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		//DBの購入履歴情報テーブルに決済情報を登録
		int userId = loginSession.getUserId();
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("destinationId", id);
		parameter.put("userId", userId);
		int insertCount = purchaseHistoryMapper.insert(parameter);
		
		//ユーザーに紐づいてるDBのカート情報を削除
		int deleteCount = 0;
		if (insertCount > 0) {
			deleteCount = cartMapper.deleteByUserId(userId);
		}
		return deleteCount == insertCount;
	}
}