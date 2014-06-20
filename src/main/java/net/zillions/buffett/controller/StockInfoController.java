package net.zillions.buffett.controller;

import java.util.ArrayList;
import java.util.List;

import net.zillions.buffett.model.Industory;
import net.zillions.buffett.model.Stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StockInfoController {

	private static List<Industory> industories = new ArrayList<>();
	
	static {
		Industory industory = null;
		
		industory = new Industory("001", "経済指標");
		industory.addStock(new Stock("C998407_O", "日経平均"));
		industory.addStock(new Stock("C5040469_O", "日経先物"));
		industory.addStock(new Stock("CCUS_DAUFUTURE", "ダウ先物"));
		industory.addStock(new Stock("CCUS_USDYEN", "ドル円"));
		industories.add(industory);
		
		industory = new Industory("002", "ＡＤＲ主要銘柄");
		industory.addStock(new Stock("C8306_T", "ＭＵＦＧ"));
		industory.addStock(new Stock("C8316_T", "三井住友"));
		industory.addStock(new Stock("C7203_T", "トヨタ"));
		industory.addStock(new Stock("C7261_T", "マツダ"));
		industory.addStock(new Stock("C7201_T", "日産"));
		industory.addStock(new Stock("C6752_T", "パナソニック"));
		industory.addStock(new Stock("C9984_T", "ソフトバンク"));
		industory.addStock(new Stock("C4755_T", "楽天"));
		industory.addStock(new Stock("C9983_T", "ファストリテ"));
		industory.addStock(new Stock("C6301_T", "コマツ"));
		industory.addStock(new Stock("C2503_T", "キリン"));
		industory.addStock(new Stock("C4502_T", "武田薬品"));
		industory.addStock(new Stock("C6758_T", "ソニー"));
		industory.addStock(new Stock("C6753_T", "シャープ"));
		industory.addStock(new Stock("C7751_T", "キヤノン"));
		industory.addStock(new Stock("C6594_T", "日本電産"));
		industory.addStock(new Stock("C6501_T", "日立"));
		industory.addStock(new Stock("C6971_T", "京セラ"));
		industory.addStock(new Stock("C4901_T", "富士フィルム"));
		industory.addStock(new Stock("C6857_T", "アドバンテスト"));
		industory.addStock(new Stock("C8031_T", "三井物産"));
		industory.addStock(new Stock("C8604_T", "野村HLD"));
		industory.addStock(new Stock("C8601_T", "大和証券"));
		industory.addStock(new Stock("C8411_T", "みずほFG"));
		industory.addStock(new Stock("C8591_T", "オリックス"));
		industory.addStock(new Stock("C9432_T", "ＮＴＴ"));
		industory.addStock(new Stock("C9437_T", "ドコモ"));
		industory.addStock(new Stock("C3774_T", "ＩＩＪ"));
		industory.addStock(new Stock("C7267_T", "ホンダ"));
		industory.addStock(new Stock("C6326_T", "クボタ"));
		industory.addStock(new Stock("C6586_T", "マキタ"));
		industory.addStock(new Stock("C3591_T", "ワコール"));
		industory.addStock(new Stock("C9766_T", "コナミ"));
		industory.addStock(new Stock("C7974_T", "任天堂"));
		industory.addStock(new Stock("C6460_T", "セガサミー"));
		industories.add(industory);
	}

	@RequestMapping("/")
	public ModelAndView init() {

		ModelAndView mav = new ModelAndView("info/main");
		mav.addObject("industories", industories);

		return mav;
	}
}
