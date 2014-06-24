package net.zillions.buffett.client;

import java.util.List;
import net.zillions.buffett.model.TbUser;
import net.zillions.buffett.model.TbUserExample;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper extends Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int countByEx(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int deleteByEx(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int deleteByPk(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int insert(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int insertSelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    List<TbUser> selectByEx(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    TbUser findByPk(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int updateByExSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int updateByEx(@Param("record") TbUser record, @Param("example") TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int updateByPkSelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.tb_user
     *
     * @mbggenerated Mon Jun 23 17:54:59 JST 2014
     */
    int updateByPk(TbUser record);
}