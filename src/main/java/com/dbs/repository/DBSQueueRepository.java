package com.dbs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.model.Queue;

@Repository
public interface DBSQueueRepository extends JpaRepository<Queue, Integer> {
	
	@Query(value="select m.count(*) from queues q ,qmessages m where m.qid = q.qid and q.qid = :id",nativeQuery = true)
	String getMsgCountInQueue(@Param("id") int id);
	

}
