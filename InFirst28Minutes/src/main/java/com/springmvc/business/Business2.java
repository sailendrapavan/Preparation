package com.springmvc.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.data.DAO2;

@Service
public class Business2 {

	@Autowired
	private DAO2 dao;
	
	public String caliculate() {
	
		return dao.retriveSomething();
	}
}
