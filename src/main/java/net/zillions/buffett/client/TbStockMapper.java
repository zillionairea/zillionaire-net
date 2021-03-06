package net.zillions.buffett.client;

import java.util.List;
import net.zillions.buffett.model.TbStock;
import net.zillions.buffett.model.TbStockExample;
import org.apache.ibatis.annotations.Param;

public interface TbStockMapper extends Mapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int countByEx(TbStockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int deleteByEx(TbStockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int deleteByPk(Integer stockId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int insert(TbStock record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int insertSelective(TbStock record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	List<TbStock> selectByEx(TbStockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	TbStock findByPk(Integer stockId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByExSelective(@Param("record") TbStock record, @Param("example") TbStockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByEx(@Param("record") TbStock record, @Param("example") TbStockExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByPkSelective(TbStock record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tb_stock
	 * @mbggenerated  Tue Jun 24 18:59:38 JST 2014
	 */
	int updateByPk(TbStock record);
}