package net.zillions.buffett;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 */
public class DefaultBeanFactory implements BeanFactory {

	/**
	 * 
	 */
	private static final String PATH_APPLICATION_CONTEXT_XML = "/applicationContext.xml";

	/**
	 * 
	 */
	private static BeanFactory cache = null;

	/**
	 * 
	 */
	private ApplicationContext _context = null;

	/**
	 * 
	 */
	private DefaultBeanFactory() {
		_context = new ClassPathXmlApplicationContext(PATH_APPLICATION_CONTEXT_XML);
	}

	/**
	 * 
	 * @return
	 */
	public static BeanFactory getFactory() {
		if (cache == null) {
			cache = new DefaultBeanFactory();
		}
		return cache;
	}

	/**
	 * 
	 * @param beanId ビーンＩＤ
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanId) {
		return (T) _context.getBean(beanId);
	}

	/**
	 * 
	 * @param requiredType
	 * @return
	 */
	public <T> T getBean(Class<T> requiredType) {
		return _context.getBean(requiredType);
	}

}
