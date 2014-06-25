package net.zillions.buffett.model;

import java.io.Serializable;
import java.util.Date;

public class TbBookmark implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.bookmark_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Integer bookmarkId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.url
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.title
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.description
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.use_count
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Integer useCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.star
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Boolean star;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.important
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Boolean important;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Date created;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String updateUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Date updated;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_bookmark.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Boolean deleted;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_bookmark
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public TbBookmark(Integer bookmarkId, String url, String title, String description, Integer useCount, Boolean star,
			Boolean important, String createUser, Date created, String updateUser, Date updated, Boolean deleted) {
		this.bookmarkId = bookmarkId;
		this.url = url;
		this.title = title;
		this.description = description;
		this.useCount = useCount;
		this.star = star;
		this.important = important;
		this.createUser = createUser;
		this.created = created;
		this.updateUser = updateUser;
		this.updated = updated;
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_bookmark
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public TbBookmark() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.bookmark_id
	 * @return  the value of public.tb_bookmark.bookmark_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Integer getBookmarkId() {
		return bookmarkId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.bookmark_id
	 * @param bookmarkId  the value for public.tb_bookmark.bookmark_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.url
	 * @return  the value of public.tb_bookmark.url
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.url
	 * @param url  the value for public.tb_bookmark.url
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.title
	 * @return  the value of public.tb_bookmark.title
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.title
	 * @param title  the value for public.tb_bookmark.title
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.description
	 * @return  the value of public.tb_bookmark.description
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.description
	 * @param description  the value for public.tb_bookmark.description
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.use_count
	 * @return  the value of public.tb_bookmark.use_count
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Integer getUseCount() {
		return useCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.use_count
	 * @param useCount  the value for public.tb_bookmark.use_count
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.star
	 * @return  the value of public.tb_bookmark.star
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Boolean getStar() {
		return star;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.star
	 * @param star  the value for public.tb_bookmark.star
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setStar(Boolean star) {
		this.star = star;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.important
	 * @return  the value of public.tb_bookmark.important
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Boolean getImportant() {
		return important;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.important
	 * @param important  the value for public.tb_bookmark.important
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setImportant(Boolean important) {
		this.important = important;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.create_user
	 * @return  the value of public.tb_bookmark.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.create_user
	 * @param createUser  the value for public.tb_bookmark.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.created
	 * @return  the value of public.tb_bookmark.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.created
	 * @param created  the value for public.tb_bookmark.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.update_user
	 * @return  the value of public.tb_bookmark.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.update_user
	 * @param updateUser  the value for public.tb_bookmark.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.updated
	 * @return  the value of public.tb_bookmark.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.updated
	 * @param updated  the value for public.tb_bookmark.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_bookmark.deleted
	 * @return  the value of public.tb_bookmark.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_bookmark.deleted
	 * @param deleted  the value for public.tb_bookmark.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_bookmark
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", bookmarkId=").append(bookmarkId);
		sb.append(", url=").append(url);
		sb.append(", title=").append(title);
		sb.append(", description=").append(description);
		sb.append(", useCount=").append(useCount);
		sb.append(", star=").append(star);
		sb.append(", important=").append(important);
		sb.append(", createUser=").append(createUser);
		sb.append(", created=").append(created);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updated=").append(updated);
		sb.append(", deleted=").append(deleted);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1488185363095543603L;
}