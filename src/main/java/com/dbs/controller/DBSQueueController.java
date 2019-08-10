package com.dbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.model.Queue;
import com.dbs.repository.DBSQueueRepository;

@RestController
@RequestMapping("queue")
public class DBSQueueController {
	@Autowired
	private DBSQueueRepository DBSQueueRepository;
	
	@GetMapping
	public List<Queue> getAllQueues(){
		
		List<Queue> queues = DBSQueueRepository.findAll();
		
		return queues;
	}
	
}
