package pl.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.model.History;
import pl.service.AddonService;
import pl.service.DishService;
import pl.service.DrinkService;
import pl.service.HistoryItemService;
import pl.service.HistoryService;
import pl.service.PizzaService;
import pl.service.SoupService;
import pl.util.Split;

@Controller
public class HistoryController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DishService dishService;
	
	@Autowired
	private SoupService soupService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private HistoryItemService historyItemService;
	
	@Autowired
	private AddonService addonService;
	
	@GetMapping("/history")
	public String index(Model model) {
		List<History> histories = historyService.list();
		new Split(histories, pizzaService, dishService, soupService, drinkService, addonService).split();
		
		System.out.println(histories.get(0).getItems().get(0).getItem().getItemAddon().size());

		model.addAttribute("list", histories);
		
		return "history";
	}

}
