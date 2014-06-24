package net.zillions.buffett.client;

import net.zillions.buffett.DefaultBeanFactory;

/**
 * 
 */
public class MapperFactory {

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T extends Mapper> T getMapper(Class<T> clazz) {
		return DefaultBeanFactory.getFactory().getBean(clazz);
	}
}
