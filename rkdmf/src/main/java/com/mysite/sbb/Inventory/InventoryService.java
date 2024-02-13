package com.mysite.sbb.Inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	public List<Inventory> getList() {
		return this.inventoryRepository.findAll();
		
	}
	
	public void create(String INDate, String ININame, String INPName, Integer INQuantity, String INPNum, String INICode, String INStandard) {
		Inventory i = new Inventory();
		i.setINDate(INDate);
		i.setININame(ININame);
		i.setINPName(INPName);
		i.setINQuantity(INQuantity);
		i.setINPNum(INPNum);
		i.setINICode(INICode);
		i.setINStandard(INStandard);
		i.setCreateDate(LocalDateTime.now());
		this.inventoryRepository.save(i);
	}
	
	public Page<Inventory> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page,  10, Sort.by(sorts));
		return this.inventoryRepository.findAll(pageable);
	}
	
	//디테일
	public Inventory getInventory(Integer id) {
		Optional<Inventory> inventory = this.inventoryRepository.findById(id);
		if(inventory.isPresent()) {
			return inventory.get();
		} else {
			throw new DataNotFoundException("inventory not found");
		}
	}
} 
