package pl.util;

import java.util.List;

import pl.model.Addon;
import pl.model.History;
import pl.model.HistoryItem;
import pl.model.Item;
import pl.model.ItemAddon;
import pl.service.AddonService;
import pl.service.DishService;
import pl.service.DrinkService;
import pl.service.PizzaService;
import pl.service.SoupService;

public class Split {
	private List<History> histories;
	private PizzaService pizzaService;
	private DishService dishService;
	private SoupService soupService;
	private DrinkService drinkService;
	private AddonService addonService;

	public Split(List<History> histories, PizzaService pizzaService, DishService dishService, SoupService soupService, DrinkService drinkService, AddonService addonService) {
		this.histories = histories;
		this.pizzaService = pizzaService;
		this.dishService = dishService;
		this.soupService = soupService;
		this.drinkService = drinkService;
		this.addonService = addonService;
	}
	
	public String[] split() {
		for (History history : histories) {
			for (HistoryItem historyItem : history.getItems()) {
				String string = historyItem.getItemString();
				string = string.replace("|", ",");
				
				String[] divided = string.split(",");
				Item item = getByTag(divided[0], divided[1]);
				
				item.getItemAddon().clear();
				
				if (divided.length > 4) {
					for (int i = 4; i < divided.length; i++) {
						Addon addon = addAddon(divided[i]);
						
						System.out.println("Addon: " +divided[i]);
						
						if (addon != null) {
							item.getItemAddon().add(addon);
						}
					}
				}
				historyItem.setItem(item);
			}
		}
		return null;
	}
	
	private Addon addAddon(String name) {
		return addonService.get(name);
	}

	public Item getByTag(String tag, String name) {
		Item item = null;
		
		switch(tag) {
			case "pizza": {
				item = pizzaService.get(name);
				break;
			}
			case "soup": {
				item = soupService.get(name);
				break;
			}
			case "drink": {
				item = drinkService.get(name);
				break;
			}
			case "dish": {
				item = dishService.get(name);
				break;
			}
		}
		return item;
	}
	
	/*
	 * 
	 * 		
		String result =  userMeasurement.getResult();

		result = result.replaceAll("\n", "");

		String[] dividedByNewLine = result.split("\r");
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		for (int i = 0; i < dividedByNewLine.length; i++) {
			
	        if(dividedByNewLine[i].isEmpty()) continue;
	        
	        arrayList.add(dividedByNewLine[i]);
		}
		
		
		String[] r = arrayList.toArray(new String[arrayList.size()]);

		model.addAttribute("list", list);
		model.addAttribute("dane", r);
		return "measurement_id";
	 */
}
