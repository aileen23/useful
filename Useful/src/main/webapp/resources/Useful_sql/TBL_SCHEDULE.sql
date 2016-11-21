create table tbl_schedule(
serial integer primary key, --�۹�ȣ
category varchar2(20) not null, --���� -�μ�,��ü
deptno integer not null, --�μ���ȣ
title varchar2(50) not null, --����
content varchar2(2000), --�۳���
begin date not null, --���� �ð�
end date not null --����ð�
);

--�μ���ȣ �ܷ�Ű ���
drop table tbl_schedule;
create table tbl_schedule(
serial integer primary key, --�۹�ȣ
category varchar2(20) not null, --���� -�μ�,��ü
deptno integer not null references tbl_dept(deptno), --�μ���ȣ
title varchar2(50) not null, --����
content varchar2(2000), --�۳���
begin date not null, --���� �ð�
end date not null --����ð�
);

create sequence tbl_schedule_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   