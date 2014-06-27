package net.zillions.buffett.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.zillions.buffett.BuffettUtils;
import net.zillions.buffett.client.MapperFactory;
import net.zillions.buffett.client.TbBookmarkMapper;
import net.zillions.buffett.client.TbLabelBookmarkMapper;
import net.zillions.buffett.client.TbLabelMapper;
import net.zillions.buffett.form.BookmarkForm;
import net.zillions.buffett.model.TbBookmark;
import net.zillions.buffett.model.TbBookmarkExample;
import net.zillions.buffett.model.TbLabel;
import net.zillions.buffett.model.TbLabelBookmark;
import net.zillions.buffett.model.TbLabelBookmarkExample;
import net.zillions.buffett.model.TbLabelBookmarkExample.Criteria;
import net.zillions.buffett.model.TbLabelExample;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.http.HttpParameters;

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
	public ModelAndView init(HttpServletRequest request, HttpSession session) throws OAuthException {

		String userId = DEFALT_USER_ID;
		ModelAndView mav = new ModelAndView("bookmark/main");

		if (session.getAttribute("consumer") != null && session.getAttribute("userId") == null) {
			OAuthConsumer consumer = (OAuthConsumer) session.getAttribute("consumer");
			OAuthProvider provider = (OAuthProvider) session.getAttribute("provider");

			String oauth_verifier = request.getParameter("oauth_verifier");
			provider.retrieveAccessToken(consumer, oauth_verifier);
			// String accessToken = consumer.getToken();
			// String tokenSecret = consumer.getTokenSecret();

			HttpParameters hp = provider.getResponseParameters();
			session.setAttribute("userId", hp.get("user_id").first());
			session.setAttribute("userName", hp.get("screen_name").first());
		}

		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}
