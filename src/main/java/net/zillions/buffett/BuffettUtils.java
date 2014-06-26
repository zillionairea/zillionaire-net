package net.zillions.buffett;

public final class BuffettUtils {

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDigit(String value) {
		if (value == null) {
			return false;
		}

		for (char ch : value.toCharArray()) {
			if (Character.isDigit(ch) == false) {
				return false;
			}
		}
		return true;
	}
	
	
	private BuffettUtils() {
		
	}

}
