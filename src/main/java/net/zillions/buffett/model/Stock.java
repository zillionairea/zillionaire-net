package net.zillions.buffett.model;

/**
 * 
 */
public class Stock {

	private String _id = null;
	private String _name = null;

	public Stock(String id, String name) {
		this._id = id;
		this._name = name;
	}

	public String getId() {
		return this._id;
	}

	public String getName() {
		return this._name;
	}
}
