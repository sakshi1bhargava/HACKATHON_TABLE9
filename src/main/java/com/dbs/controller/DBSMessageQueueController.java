package com.dbs.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.model.MessageQueue;
import com.dbs.model.Queue;
import com.dbs.repository.DBSMessageRepository;

@RestController
@RequestMapping("/message")
public class DBSMessageQueueController{
	
	@Autowired
	private DBSMessageRepository messageRep;
	
	@PostMapping
	public MessageQueue saveMessage(@RequestBody MessageQueue message){
		message.setCreateTime(new Timestamp(new Date().getTime()));
		return messageRep.save(message);
	}
	
	//Delete message using id
	@DeleteMapping("/deleteMessage/{id}")
	public String deleteMessage(@PathVariable("id")int id){
		messageRep.deleteById(id);
		return "{\"response\": \"succsess\"}";
	}
	
	@GetMapping("/search")
	public List<MessageQueue> search(@RequestParam("sortBy") String sortBy ){
		Sort sort = new Sort(Sort.Direction.ASC, sortBy); 
		return messageRep.findAll(sort);
	}
	//public Queue<List> saveMessage(){
}
	
