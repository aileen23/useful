create table tbl_vote(
serial number primary key, --�۹�ȣ
title varchar2(50) not null, --������
writer varchar2(50) not null, --�۽���
content varchar2(2000) not null, --������
regdate date not null --�ۼ�����
);

drop table tbl_vote;
create table tbl_vote(
serial number primary key, --�۹�ȣ
title varchar2(50) not null, --������
ename varchar2(50) not null references tbl_emp(ename), --�۽���
content varchar2(2000) not null, --������
regdate date not null --�ۼ�����
);

create sequence tbl_vote_seq
 start with 1
   increment by 1
   nocycle
   nocache;
   