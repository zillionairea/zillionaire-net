package net.zillions.buffett.client;

import java.util.List;
import net.zillions.buffett.model.TbMemo;
import net.zillions.buffett.model.TbMemoExample;
import org.apache.ibatis.annotations.Param;

public interface TbMemoMapper extends Mapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int countByEx(TbMemoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int deleteByEx(TbMemoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int deleteByPk(Integer memoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int insert(TbMemo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int insertSelective(TbMemo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	List<TbMemo> selectByEx(TbMemoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	TbMemo findByPk(Integer memoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int updateByExSelective(@Param("record") TbMemo record, @Param("example") TbMemoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int updateByEx(@Param("record") TbMemo record, @Param("example") TbMemoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int updateByPkSelective(TbMemo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_memo
	 * @mbggenerated  Tue Jun 24 13:51:01 JST 2014
	 */
	int updateByPk(TbMemo record);
}