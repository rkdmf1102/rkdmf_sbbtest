package com.mysite.sbb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, String>{
	Inventory findByINAQ(Integer inaq);
	Inventory findByINAQAndINBQ(Integer inaq, Integer inbq);
	List<Inventory> findByININameLike(String inname);
}
