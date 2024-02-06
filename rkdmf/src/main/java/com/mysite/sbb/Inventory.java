package com.mysite.sbb;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory {
	@Id
	private String INDate;
	
	@Column(length = 10)
	private String INPName;
	
	@Column(length = 13)
	private String INPNum;
	
	@Column(length = 30)
	private String ININame;
	
	@Column(length = 11)
	private String INICode;
	
	@Column(columnDefinition = "NUMERIC(7) NOT NULL")
	private Integer INBQ;
	
	@Column(columnDefinition = "NUMERIC(7) NOT NULL")
	private Integer INAQ;
	
	@Column(length = 50)
	private String INStandard;
	
	private LocalDateTime createDate; 
	
	
}
