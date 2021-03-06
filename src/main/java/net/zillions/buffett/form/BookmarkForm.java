package net.zillions.buffett.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
public class BookmarkForm {
	
	private int _bookmarkId = -1;

	@NotBlank
	private String _url = null;

	private String _title = null;

	private String _description = null;

	private String _label = null;
	
	private String _labelIds = null;

	private String _star = null;

	private String _important = null;
	
	public void setBookmarkId(int bookmarkId) {
		this._bookmarkId = bookmarkId;
	}

	public void setUrl(String url) {
		this._url = url;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public void setLabel(String label) {
		this._label = label;
	}

	public void setLabelIds(String labelIds) {
		this._labelIds = labelIds;
	}

	public void setStar(String star) {
		this._star = star;
	}

	public void setImportant(String important) {
		this._important = important;
	}
	
	public int getBookmarkId() {
		return this._bookmarkId;
	}

	public String getUrl() {
		return this._url;
	}

	public String getTitle() {
		return this._title;
	}

	public String getDescription() {
		return this._description;
	}

	public String getLabel() {
		return this._label;
	}

	public String getLabelIds() {
		return this._labelIds;
	}

	public String getStar() {
		return this._star;
	}

	public String getImportant() {
		return this._important;
	}

}
