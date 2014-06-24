package net.zillions.buffett.model;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1292601884740084805L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.user_id
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.name_first
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String nameFirst;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.name_middle
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String nameMiddle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.name_family
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String nameFamily;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.mail_address
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String mailAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.create_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.created
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.update_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.updated
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.tb_user.deleted
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public TbUser(Integer userId, String nameFirst, String nameMiddle, String nameFamily, String mailAddress, String createUser, Date created, String updateUser, Date updated, Boolean deleted) {
        this.userId = userId;
        this.nameFirst = nameFirst;
        this.nameMiddle = nameMiddle;
        this.nameFamily = nameFamily;
        this.mailAddress = mailAddress;
        this.createUser = createUser;
        this.created = created;
        this.updateUser = updateUser;
        this.updated = updated;
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public TbUser() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.user_id
     *
     * @return the value of public.tb_user.user_id
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.user_id
     *
     * @param userId the value for public.tb_user.user_id
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.name_first
     *
     * @return the value of public.tb_user.name_first
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getNameFirst() {
        return nameFirst;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.name_first
     *
     * @param nameFirst the value for public.tb_user.name_first
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.name_middle
     *
     * @return the value of public.tb_user.name_middle
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getNameMiddle() {
        return nameMiddle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.name_middle
     *
     * @param nameMiddle the value for public.tb_user.name_middle
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.name_family
     *
     * @return the value of public.tb_user.name_family
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getNameFamily() {
        return nameFamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.name_family
     *
     * @param nameFamily the value for public.tb_user.name_family
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.mail_address
     *
     * @return the value of public.tb_user.mail_address
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.mail_address
     *
     * @param mailAddress the value for public.tb_user.mail_address
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.create_user
     *
     * @return the value of public.tb_user.create_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.create_user
     *
     * @param createUser the value for public.tb_user.create_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.created
     *
     * @return the value of public.tb_user.created
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.created
     *
     * @param created the value for public.tb_user.created
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.update_user
     *
     * @return the value of public.tb_user.update_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.update_user
     *
     * @param updateUser the value for public.tb_user.update_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.updated
     *
     * @return the value of public.tb_user.updated
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.updated
     *
     * @param updated the value for public.tb_user.updated
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.tb_user.deleted
     *
     * @return the value of public.tb_user.deleted
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.tb_user.deleted
     *
     * @param deleted the value for public.tb_user.deleted
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", nameFirst=").append(nameFirst);
        sb.append(", nameMiddle=").append(nameMiddle);
        sb.append(", nameFamily=").append(nameFamily);
        sb.append(", mailAddress=").append(mailAddress);
        sb.append(", createUser=").append(createUser);
        sb.append(", created=").append(created);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updated=").append(updated);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}