//		if (session.getAttribute("userName") != null) {
//			mav.addObject("userName", session.getAttribute("userName").toString());
//		}

		//
		List<Object[]> labels = getLabels(userId);
		mav.addObject("labels", labels);

		Map<String[], List<TbBookmark>> labelAndBookmarks = new LinkedHashMap<>();
		mav.addObject("labelAndBookmarks", labelAndBookmarks);

		if (labels.isEmpty()) {
			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			if (bookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[] {"-1", "ラベル無し"}, TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(bookmarks));
			}
			return mav;
		}

		for (Object[] label : labels) {

			int labelId = ((TbLabel)label[0]).getLabelId();
			if (isLabelBookmarkExist(labelId, userId) == false) {
				continue;
			}

			// select bookmark
			List<Integer> bookmarkIds = getLabelBookmarkIds(labelId, userId);

			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdIn(bookmarkIds);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);

			labelAndBookmarks.put(
					new String[] {((TbLabel) label[0]).getLabelId().toString(), ((TbLabel) label[0]).getLabelName()},
					TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(bookmarks));

		}

		// select label_bookmark
		List<Integer> bookmarkIds = getLabelBookmarkIds(-1, userId);
		if (bookmarkIds == null || bookmarkIds.isEmpty()) {
			TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
			List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
			if (bookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[] {"-1", "ラベル無し"},
						TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(bookmarks));
			}
			return mav;
		}

		// select bookmark
		TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
		tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdNotIn(bookmarkIds);
		List<TbBookmark> bookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
		if (bookmarks.isEmpty() == false) {
			labelAndBookmarks.put(new String[] {"-1", "ラベル無し"},
					TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(bookmarks));
		}

		return mav;
	}

	@RequestMapping("/bookmark/select")
	public ModelAndView select(HttpServletRequest request, HttpSession session) {

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

		String starValue = request.getParameter("star");
		String importantValue = request.getParameter("important");
		String labelIdValue = request.getParameter("labelId");

		if ("1".equals(starValue) == false && "1".equals(importantValue) == false
				&& (labelIdValue == null || "".equals(labelIdValue) || BuffettUtils.isDigit(labelIdValue) == false)) {
			return new ModelAndView("redirect:/app/bookmark/");
		}

		ModelAndView mav = new ModelAndView("bookmark/main");

		//
		List<Object[]> labels = getLabels(userId);
		mav.addObject("labels", labels);

		Map<String[], List<TbBookmark>> labelAndBookmarks = new LinkedHashMap<>();
		mav.addObject("labelAndBookmarks", labelAndBookmarks);

		TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(userId);
		List<TbBookmark> tbBookmarks = null;
		if ("1".equals(starValue)) {
			tbBookmarkExample.getOredCriteria().get(0).andStarEqualTo(true);
			tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);

			if (tbBookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[] {"*", "スター"}, TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(tbBookmarks));
			}

		} else if ("1".equals(importantValue)) {
			tbBookmarkExample.getOredCriteria().get(0).andImportantEqualTo(true);
			tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);

			if (tbBookmarks.isEmpty() == false) {
				labelAndBookmarks.put(new String[] {"*", "重要"}, TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(tbBookmarks));
			}

		} else {
			int labelId = Integer.parseInt(labelIdValue);

			synchronized (_tbLabelMapper) {

				TbLabel tbLabel = _tbLabelMapper.findByPk(labelId);

				if (tbLabel != null) {

					int count = tbLabel.getUseCount();
					TbLabel tbLabelNew = new TbLabel(labelId, null, ++count, null, null, userId,
							Calendar.getInstance().getTime(), null);
					_tbLabelMapper.updateByPkSelective(tbLabelNew);

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
						labelAndBookmarks.put(
								new String[] {tbLabel.getLabelId().toString(), tbLabel.getLabelName()},
								TbBookmarkWithLabelIds.getTbBookmarkWithLabelIds(tbBookmarks));
					}
				} else {
					// ラベル無しのブックマークを表示する
					String[] key = new String[] {"-1", "ラベル無し"};

					List<TbBookmark> tbBookmarksAll = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
					for (TbBookmark tbBookmark : tbBookmarksAll) {
						TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
						tbLabelBookmarkExample.createCriteria().andBookmarkIdEqualTo(tbBookmark.getBookmarkId());
						if (0 == _tbLabelBookmarkMapper.countByEx(tbLabelBookmarkExample)) {
							List<TbBookmark> tbBookmarksWithoutLabel = labelAndBookmarks.get(key);
							if (tbBookmarksWithoutLabel == null) {
								tbBookmarksWithoutLabel = new ArrayList<>();
								labelAndBookmarks.put(key, tbBookmarksWithoutLabel);
							}
							tbBookmarksWithoutLabel.add(new TbBookmarkWithLabelIds(tbBookmark));
						}
					}

				}
			}
		}

		return mav;
	}

	/**
	 * 
	 * @param updateUser
	 * @return
	 */
	private List<Object[]> getLabels(String updateUser) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andUpdateUserEqualTo(updateUser);
		tbLabelExample.setOrderByClause("use_count desc");
		List<TbLabel> tbLabels = _tbLabelMapper.selectByEx(tbLabelExample);
		
		List<Object[]> result = new ArrayList<>();
		
		TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
		for (TbLabel tbLabel : tbLabels){
			tbLabelBookmarkExample.createCriteria().andLabelIdEqualTo(tbLabel.getLabelId());
			int count = _tbLabelBookmarkMapper.countByEx(tbLabelBookmarkExample);
			Object[] obj = new Object[]{tbLabel, count};
			result.add(obj);
		}
		
		// ラベルが無いブックマークがないか探す
		tbLabelBookmarkExample = new TbLabelBookmarkExample();
		tbLabelBookmarkExample.createCriteria().andUpdateUserEqualTo(updateUser);
		List<TbLabelBookmark> tbLabelBookmarks = _tbLabelBookmarkMapper.selectByEx(tbLabelBookmarkExample);
		
		List<Integer> bookmarkIds = new ArrayList<>();
		for (TbLabelBookmark tbLabelBookmark : tbLabelBookmarks) {
			bookmarkIds.add(tbLabelBookmark.getBookmarkId());
		}
		
		TbBookmarkExample tbBookmarkExample = getTbBookmarkExample(updateUser);
		tbBookmarkExample.getOredCriteria().get(0).andBookmarkIdNotIn(bookmarkIds);
		int size = _tbBookmarkMapper.countByEx(tbBookmarkExample);
		if (size > 0) {
			TbLabel tbLabel = new TbLabel(-1, "ラベル無し", null, null, null, null, null, null);
			result.add(new Object[]{tbLabel, size});
		}
		
		return result;
		
