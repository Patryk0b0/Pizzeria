package pl.model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
	private List<String> fooList;
	
	public ItemList() {
		fooList = new ArrayList<String>();
	}

	public List<String> getFooList() {
		return fooList;
	}

	public void setFooList(List<String> fooList) {
		this.fooList = fooList;
	}
	
    public void add(String string) {
        this.fooList.add(string);
    }
}
