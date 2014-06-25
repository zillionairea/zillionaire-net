package net.zillions.buffett.client;

import java.util.List;
import net.zillions.buffett.model.TbIndustry;
import net.zillions.buffett.model.TbIndustryExample;
import org.apache.ibatis.annotations.Param;

public interface TbIndustryMapper extends Mapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int countByEx(TbIndustryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int deleteByEx(TbIndustryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int deleteByPk(Integer industryId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int insert(TbIndustry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int insertSelective(TbIndustry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	List<TbIndustry> selectByEx(TbIndustryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	TbIndustry findByPk(Integer industryId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByExSelective(@Param("record") TbIndustry record, @Param("example") TbIndustryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByEx(@Param("record") TbIndustry record, @Param("example") TbIndustryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByPkSelective(TbIndustry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_industry
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByPk(TbIndustry record);
}