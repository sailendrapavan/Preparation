package com.springmvc.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.data.DAO1;

@Service
public class Business1 {

	@Autowired
	private DAO1 dao;
	
	public String caliculate() {
	
		return dao.retriveSomething();
	}
}
