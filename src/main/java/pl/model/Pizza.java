package pl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza extends Item {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Double price;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza", fetch = FetchType.EAGER)
	private List<PizzaAddon> pizzaAddons = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<PizzaAddon> getPizzaAddons() {
		return pizzaAddons;
	}

	public void setPizzaAddons(List<PizzaAddon> pizzaAddons) {
		this.pizzaAddons = pizzaAddons;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemAddon> getItemAddon() {
		return (List<ItemAddon>)(List<?>)getPizzaAddons();
	}

}
