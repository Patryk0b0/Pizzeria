package pl.model;

import java.util.List;

public abstract class Item {
	public abstract Integer getId();
	public abstract String getName();
	public abstract Double getPrice();
	public abstract List<ItemAddon> getItemAddon();
}
