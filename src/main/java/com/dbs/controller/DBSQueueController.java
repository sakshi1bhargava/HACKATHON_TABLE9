package com.dbs.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.model.Queue;
import com.dbs.repository.DBSQueueRepository;

@RestController
@RequestMapping("/queue")
public class DBSQueueController {
	@Autowired
	private DBSQueueRepository DBSQueueRepository;
	
	@GetMapping
	public List<Queue> getAllQueues(){
		
		List<Queue> queues = DBSQueueRepository.findAll();
		return queues;
	} 
	
	@PostMapping
	public Queue saveQueue(@RequestBody Queue queue){
		
		return DBSQueueRepository.save(queue);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteQueue(@PathVariable int id){
	
		DBSQueueRepository.deleteById(id);
		return "{\"content\":\"Deleted successfully\"}";
	}
	
	@GetMapping("/{id}")
	public String isQueueFull(@PathVariable int id){
		
		String count = DBSQueueRepository.getMsgCountInQueue(id);
		if(Integer.parseInt(count) == 10){
			return "{\"status\":\"404\",\"content\":\"Queue is full\"}";
		}else{
			return "{\"status\":\"200\",\"content\":\"Message can be added\"}";
		}
	}
}
