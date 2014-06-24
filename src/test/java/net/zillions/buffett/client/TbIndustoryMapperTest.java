package net.zillions.buffett.client;


import java.util.List;

import net.zillions.buffett.model.TbIndustry;
import net.zillions.buffett.model.TbIndustryExample;
import net.zillions.buffett.model.TbIndustryExample.Criteria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TbIndustoryMapperTest {

//	@Autowired
//	private TbIndustryMapper mapper = null;
	
	@Test
	public void test() {
		
		TbIndustryMapper tbIndustryMapper = MapperFactory.getMapper(TbIndustryMapper.class);
		TbIndustryExample example = new TbIndustryExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andIndustryCodeLike("3%");
		example.setOrderByClause("industry_code asc");
		List<TbIndustry> selectResult = tbIndustryMapper.selectByEx(example);
		
		for (TbIndustry tbIndustry : selectResult) {
			System.out.println(tbIndustry);
		}
		
	}

}
