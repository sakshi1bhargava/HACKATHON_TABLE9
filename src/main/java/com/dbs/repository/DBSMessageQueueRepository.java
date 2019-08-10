package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.model.MessageQueue;

@Repository
public interface DBSMessageQueueRepository extends JpaRepository<MessageQueue, Integer> {

}
