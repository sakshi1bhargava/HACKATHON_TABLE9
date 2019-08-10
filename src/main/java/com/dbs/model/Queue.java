package com.dbs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="dbs_queue",name="queues")
@NamedQuery(name="Queue.findAll", query="select q from Queue q")
public class Queue implements Serializable{

	/**
	 *  Generated Serial ID for Queue
	 */
	private static final long serialVersionUID = 3010705346235174955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUEUE_SEQ")
    @SequenceGenerator(sequenceName = "queue_seq", allocationSize = 1, name = "QUEUE_SEQ")
	private Integer qID;
	
	@Column(name="qname")
	private String qName;
	
	@OneToMany
    @JoinColumn(name = "qid")
	private List<MessageQueue> msgQueueLst;


	public List<MessageQueue> getMsgQueueLst() {
		return msgQueueLst;
	}

	public void setMsgQueueLst(List<MessageQueue> msgQueueLst) {
		this.msgQueueLst = msgQueueLst;
	}

	public Integer getQID() {
		return qID;
	}

	public void setQID(Integer qID) {
		this.qID = qID;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}
	
	@Override
	public String toString(){
		return "Queue["+qName+"] with ID "+qID;
	}
	
}
