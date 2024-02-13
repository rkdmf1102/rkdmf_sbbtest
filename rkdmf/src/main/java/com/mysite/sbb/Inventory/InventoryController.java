package com.mysite.sbb.Inventory;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class InventoryController {
//	private final InventoryRepository inventoryRepositiry;
//	
//	@GetMapping("/inventory/list")
//	public String list(Model model) {
//		List<Inventory> inventoryList = this.inventoryRepositiry.findAll();
//		model.addAttribute("inventoryList", inventoryList);
//		return "inventory_list";
	
	
	private final InventoryService inventoryService;
	
	@GetMapping("/inventory/list")
	public String list(Model model) {
		List<Inventory> inventoryList = this.inventoryService.getList();
		model.addAttribute("inventoryList", inventoryList);
		return "inventory_list";
	}
	
//	@GetMapping("/inventory/create")
//	public String inventoryCreate(){
//		return "inventory_form";
//	}
//	
//	@PostMapping("/inventory/create")
//	public String inventoryCreate(@RequestParam(value="INDate") String INDate,@RequestParam(value="INPName") String INPName,@RequestParam(value="INPNum") String INPNum,@RequestParam(value="ININame") String ININame,@RequestParam(value="INICode") String INICode,@RequestParam(value="INBQ") Integer INBQ,@RequestParam(value="INAQ") Integer INAQ,@RequestParam(value="INStandard") String INStandard) {
//		this.inventoryService.create(INDate, ININame, INPName, INAQ, INBQ, INPNum, INICode, INStandard);
//		return "redirect:/inventory/list";
//	}
	
	
	@GetMapping("/inventory/create")
	public String inventoryCreate(InventoryForm inventoryForm){
		return "inventory_form";
	}
	
	
	@PostMapping("/inventory/create")
	public String inventoryCreate(@Valid InventoryForm inf, BindingResult br) {
		if (br.hasErrors()) {
			return "inventory_form"; 
		}
		this.inventoryService.create(inf.getINDate(),inf.getININame(),inf.getINPName(),inf.getINAQ(),inf.getINBQ(),inf.getINPNum(),inf.getINICode(),inf.getINStandard());
		return "redirect:/inventory/list";
	}
}
                  