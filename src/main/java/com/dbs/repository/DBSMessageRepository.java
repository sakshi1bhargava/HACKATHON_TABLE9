package com.dbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.model.MessageQueue;

@Repository
public interface DBSMessageRepository extends JpaRepository<MessageQueue,Integer>{

	
	@Query(value = "SELECT m.msg_id,m.qid,m.message,m.crte_time from qmessages m "
			+ "where m.message like :msgStr", 
			  nativeQuery = true)
	List<MessageQueue> searchByMsg(@Param("msgStr")String msgToSearch);
}
