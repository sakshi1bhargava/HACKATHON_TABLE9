package com.dbs.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="dbs_queue",name="qmessages")
@NamedQuery(name="MessageQueue.findAll", query="select msg from MessageQueue msg")
public class MessageQueue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MSGQUEUE_SEQ")
    @SequenceGenerator(sequenceName = "msgQueue_seq", allocationSize = 1, name = "MSGQUEUE_SEQ")
	private Integer msgId;
	
    @Column(name = "qid")
	private Integer qId;
	
	@Column(name="message")
	private String msg;
	
	@Column(name="crte_time")
	private Timestamp createTime;

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
