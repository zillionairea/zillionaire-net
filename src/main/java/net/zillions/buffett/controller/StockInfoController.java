package net.zillions.buffett.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.zillions.buffett.client.MapperFactory;
import net.zillions.buffett.client.TbIndustryMapper;
import net.zillions.buffett.client.TbStockMapper;
import net.zillions.buffett.model.TbIndustry;
import net.zillions.buffett.model.TbIndustryExample;
import net.zillions.buffett.model.TbStock;
import net.zillions.buffett.model.TbStockExample;
import net.zillions.buffett.model.TbStockExample.Criteria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StockInfoController {

	@RequestMapping("/info/")
	public ModelAndView init() {

		TbIndustryMapper tbIndustryMapper = MapperFactory.getMapper(TbIndustryMapper.class);
		TbIndustryExample tbIndustryExample = new TbIndustryExample();
		tbIndustryExample.setOrderByClause("industry_code asc");
		List<TbIndustry> industries = tbIndustryMapper.selectByEx(tbIndustryExample);

		ModelAndView mav = new ModelAndView("info/main");
		mav.addObject("industries", industries);

		TbStockMapper tbStockMapper = MapperFactory.getMapper(TbStockMapper.class);

		Map<String, List<TbStock>> stockList = new HashMap<>();
		for (TbIndustry industry : industries) {

			String industryCode = industry.getIndustryCode();

			TbStockExample tbStockExample = new TbStockExample();
			Criteria criteria = tbStockExample.createCriteria();
			criteria.andIndustryCodeEqualTo(industryCode);
			tbStockExample.setOrderByClause("stock_code asc");
			List<TbStock> stocks = tbStockMapper.selectByEx(tbStockExample);
			stockList.put(industryCode, stocks);
			
		}
		mav.addObject("stockList", stockList);


		return mav;
	}
}
