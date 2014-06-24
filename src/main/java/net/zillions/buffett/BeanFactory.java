package net.zillions.buffett;

/**
 * 
 */
public interface BeanFactory {

	/**
	 * 
	 * @param beanId
	 * @return
	 */
	<T> T getBean(String beanId);

	/**
	 * 
	 * @param requiredType
	 * @return
	 */
	<T> T getBean(Class<T> requiredType);
}
