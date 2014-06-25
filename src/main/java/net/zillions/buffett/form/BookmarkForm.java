package net.zillions.buffett.form;

/**
 * 
 */
public class BookmarkForm {

	private String _url = null;

	private String _title = null;

	private String _description = null;

	private String _label = null;

	private String _star = null;

	private String _important = null;

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

	public void setStar(String star) {
		this._star = star;
	}

	public void setImportant(String important) {
		this._important = important;
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

	public String getStar() {
		return this._star;
	}

	public String getImportant() {
		return this._important;
	}

}
