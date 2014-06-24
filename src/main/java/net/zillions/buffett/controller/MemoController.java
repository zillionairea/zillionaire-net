package net.zillions.buffett.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.zillions.buffett.client.MapperFactory;
import net.zillions.buffett.client.TbMemoMapper;
import net.zillions.buffett.model.TbMemo;
import net.zillions.buffett.model.TbMemoExample;
import net.zillions.buffett.model.TbMemoExample.Criteria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 */
@Controller
public class MemoController {

	@RequestMapping("/memo/")
	public ModelAndView init(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("memo/main");

		TbMemoExample tbMemoExample = new TbMemoExample();
		tbMemoExample.setOrderByClause("created desc");

		Map<String, List<TbMemo>> memos = new LinkedHashMap<>();

		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");

		for (TbMemo memo : MapperFactory.getMapper(TbMemoMapper.class).selectByEx(tbMemoExample)) {

			String dateString = null;
			synchronized (df) {
				dateString = df.format(memo.getCreated());
			}

			List<TbMemo> memoContents = memos.get(dateString);
			if (memoContents == null) {
				memoContents = new ArrayList<>();
				memos.put(dateString, memoContents);
			}
			memoContents.add(memo);
		}

		mav.addObject("memos", memos);
		mav.addObject("calenderMap", getCalenderMap());

		return mav;
	}

	@RequestMapping("/memo/search")
	public ModelAndView search(HttpServletRequest request) {

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

		if (year == null || isDigit(year) == false) {
			return new ModelAndView("redirect:/app/memo/");
		}

		Date begin = getBeginDate(year, month, day);
		Date end = getEndDate(year, month, day);

		ModelAndView mav = new ModelAndView("memo/main");
		TbMemoExample tbMemoExample = new TbMemoExample();

		Criteria criteria = tbMemoExample.createCriteria();
		criteria.andCreatedBetween(begin, end);

		tbMemoExample.setOrderByClause("created desc");

		Map<String, List<TbMemo>> memos = new LinkedHashMap<>();

		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");

		for (TbMemo memo : MapperFactory.getMapper(TbMemoMapper.class).selectByEx(tbMemoExample)) {

			String dateString = null;
			synchronized (df) {
				dateString = df.format(memo.getCreated());
			}

			List<TbMemo> memoContents = memos.get(dateString);
			if (memoContents == null) {
				memoContents = new ArrayList<>();
				memos.put(dateString, memoContents);
			}
			memoContents.add(memo);
		}

		mav.addObject("memos", memos);
		mav.addObject("calenderMap", getCalenderMap());

		return mav;
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private Date getBeginDate(String year, String month, String day) {

		Calendar cale = Calendar.getInstance();
		cale.setTimeInMillis(0);
		cale.set(Calendar.HOUR, 0);

		cale.set(Calendar.YEAR, Integer.parseInt(year));

		if (month != null && isDigit(month)) {
			cale.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		} else {
			cale.set(Calendar.MONTH, 0);
		}

		if (day != null && isDigit(day)) {
			cale.set(Calendar.DATE, Integer.parseInt(day));
		} else {
			cale.set(Calendar.DATE, 1);
		}

		return cale.getTime();
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private Date getEndDate(String year, String month, String day) {

		Calendar cale = Calendar.getInstance();
		cale.setTimeInMillis(0);
		cale.set(Calendar.HOUR, 0);

		cale.set(Calendar.YEAR, Integer.parseInt(year));

		if (month != null && isDigit(month)) {
			cale.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		} else {
			cale.set(Calendar.MONTH, 11);
		}

		if (day != null && isDigit(day)) {
			cale.set(Calendar.DATE, Integer.parseInt(day) + 1);
		} else {
			cale.add(Calendar.MONTH, 1);
		}

		cale.add(Calendar.MILLISECOND, -1);

		return cale.getTime();
	}

	@RequestMapping("/memo/add")
	public String add(HttpServletRequest request) {

		String content = request.getParameter("content");

		TbMemo memo = new TbMemo();
		memo.setMemoContent(content);

		MapperFactory.getMapper(TbMemoMapper.class).insertSelective(memo);

		return "redirect:/app/memo/";
	}

	@RequestMapping("/memo/delete")
	public String delete(HttpServletRequest request) {

		String memoIdValue = request.getParameter("memoId");
		if (memoIdValue == null) {
			return "redirect:/app/memo/";
		}

		if (isDigit(memoIdValue) == false) {
			return "redirect:/app/memo/";
		}

		int memoId = Integer.parseInt(memoIdValue);

		MapperFactory.getMapper(TbMemoMapper.class).deleteByPk(memoId);

		return "redirect:/app/memo/";
	}

	/**
	 * 
	 * @return
	 */
	private Map<String, Map<String, List<String>>> getCalenderMap() {

		Map<String, Map<String, List<String>>> calenderMap = new LinkedHashMap<>();

		Calendar cale = Calendar.getInstance();

		TbMemoExample tbMemoExample = new TbMemoExample();
		tbMemoExample.setOrderByClause("created desc");

		for (TbMemo memo : MapperFactory.getMapper(TbMemoMapper.class).selectByEx(tbMemoExample)) {

			cale.setTime(memo.getCreated());
			String year = String.valueOf(cale.get(Calendar.YEAR));
			String month = String.valueOf(cale.get(Calendar.MONTH) + 1);
			String day = String.valueOf(cale.get(Calendar.DAY_OF_MONTH));

			Map<String, List<String>> calenderMapMonth = calenderMap.get(year);
			if (calenderMapMonth == null) {
				calenderMapMonth = new LinkedHashMap<>();
				calenderMap.put(year, calenderMapMonth);
			}
			List<String> days = calenderMapMonth.get(month);
			if (days == null) {
				days = new ArrayList<>();
				calenderMapMonth.put(month, days);
			}
			if (calenderMapMonth.get(month).contains(day) == false) {
				calenderMapMonth.get(month).add(day);
			}
		}

		return calenderMap;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	private boolean isDigit(String value) {

		for (char ch : value.toCharArray()) {
			if (Character.isDigit(ch) == false) {
				return false;
			}
		}

		return true;
	}

}
