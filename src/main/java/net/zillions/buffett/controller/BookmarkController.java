package net.zillions.buffett.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.zillions.buffett.BuffettUtils;
import net.zillions.buffett.client.TbBookmarkMapper;
import net.zillions.buffett.client.TbLabelBookmarkMapper;
import net.zillions.buffett.client.TbLabelMapper;
import net.zillions.buffett.form.BookmarkForm;
import net.zillions.buffett.model.TbBookmark;
import net.zillions.buffett.model.TbBookmarkExample;
import net.zillions.buffett.model.TbLabel;
import net.zillions.buffett.model.TbLabelBookmark;
import net.zillions.buffett.model.TbLabelBookmarkExample;
import net.zillions.buffett.model.TbLabelExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 */
@Controller
public class BookmarkController {

	/**
	 * 
	 */
	private static final String DEFALT_USER_ID = "0000000001";

	@Autowired
	private TbBookmarkMapper _tbBookmarkMapper;

	@Autowired
	private TbLabelBookmarkMapper _tbLabelBookmarkMapper;

	@Autowired
	private TbLabelMapper _tbLabelMapper;

	/**
	 * 
	 * @return
	 */
	@ModelAttribute
	public BookmarkForm setUpBookmarkForm() {
		return new BookmarkForm();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookmark/")
	public ModelAndView init(HttpServletRequest request) {

		String userId = DEFALT_USER_ID;

		ModelAndView mav = new ModelAndView("bookmark/main");

		//
		List<TbLabel> labels = getLabels(userId);
		mav.addObject("labels", labels);

		Map<String[], List<TbBookmark>> labelAndBookmarks = new LinkedHashMap<>();
		mav.addObject("labelAndBookmarks", labelAndBookmarks);

		if (labels.isEmpty()) {
			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			if (bookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[]{"*", "ラベル無し"}, bookmarks);
			}
			return mav;
		}

		for (TbLabel label : labels) {

			int labelId = label.getLabelId();
			if (isLabelBookmarkExist(labelId, userId) == false) {
				continue;
			}

			// select bookmark
			List<Integer> bookmarkIds = getLabelBookmarkIds(labelId, userId);

			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdIn(bookmarkIds);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);

			labelAndBookmarks.put(new String[]{label.getLabelId().toString(), label.getLabelName()}, bookmarks);

		}

