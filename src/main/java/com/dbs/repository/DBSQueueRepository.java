package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.model.Queue;

public interface DBSQueueRepository extends JpaRepository<Queue, Integer> {

}