//		TbBookmarkExample tbBookmarkExample = new TbBookmarkExample();
//		tbBookmarkExample.createCriteria().andUpdateUserEqualTo(updateUser);
//		List<TbBookmark> tbBookmarks = _tbBookmarkMapper.selectByEx(tbBookmarkExample);
//
//		for (TbBookmark tbBookmark : tbBookmarks) {
//			int bookmarkId = tbBookmark.getBookmarkId();
//
//			tbLabelBookmarkExample = new TbLabelBookmarkExample();
//			tbLabelBookmarkExample.createCriteria().andBookmarkIdEqualTo(bookmarkId);
//			if (0 == _tbLabelBookmarkMapper.countByEx(tbLabelBookmarkExample)) {
//				TbLabel tbLabel = new TbLabel(-1, "ラベル無し", null, null, null, null, null, null);
//				tbLabels.add(tbLabel);
//				break;
//			}
//		}

//		return tbLabels;
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
	public String add(@Valid BookmarkForm bookmarkForm, BindingResult result, RedirectAttributes attr, HttpSession session) {

		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.bookmarkForm", result);
			attr.addFlashAttribute("bookmarkForm", bookmarkForm);
			return "redirect:/app/bookmark/";
		}

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

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

			int labelId = isLabelNameExist(label, userId) ? findLabelId(label, userId) : addLabel(label, userId);

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
	 * @param labelName
	 * @return
	 */
	private boolean isLabelNameExist(String labelName, String userId) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andLabelNameEqualTo(labelName).andUpdateUserEqualTo(userId);
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
	 * @param labelName
	 * @param userId
	 * @return
	 */
	private int findLabelId(String labelName, String userId) {
		TbLabelExample tbLabelExample = new TbLabelExample();
		tbLabelExample.createCriteria().andLabelNameEqualTo(labelName).andUpdateUserEqualTo(userId);
		return _tbLabelMapper.selectByEx(tbLabelExample).get(0).getLabelId();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookmark/update")
	public String update(@Valid BookmarkForm bookmarkForm, BindingResult result, RedirectAttributes attr, HttpSession session) {

		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.bookmarkForm", result);
			attr.addFlashAttribute("bookmarkForm", bookmarkForm);
			return "redirect:/app/bookmark/";
		}

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

		int bookmarkId = bookmarkForm.getBookmarkId();
		if (_tbBookmarkMapper.findByPk(bookmarkId) == null) {
			return "redirect:/app/bookmark/";
		}

		TbBookmark tbBookmark = new TbBookmark();
		tbBookmark.setBookmarkId(bookmarkId);
		tbBookmark.setUrl(bookmarkForm.getUrl());
		tbBookmark.setTitle(bookmarkForm.getTitle());
		tbBookmark.setDescription(bookmarkForm.getDescription());
		tbBookmark.setStar("1".equals(bookmarkForm.getStar()));
		tbBookmark.setImportant("1".equals(bookmarkForm.getImportant()));
		tbBookmark.setUpdateUser(userId);
		tbBookmark.setUpdated(Calendar.getInstance().getTime());
		_tbBookmarkMapper.updateByPkSelective(tbBookmark);

		// ボタンのラベル

		List<Integer> currentLabelIdsRelated = getLabelIdsRelated(bookmarkId);
		List<Integer> updateLabelIdsRelated = new ArrayList<>();

		String labelIdsValue = bookmarkForm.getLabelIds();
		if (labelIdsValue != null && labelIdsValue.isEmpty() == false) {
			for (String labelId : labelIdsValue.split(",")) {
				if (BuffettUtils.isDigit(labelId) == false) {
					continue;
				}
				updateLabelIdsRelated.add(Integer.parseInt(labelId));
			}
		}

		// 更新後のラベルに含まれない現在のラベルは削除
		for (Integer currentLabelId : currentLabelIdsRelated) {
			if (updateLabelIdsRelated.contains(currentLabelId) == false) {
				deleteLabelBookmark(bookmarkId, currentLabelId, userId);
			}
		}

		// 現在のラベルに含まれない更新後のラベルを追加
		for (Integer updateLabelId : updateLabelIdsRelated) {
			if (currentLabelIdsRelated.contains(updateLabelId) == false) {
				TbLabelBookmark tbLabelBookmark = new TbLabelBookmark(updateLabelId, bookmarkId, userId, null, userId, null, null);
				_tbLabelBookmarkMapper.insertSelective(tbLabelBookmark);
			}
		}

		// テキストのラベル
		String labelValue = bookmarkForm.getLabel();
		if (labelValue == null || labelValue.isEmpty()) {
			return "redirect:/app/bookmark/";
		}

		String[] labels = labelValue.split(",");

		for (String label : labels) {
			label = label.trim();

			int labelId = isLabelNameExist(label, userId) ? findLabelId(label, userId) : addLabel(label, userId);

			// 既に関係が存在すれば、追加はしない
			if (_tbLabelBookmarkMapper.findByPk(labelId, bookmarkId) != null) {
				continue;
			}

			TbLabelBookmark tbLabelBookmark = new TbLabelBookmark(labelId, bookmarkId, userId, null, userId, null, null);
			_tbLabelBookmarkMapper.insertSelective(tbLabelBookmark);
		}

		return "redirect:/app/bookmark/";
	}

	/**
	 * 
	 * @param bookmarkId
	 * @return
	 */
	private List<Integer> getLabelIdsRelated(int bookmarkId) {
		TbLabelBookmarkExample example = new TbLabelBookmarkExample();
		example.createCriteria().andBookmarkIdEqualTo(bookmarkId);
		List<TbLabelBookmark> tbLabelBookmarks = _tbLabelBookmarkMapper.selectByEx(example);
		List<Integer> labelIds = new ArrayList<>();
		for (TbLabelBookmark tbLabelBookmark : tbLabelBookmarks) {
			labelIds.add(tbLabelBookmark.getLabelId());
		}
		return labelIds;
	}

	@RequestMapping("/bookmark/updateMark")
	public ModelAndView updateMark(HttpServletRequest request, HttpSession session) {

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

		String bookmarkIdValue = request.getParameter("bookmarkId");
		if (BuffettUtils.isDigit(bookmarkIdValue) == false) {
			ModelAndView mav = new ModelAndView("bookmark/rest");
			mav.addObject("result", "1");
			return mav;
		}
		int bookmarkId = Integer.parseInt(bookmarkIdValue);

		String starValue = request.getParameter("star");
		String importantValue = request.getParameter("important");

		if (starValue != null) {
			TbBookmark tbBookmark = new TbBookmark(bookmarkId, null, null, null, null, "1".equals(starValue), null, null, null,
					userId, Calendar.getInstance().getTime(), null);
			_tbBookmarkMapper.updateByPkSelective(tbBookmark);
		}

		if (importantValue != null) {
			TbBookmark tbBookmark = new TbBookmark(bookmarkId, null, null, null, null, null, "1".equals(importantValue), null,
					null, userId, Calendar.getInstance().getTime(), null);
			_tbBookmarkMapper.updateByPkSelective(tbBookmark);
		}

		ModelAndView mav = new ModelAndView("bookmark/rest");
		mav.addObject("result", "0");
		return mav;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookmark/delete")
	public String delete(HttpServletRequest request, HttpSession session) {

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

		String bookmarkIdValue = request.getParameter("bookmarkId");
		if (BuffettUtils.isDigit(bookmarkIdValue) == false) {
			return "redirect:/app/bookmark/";
		}

		int bookmarkId = Integer.parseInt(bookmarkIdValue);
		_tbBookmarkMapper.deleteByPk(bookmarkId);

		deleteLabelBookmark(bookmarkId, -1, userId);

		return "redirect:/app/bookmark/";
	}

	/**
	 * 
	 * @param bookmarkId
	 * @param userId
	 */
	private void deleteLabelBookmark(int bookmarkId, int labelId, String userId) {

		TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();

		Criteria criteria = tbLabelBookmarkExample.createCriteria().andUpdateUserEqualTo(userId);
		if (bookmarkId > 0) {
			criteria.andBookmarkIdEqualTo(bookmarkId);
		}
		if (labelId > 0) {
			criteria.andLabelIdEqualTo(labelId);
		}

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

	}

	@RequestMapping("/bookmark/countUp")
	public synchronized ModelAndView countUp(HttpServletRequest request, HttpSession session) {

		String userId = DEFALT_USER_ID;
		if (session.getAttribute("userId") != null) {
			userId = session.getAttribute("userId").toString();
		}

		String bookmarkIdValue = request.getParameter("bookmarkId");
		if (BuffettUtils.isDigit(bookmarkIdValue)) {
			int bookmarkId = Integer.parseInt(bookmarkIdValue);
			int count = _tbBookmarkMapper.findByPk(bookmarkId).getUseCount();
			TbBookmark tbBookmark = new TbBookmark(bookmarkId, null, null, null, ++count, null, null, null, null, userId,
					Calendar.getInstance().getTime(), null);
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

	@RequestMapping("/bookmark/oauth")
	public ModelAndView oauth(HttpSession session) throws OAuthException {

		// @formatter:off
		OAuthConsumer consumer = new DefaultOAuthConsumer(
				"KrR7XUS4M5hzPB5Cx86BtbVLt",
				"yh8T8JvHrCdzUEVHLmvtCktYKCD3GTBVYRdRW2IMRdjarOrnDu");
		
		OAuthProvider provider = new DefaultOAuthProvider(
				"https://api.twitter.com/oauth/request_token",
				"https://api.twitter.com/oauth/access_token",
				"https://api.twitter.com/oauth/authorize");
		// @formatter:on

		session.setAttribute("consumer", consumer);
		session.setAttribute("provider", provider);

		String hostName = System.getenv("HOST_NAME");
		if (hostName == null) {
			hostName = "localhost:8080";
		}
		String callbackUri = "http://" + hostName + "/app/bookmark/";
		String authUrl = provider.retrieveRequestToken(consumer, callbackUri);
		return new ModelAndView("redirect:" + authUrl);
	}

	/**
	 * 
	 *
	 */
	public static class TbBookmarkWithLabelIds extends TbBookmark {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2661314088198543655L;

		private List<Integer> _labelIds = new ArrayList<>();

		/**
		 * 
		 * @param tbBookmark
		 */
		public TbBookmarkWithLabelIds(TbBookmark tbBookmark) {
			setBookmarkId(tbBookmark.getBookmarkId());
			setCreated(tbBookmark.getCreated());
			setCreateUser(tbBookmark.getCreateUser());
			setDeleted(tbBookmark.getDeleted());
			setDescription(tbBookmark.getDescription());
			setImportant(tbBookmark.getImportant());
			setStar(tbBookmark.getStar());
			setTitle(tbBookmark.getTitle());
			setUpdated(tbBookmark.getUpdated());
			setUpdateUser(tbBookmark.getUpdateUser());
			setUrl(tbBookmark.getUrl());
			setUseCount(tbBookmark.getUseCount());

			TbLabelBookmarkExample tbLabelBookmarkExample = new TbLabelBookmarkExample();
			tbLabelBookmarkExample.createCriteria().andBookmarkIdEqualTo(getBookmarkId());
			List<TbLabelBookmark> tbLabelBookmarks = MapperFactory.getMapper(TbLabelBookmarkMapper.class).selectByEx(
					tbLabelBookmarkExample);
			for (TbLabelBookmark tbLabelBookmark : tbLabelBookmarks) {
				_labelIds.add(tbLabelBookmark.getLabelId());
			}
		}

		public List<Integer> getLabelIds() {
			return this._labelIds;
		}

		public void setLabelIds(List<Integer> labelIds) {
			this._labelIds = labelIds;
		}

		public String getJoinedLabelIds() {
			StringBuilder sb = new StringBuilder();
			for (Integer labelId : _labelIds) {
				sb.append(labelId).append(",");
			}
			String value = sb.toString();
			if (value.length() == 0) {
				return value;
			}
			return value.substring(0, value.length() - 1);
		}

		public static List<TbBookmark> getTbBookmarkWithLabelIds(List<TbBookmark> tbBookmarks) {
			if (tbBookmarks == null || tbBookmarks.isEmpty()) {
				return new ArrayList<>();
			}

			List<TbBookmark> result = new ArrayList<>();
			for (TbBookmark tbBookmark : tbBookmarks) {
				result.add(new TbBookmarkWithLabelIds(tbBookmark));
			}
			return result;
		}

	}

}