		// select label_bookmark
		List<Integer> bookmarkIds = getLabelBookmarkIds(-1, userId);
		if (bookmarkIds == null || bookmarkIds.isEmpty()) {
			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			if (bookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[]{"*", "ラベル無し"}, bookmarks);
			}
			return mav;
		}

		// select bookmark
		TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
		tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdNotIn(bookmarkIds);
		List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
		if (bookmarks.isEmpty() == false) {
			labelAndBookmarks.put(new String[]{"*", "ラベル無し"}, bookmarks);
		}

		return mav;
	}

	@RequestMapping("/bookmark/select")
	public ModelAndView select(HttpServletRequest request) {
		
		String userId = DEFALT_USER_ID;

		String starValue = request.getParameter("star");
		String importantValue = request.getParameter("important");
		String labelIdValue = request.getParameter("labelId");
		
		if ("1".equals(starValue) == false && "1".equals(importantValue) == false && (labelIdValue == null || "".equals(labelIdValue) || BuffettUtils.isDigit(labelIdValue) == false)) {
			return new ModelAndView("redirect:/app/bookmark/");
		}

		ModelAndView mav = new ModelAndView("bookmark/main");

		//
		List<TbLabel> labels = getLabels(userId);
		mav.addObject("labels", labels);
		
		Map<String[], List<TbBookmark>> labelAndBookmarks = new LinkedHashMap<>();
		mav.addObject("labelAndBookmarks", labelAndBookmarks);
		
		TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
		List<TbBookmark> tbBookmarks = null;
		if ("1".equals(starValue)) {
			tbBookmarkExample.getOredCriteria().get(0).andStarEqualTo(true);
			tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			
			if (tbBookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[]{"*", "スター"}, tbBookmarks);
			}
			
		} else if("1".equals(importantValue)) {
			tbBookmarkExample.getOredCriteria().get(0).andImportantEqualTo(true);
			tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			
			if (tbBookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[]{"*", "重要"}, tbBookmarks);
			}
			
		} else {
			int labelId = Integer.parseInt(labelIdValue);
			
			TbLabel tbLabel = _tbLabelMapper.findByPk(labelId);
			
			if (tbLabel != null) {
				TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
				tbLabelBookmarkExample.createCriteria().andLabelIdEqualTo(labelId).andUpdateUserEqualTo(userId);
				List<TbLabelBookmark> tbLabelBookmarks = _tbLabelBookmarkMapper.selectByEx(tbLabelBookmarkExample);
				List<Integer> bookmarkIds = new ArrayList<>();
				for (TbLabelBookmark tbLabelBookmark : tbLabelBookmarks) {
					bookmarkIds.add(tbLabelBookmark.getBookmarkId());
				}
				tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdIn(bookmarkIds);
				tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
				
				if (tbBookmarks.isEmpty() == false) {
					labelAndBookmarks.put(new String[] {tbLabel.getLabelId().toString(), tbLabel.getLabelName()}, tbBookmarks);
				}
			}
		}
		
		return mav;
	}

	/**
	 * 
	 * @param createUser
	 * @return
	 */
	private List<TbLabel> getLabels(String createUser) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andCreateUserEqualTo(createUser);
		tbLabelExample.setOrderByClause("use_count desc");
		return _tbLabelMapper.selectByEx(tbLabelExample);
	}

	/**
	 * 
	 * @param labelId
	 * @param userId
	 * @return
	 */
	private boolean isLabelBookmarkExist(int labelId, String userId) {
		TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
		tbLabelBookmarkExample.createCriteria().andLabelIdEqualTo(labelId).andCreateUserEqualTo(userId);
		return _tbLabelBookmarkMapper.countByEx(tbLabelBookmarkExample) > 0;
	}

	/**
	 * 
	 * @param updateUser
	 * @return
	 */
	private TbBookmarkExample getTbBookmarkExample(String updateUser) {
		TbBookmarkExample tbBookmarkExample = new TbBookmarkExample();
		tbBookmarkExample.createCriteria().andUpdateUserEqualTo(updateUser);
		tbBookmarkExample.setOrderByClause("star desc, important desc, use_count desc");
		return tbBookmarkExample;
	}

	/**
	 * 
	 * @param labelid
	 * @param userId
	 * @return
	 */
	private List<Integer> getLabelBookmarkIds(int labelId, String userId) {
		TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
		if (labelId > 0) {
			tbLabelBookmarkExample.createCriteria().andLabelIdEqualTo(labelId).andCreateUserEqualTo(userId);
		} else {
			tbLabelBookmarkExample.createCriteria().andCreateUserEqualTo(userId);
		}
		List<TbLabelBookmark> labelBookmarks = _tbLabelBookmarkMapper.selectByEx(tbLabelBookmarkExample);

		List<Integer> bookmarkIds = new ArrayList<>();
		for (TbLabelBookmark tbLabelBookmark : labelBookmarks) {
			bookmarkIds.add(tbLabelBookmark.getBookmarkId());
		}
		return bookmarkIds;
	}

	/**
	 * 
	 * @param bookmarkForm
	 * @return
	 */
	@RequestMapping("/bookmark/add")
	public String add(@Valid BookmarkForm bookmarkForm, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.bookmarkForm", result);
			attr.addFlashAttribute("bookmarkForm", bookmarkForm);
			return "redirect:/app/bookmark/";
		}

		String userId = DEFALT_USER_ID;

		int bookmarkId = addBookmark(bookmarkForm, userId);

		String labelIdsValue = bookmarkForm.getLabelIds();
		if (labelIdsValue != null && labelIdsValue.isEmpty() == false) {
			for (String labelId : labelIdsValue.split(",")) {
				if (BuffettUtils.isDigit(labelId) == false) {
					continue;
				}
				_tbLabelBookmarkMapper.insertSelective(new TbLabelBookmark(Integer.parseInt(labelId), bookmarkId, userId, null,
						userId, null, null));
			}
		}

		String labelValue = bookmarkForm.getLabel();
		if (labelValue == null || labelValue.isEmpty()) {
			return "redirect:/app/bookmark/";
		}

		String[] labels = labelValue.split(",");

		for (String label : labels) {
			label = label.trim();

			int labelId = isLabelExist(label, userId) ? findLabelId(label, userId) : addLabel(label, userId);

			TbLabelBookmark tbLabelBookmark = new TbLabelBookmark(labelId, bookmarkId, userId, null, userId, null, null);
			_tbLabelBookmarkMapper.insertSelective(tbLabelBookmark);
		}

		return "redirect:/app/bookmark/";
	}

	/**
	 * 
	 * @param bookmarkForm
	 * @param userId
	 * @return
	 */
	private synchronized int addBookmark(BookmarkForm bookmarkForm, String userId) {
		TbBookmark tbBookmark = new TbBookmark();
		tbBookmark.setUrl(bookmarkForm.getUrl());
		tbBookmark.setTitle(bookmarkForm.getTitle());
		tbBookmark.setDescription(bookmarkForm.getDescription());
		tbBookmark.setStar("1".equals(bookmarkForm.getStar()));
		tbBookmark.setImportant("1".equals(bookmarkForm.getImportant()));
		tbBookmark.setCreateUser(userId);
		tbBookmark.setUpdateUser(userId);
		_tbBookmarkMapper.insertSelective(tbBookmark);

		TbBookmarkExample tbBookmarkExample = new TbBookmarkExample();
		tbBookmarkExample.setOrderByClause("updated desc");
		return _tbBookmarkMapper.selectByEx(tbBookmarkExample).get(0).getBookmarkId();
	}

	/**
	 * 
	 * @param label
	 * @return
	 */
	private boolean isLabelExist(String label, String userId) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andLabelNameEqualTo(label).andUpdateUserEqualTo(userId);
		return _tbLabelMapper.countByEx(tbLabelExample) > 0;
	}

	/**
	 * 
	 * @param label
	 * @param userId
	 * @return
	 */
	private synchronized int addLabel(String label, String userId) {
		TbLabel tbLabel = new TbLabel(null, label, null, userId, null, userId, null, null);
		_tbLabelMapper.insertSelective(tbLabel);

		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.setOrderByClause("updated desc");
		return _tbLabelMapper.selectByEx(tbLabelExample).get(0).getLabelId();
	}

	/**
	 * 
	 * @param label
	 * @param userId
	 * @return
	 */
	private int findLabelId(String label, String userId) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andLabelNameEqualTo(label).andUpdateUserEqualTo(userId);
		return _tbLabelMapper.selectByEx(tbLabelExample).get(0).getLabelId();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookmark/update")
	public ModelAndView update(HttpServletRequest request) {
		return null;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookmark/delete")
	public String delete(HttpServletRequest request) {

		String userId = DEFALT_USER_ID;

		String bookmarkIdValue = request.getParameter("bookmarkId");
		if (BuffettUtils.isDigit(bookmarkIdValue) == false) {
			return "redirect:/app/bookmark/";
		}

		int bookmarkId = Integer.parseInt(bookmarkIdValue);
		_tbBookmarkMapper.deleteByPk(bookmarkId);

		TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
		tbLabelBookmarkExample.createCriteria().andBookmarkIdEqualTo(bookmarkId).andUpdateUserEqualTo(userId);
		List<TbLabelBookmark> labelBookmarks = _tbLabelBookmarkMapper.selectByEx(tbLabelBookmarkExample);

		List<Integer> deletedLabelIds = new ArrayList<>();
		for (TbLabelBookmark labelBookmark : labelBookmarks) {
			_tbLabelBookmarkMapper.deleteByPk(labelBookmark.getLabelId(), labelBookmark.getBookmarkId());
			deletedLabelIds.add(labelBookmark.getLabelId());
		}

		for (Integer deleteLabelId : deletedLabelIds) {
			tbLabelBookmarkExample = new TbLabelBookmarkExample();
			tbLabelBookmarkExample.createCriteria().andLabelIdEqualTo(deleteLabelId);
			List<TbLabelBookmark> result = _tbLabelBookmarkMapper.selectByEx(tbLabelBookmarkExample);
			if (result.isEmpty()) {
				_tbLabelMapper.deleteByPk(deleteLabelId);
			}
		}

		return "redirect:/app/bookmark/";
	}

	@RequestMapping("/bookmark/countUp")
	public synchronized ModelAndView countUp(HttpServletRequest request) {
		
		String userId = DEFALT_USER_ID;
		
		String bookmarkIdValue = request.getParameter("bookmarkId");
		if (BuffettUtils.isDigit(bookmarkIdValue)) {
			int bookmarkId = Integer.parseInt(bookmarkIdValue);
			int count = _tbBookmarkMapper.findByPk(bookmarkId).getUseCount();
			TbBookmark tbBookmark = new TbBookmark(bookmarkId, null, null, null, ++count, null, null, null, null, userId, Calendar.getInstance().getTime(), null);
			_tbBookmarkMapper.updateByPkSelective(tbBookmark);
		}
		
		String labelIdValue = request.getParameter("labelId");
		if (BuffettUtils.isDigit(labelIdValue)) {
			int labelId = Integer.parseInt(labelIdValue);
			int count = _tbLabelMapper.findByPk(labelId).getUseCount();
			TbLabel tbLabel = new TbLabel(labelId, null, ++count, null, null, userId, Calendar.getInstance().getTime(), null); 
			_tbLabelMapper.updateByPkSelective(tbLabel);
		}

		ModelAndView mav = new ModelAndView("bookmark/rest");
		mav.addObject("result", "0");
		return mav;
	}
	
	
}
