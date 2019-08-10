package com.dbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbs.model.MessageQueue;
import com.dbs.model.Queue;

@Repository
public interface DBSQueueRepository extends JpaRepository<Queue, Integer> {
	

}
