package com.mysite.sbb.Inventory;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	public List<Inventory> getList() {
		return this.inventoryRepository.findAll();
		
	}
	
	public void create(String INDate, String ININame, String INPName, Integer INAQ, Integer INBQ, String INPNum, String INICode, String INStandard) {
		Inventory i = new Inventory();
		i.setINDate(INDate);
		i.setININame(ININame);
		i.setINPName(INPName);
		i.setINAQ(INAQ);
		i.setINBQ(INBQ);
		i.setINPNum(INPNum);
		i.setINICode(INICode);
		i.setINStandard(INStandard);
		i.setCreateDate(LocalDateTime.now());
		this.inventoryRepository.save(i);
	}
}
