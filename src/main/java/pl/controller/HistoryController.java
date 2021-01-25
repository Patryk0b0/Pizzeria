package pl.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.model.History;
import pl.service.HistoryService;

@Controller
public class HistoryController {
	

	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/history")
	public String index(Model model) {

		model.addAttribute("list", historyService.list());
		
		return "history";
	}

}
