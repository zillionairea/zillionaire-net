package net.zillions.buffett.model;

import java.io.Serializable;
import java.util.Date;

public class TbMemo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1431968004885472150L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_memo.memo_id
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    private Integer memoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_memo.memo_content
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    private String memoContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_memo.created
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_memo.deleted
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public TbMemo(Integer memoId, String memoContent, Date created, Boolean deleted) {
        this.memoId = memoId;
        this.memoContent = memoContent;
        this.created = created;
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public TbMemo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_memo.memo_id
     *
     * @return the value of public.tb_memo.memo_id
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public Integer getMemoId() {
        return memoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_memo.memo_id
     *
     * @param memoId the value for public.tb_memo.memo_id
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setMemoId(Integer memoId) {
        this.memoId = memoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_memo.memo_content
     *
     * @return the value of public.tb_memo.memo_content
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public String getMemoContent() {
        return memoContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_memo.memo_content
     *
     * @param memoContent the value for public.tb_memo.memo_content
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_memo.created
     *
     * @return the value of public.tb_memo.created
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_memo.created
     *
     * @param created the value for public.tb_memo.created
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_memo.deleted
     *
     * @return the value of public.tb_memo.deleted
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_memo.deleted
     *
     * @param deleted the value for public.tb_memo.deleted
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_memo
     *
     * @mbggenerated Mon Jun 23 23:35:12 JST 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memoId=").append(memoId);
        sb.append(", memoContent=").append(memoContent);
        sb.append(", created=").append(created);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}