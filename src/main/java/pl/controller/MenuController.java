package pl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import pl.model.History;
import pl.model.HistoryItem;
import pl.model.ItemList;
import pl.service.DishService;
import pl.service.DrinkService;
import pl.service.HistoryItemService;
import pl.service.HistoryService;
import pl.service.PizzaService;
import pl.service.SoupService;
import pl.util.Mail;

@Controller
public class MenuController {
	
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
	
	@GetMapping("/menu")
	public String index(Model model) {
		System.out.println("Test: " + pizzaService.list().size());
		
		model.addAttribute("pizzas", pizzaService.list());
		model.addAttribute("dishes", dishService.list());
		model.addAttribute("soups", soupService.list());
		model.addAttribute("drinks", drinkService.list());
		
		System.out.println(pizzaService.get("Margheritta"));
		
		return "menu";
	}
	
	@PostMapping("/menu")
	public String index(@RequestParam("item") String[] list, @RequestParam("user-name") String name, @RequestParam("user-surname") String surname, @RequestParam("user-mail") String mail) {
		Integer id = historyService.save(list, name, surname, mail);

		for (String itemString : list) {
			historyItemService.save(id, itemString);
		}

		Mail.send(Mail.mailFormat(historyService.get(id)), mail);
		
		return "redirect:/history";
	}
}
