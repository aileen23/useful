create table tbl_lazyness(
serial number primary key, --�Ϸù�ȣ
empno number not null, -- ���
category varchar2(20) not null, -- ����
begin date , --����
term date , --�Ⱓ
etc date --���
);

drop table tbl_lazyness;
create table tbl_lazyness(
serial number primary key, --�Ϸù�ȣ
empno number not null references tbl_emp(empno), -- ���
category varchar2(20) not null, -- ����
begin date , --����
term date , --�Ⱓ
etc date --���
);

create sequence tb1_lazyness_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   