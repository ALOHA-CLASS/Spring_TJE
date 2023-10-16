package com.joeun.test.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	
	private String id;
	private String name;
	private String[] hobby;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth; 
	

}
