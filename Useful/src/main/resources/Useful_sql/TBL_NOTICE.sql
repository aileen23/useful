create table tbl_notice(
serial integer primary key, --�۹�ȣ
title varchar2(50) not null, --������
writer varchar2(20) not null, --�۾���
content varchar2(2000), --����
regdate date not null--�ۼ�����
);

-- �۾��̰� �ƹ��̸� ������ ������̺� �����ؼ� ��� �Ϸ��� �ۼ�
drop table tbl_notice;
create table tbl_notice(
serial integer primary key, --�۹�ȣ
title varchar2(50) not null, --������
ename varchar2(20) not null references tbl_emp(ename), --�۾���
content varchar2(2000), --����
regdate date not null--�ۼ�����
);

create sequence tbl_notice_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   