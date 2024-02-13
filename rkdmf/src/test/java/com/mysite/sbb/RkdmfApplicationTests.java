package com.mysite.sbb;

import java.time.LocalDateTime;

//import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.Inventory.Inventory;
import com.mysite.sbb.Inventory.InventoryRepository;


@SpringBootTest
class RkdmfApplicationTests {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Test
	void testJpa() {
		Inventory inv1 = new Inventory();
		inv1.setCreateDate(LocalDateTime.now());
		inv1.setINAQ(99);
		inv1.setINBQ(99);
		inv1.setINDate("240206-011");
		inv1.setINICode("IG-A01");
		inv1.setININame("다이소");
		inv1.setINPName("김가을");
		inv1.setINPNum("2401011111234");
		inv1.setINStandard("규격");
		this.inventoryRepository.save(inv1);
		
		Inventory inv2 = new Inventory();
		inv2.setCreateDate(LocalDateTime.now());
		inv2.setINAQ(999);
		inv2.setINBQ(999);
		inv2.setINDate("240912-066");
		inv2.setINICode("IG-A99");
		inv2.setININame("이마트");
		inv2.setINPName("김하늘");
		inv2.setINPNum("2405054561238");
		inv2.setINStandard("규격2");
		this.inventoryRepository.save(inv2);
		
		
		
		
//		Optional<Inventory> oi = this.inventoryRepository.findById("240101-001");
//		if(oi.isPresent()) {
//			Inventory i = oi.get();
//			assertEquals(123, i.getIN_AQ());
//		}
		
		
//		Inventory i = this.inventoryRepository.findByINAQ(123);
//		assertEquals("240101-001", i.getINDate());
//		
//		Inventory i = this.inventoryRepository.findByINAQAndINBQ(123, 100);
//		assertEquals("240101-001", i.getINDate());
		
//		List<Inventory> iList = this.inventoryRepository.findByININameLike("김%");
//		Inventory i = iList.get(0);
//		assertEquals("김가을", i.getININame());
		
//		Optional<Inventory> oi = this.inventoryRepository.findById("240206-011");
//		assertTrue(oi.isPresent());
//		Inventory i = oi.get();
//		i.setINAQ(700);
//		this.inventoryRepository.save(i);
		
//		assertEquals(2, this.inventoryRepository.count());
//        Optional<Inventory> oi = this.inventoryRepository.findById(1);
//        assertTrue(oi.isPresent());
//        Inventory i = oi.get();
//        this.inventoryRepository.delete(i);
//        assertEquals(1, this.inventoryRepository.count());
	}
}
