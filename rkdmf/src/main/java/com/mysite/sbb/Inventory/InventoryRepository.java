package com.mysite.sbb.Inventory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	Inventory findByINAQ(Integer INAQ);
	Inventory findByINAQAndINBQ(Integer INAQ, Integer INBQ);
	List<Inventory> findByININameLike(String inname);
}
