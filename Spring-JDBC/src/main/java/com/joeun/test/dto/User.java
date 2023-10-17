package com.joeun.test.dto;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String name;
	private String email;
	private Date regDate;
	private Date updDate;
}
