package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.model.Queue;
import com.dbs.repository.DBSMessageRepository;

@RestController
@RequestMapping("/message")
public class DBSMessageQueueController{
	
	@Autowired
	private DBSMessageRepository messageservice;
	
	@DeleteMapping("/deleteQueue/{qId}")
	public String deleteMessage(@PathVariable("id")int id){
		messageservice.deleteById(id);
		return "response: succsess";
	}
	
	//public Queue<List> saveMessage(){
}
	
