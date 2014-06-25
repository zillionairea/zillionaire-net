package net.zillions.buffett.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * カラム名
 */
public class ColName {

	/**
	 * 
	 */
	private String _colName = null;

	/**
	 * 
	 */
	private String _camelCase = null;

	/**
	 * 
	 * @param colName
	 */
	public ColName(String colName) {
		this._colName = colName;
		this._camelCase = toCamel(colName);
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return this._colName;
	}

	/**
	 * 
	 * @return
	 */
	public String toCamel() {
		return this._camelCase;
	}

	/**
	 * 
	 * @param colName
	 * @return
	 */
	private static String toCamel(String colName) {
		Pattern p = Pattern.compile("_([a-z])");
		Matcher m = p.matcher(colName.toLowerCase());
		StringBuffer sb = new StringBuffer(colName.length());
		while (m.find()) {
			m.appendReplacement(sb, m.group(1).toUpperCase());
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
