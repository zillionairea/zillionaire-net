package net.zillions.buffett.controller;

import java.lang.reflect.Method;

import org.junit.Test;

public class MemoControllerTest {

	@Test
	public void getBeginDate() throws Exception {

		Method getBeginDate = getMethod("getBeginDate");
		getBeginDate.setAccessible(true);

		Method getEndDate = getMethod("getEndDate");
		getEndDate.setAccessible(true);

		// ---------------------------------------

		String year = "2014";
		String month = null;
		String day = null;

		System.out.println(getBeginDate.invoke(new MemoController(), year, month, day));
		System.out.println(getEndDate.invoke(new MemoController(), year, month, day));

		year = "2014";
		month = "8";
		day = null;

		System.out.println(getBeginDate.invoke(new MemoController(), year, month, day));
		System.out.println(getEndDate.invoke(new MemoController(), year, month, day));

		year = "2014";
		month = "8";
		day = "14";

		System.out.println(getBeginDate.invoke(new MemoController(), year, month, day));
		System.out.println(getEndDate.invoke(new MemoController(), year, month, day));

	}

	private static Method getMethod(String methodName) {
		for (Method method : MemoController.class.getDeclaredMethods()) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		throw new IllegalArgumentException(methodName);
	}
}
