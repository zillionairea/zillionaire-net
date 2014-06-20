package net.zillions.buffett.model;

import java.util.ArrayList;
import java.util.List;

public class Industory {

	private String _id = null;
	private String _name = null;
	private List<Stock> _stockList = null;

	public Industory(String id, String name) {
		this._id = id;
		this._name = name;
		this._stockList = new ArrayList<>();
	}

	public String getId() {
		return this._id;
	}

	public String getName() {
		return this._name;
	}

	public List<Stock> getStockList() {
		return this._stockList;
	}
	
	public void addStock(Stock stock) {
		this._stockList.add(stock);
	}
}
