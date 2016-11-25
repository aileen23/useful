create table tbl_board(
serial number primary key, --�۹�ȣ
title varchar2(50) not null, --������
writer varchar2(30) not null, --�۾���
content varchar2(2000) not null, --����
regdate date not null, --�ۼ�����
viewcnt number --��ȸ��
);

drop table tbl_board;
create table tbl_board(
serial number primary key, --�۹�ȣ
title varchar2(50) not null, --������
ename varchar2(30) not null references tbl_emp(ename), --�۾���
content varchar2(2000) not null, --����
regdate date not null, --�ۼ�����
viewcnt number --��ȸ��
);

create sequence tbl_board_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   insert into tbl_board (serial,title,writer,content,regdate) values (tbl_board_seq.nextval,'�׽�Ʈ','�׽�Ʈ','�׽�Ʈ',sysdate);
   