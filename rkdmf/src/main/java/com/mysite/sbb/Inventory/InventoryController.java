package com.mysite.sbb.Inventory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/inventory")
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
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
		Page<Inventory> paging = this.inventoryService.getList(page, kw);
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
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
	
	
	@GetMapping("/create")
	public String inventoryCreate(InventoryForm inventoryForm){
		return "inventory_form";
	}
	
	
	@PostMapping("/create")
	public String inventoryCreate(@Valid InventoryForm inf, BindingResult br) {
		if (br.hasErrors()) {
			return "inventory_form"; 
		}
		this.inventoryService.create(inf.getINDate(),inf.getININame(),inf.getINPName(),inf.getINQuantity(),inf.getINPNum(),inf.getINICode(),inf.getINStandard());
		return "redirect:/inventory/list";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Inventory inventory = this.inventoryService.getInventory(id);
		model.addAttribute("inventory", inventory);
		return "inventory_detail";
	}
    
	@GetMapping("/modify/{id}")
	public String inventoryModify(InventoryForm inf, @PathVariable("id") Integer id) {
		Inventory inventory = this.inventoryService.getInventory(id);
		inf.setINDate(inventory.getINDate());
		inf.setINICode(inventory.getINICode());
		inf.setININame(inventory.getININame());
		inf.setINPName(inventory.getINPName());
		inf.setINPNum(inventory.getINPNum());
		inf.setINQuantity(inventory.getINQuantity());
		inf.setINStandard(inventory.getINStandard());
		return "inventory_form";
	}
	
	@PostMapping("/modify/{id}")
    public String inventoryModify(@Valid InventoryForm inf, BindingResult br, @PathVariable("id") Integer id) {
        if (br.hasErrors()) {
            return "inventory_form";
        }
        Inventory inventory = this.inventoryService.getInventory(id); {
       
        this.inventoryService.modify(inventory, inf.getINDate(),inf.getININame(),inf.getINPName(),inf.getINQuantity(),inf.getINPNum(),inf.getINICode(),inf.getINStandard());
        return String.format("redirect:/inventory/detail/%s", id);
    
        }
	}
	
	@GetMapping("/delete/{id}")
    public String inventoryDelete(@PathVariable("id") Integer id) {
		Inventory inventory = this.inventoryService.getInventory(id);
      
        this.inventoryService.delete(inventory);
        return "redirect:/";
    }
}
                  