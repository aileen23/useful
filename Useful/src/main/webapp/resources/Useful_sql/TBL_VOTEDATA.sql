

create table tbl_votedate(
serial number, -- �۹�ȣ
question varchar2(50), --����
regdate date not null --�ۼ���
);

create sequence tbl_votedate_seq
 start with 1
   increment by 1
   nocycle
   nocache;
   