create table queues (qid bigint(10) primary key, qname varchar(50));

create table qmessages(msg_id bigint(10) primary key, qid bigint(10), message varchar(256),crte_time timestamp);

CREATE SEQUENCE queue_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 2
  INCREMENT BY 1;
  
 CREATE SEQUENCE msgQueue_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 3
  INCREMENT BY 1;

INSERT INTO `queues` (`qid`, `qname`) VALUES
(1, 'Queue1');

INSERT INTO `qmessages` (`msg_id`, `qid`, `message`, `crte_time`) VALUES
(1, 1, 'test msg 1', '2019-08-10 05:57:07'),
(2, 1, 'test msg 2', '2019-08-10 05:57:25');
