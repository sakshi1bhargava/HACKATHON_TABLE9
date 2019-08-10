create table queues (qid bigint(10) primary key, qname varchar(50));

create table qmessages(msg_id bigint(10) primary key, qid bigint(10), message varchar(256),crte_time timestamp);

INSERT INTO `queues` (`qid`, `qname`) VALUES
(1, 'Queue1');

INSERT INTO `qmessages` (`msg_id`, `qid`, `message`, `crte_time`) VALUES
(1, 1, 'test msg 1', '2019-08-10 05:57:07'),
(2, 1, 'test msg 2', '2019-08-10 05:57:25');
