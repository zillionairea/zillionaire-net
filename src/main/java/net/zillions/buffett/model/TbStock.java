package net.zillions.buffett.model;

import java.io.Serializable;
import java.util.Date;

public class TbStock implements Serializable {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.stock_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Integer stockId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.stock_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String stockCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.stock_name
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String stockName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.industry_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String industryCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Date created;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private String updateUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Date updated;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.tb_stock.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	private Boolean deleted;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public TbStock(Integer stockId, String stockCode, String stockName, String industryCode, String createUser, Date created,
			String updateUser, Date updated, Boolean deleted) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.industryCode = industryCode;
		this.createUser = createUser;
		this.created = created;
		this.updateUser = updateUser;
		this.updated = updated;
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public TbStock() {
		super();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.stock_id
	 * @return  the value of public.tb_stock.stock_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Integer getStockId() {
		return stockId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.stock_id
	 * @param stockId  the value for public.tb_stock.stock_id
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.stock_code
	 * @return  the value of public.tb_stock.stock_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getStockCode() {
		return stockCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.stock_code
	 * @param stockCode  the value for public.tb_stock.stock_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.stock_name
	 * @return  the value of public.tb_stock.stock_name
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.stock_name
	 * @param stockName  the value for public.tb_stock.stock_name
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.industry_code
	 * @return  the value of public.tb_stock.industry_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getIndustryCode() {
		return industryCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.industry_code
	 * @param industryCode  the value for public.tb_stock.industry_code
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.create_user
	 * @return  the value of public.tb_stock.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.create_user
	 * @param createUser  the value for public.tb_stock.create_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.created
	 * @return  the value of public.tb_stock.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.created
	 * @param created  the value for public.tb_stock.created
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.update_user
	 * @return  the value of public.tb_stock.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.update_user
	 * @param updateUser  the value for public.tb_stock.update_user
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.updated
	 * @return  the value of public.tb_stock.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.updated
	 * @param updated  the value for public.tb_stock.updated
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.tb_stock.deleted
	 * @return  the value of public.tb_stock.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.tb_stock.deleted
	 * @param deleted  the value for public.tb_stock.deleted
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", stockId=").append(stockId);
		sb.append(", stockCode=").append(stockCode);
		sb.append(", stockName=").append(stockName);
		sb.append(", industryCode=").append(industryCode);
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
	private static final long serialVersionUID = 5344446030833106990L;
}