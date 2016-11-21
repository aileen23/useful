create table tbl_deptboard(
serial number primary key, --�۹�ȣ
deptno number not null, --�μ���ȣ
title varchar2(100) not null, --������
writer varchar2(100) not null, --�۾���
content varchar2(2000) not null, --����
regdate date not null, --�ۼ�����
viewcnt number , --��ȸ��
checked varchar2(10) -- ���� - �ű�/������/����/�ߴ�/�Ϸ�
);

drop table tbl_deptboard;
-- �μ���ȣ �����ϰ� �۾��� ������̺��� ����
create table tbl_deptboard(
serial number primary key, --�۹�ȣ
deptno number not null references tbl_dept(deptno), --�μ���ȣ
title varchar2(100) not null, --������
ename varchar2(100) not null references tbl_emp(ename), --�۾���
content varchar2(2000) not null, --����
regdate date not null, --�ۼ�����
viewcnt number , --��ȸ��
checked varchar2(10) -- ���� - �ű�/������/����/�ߴ�/�Ϸ�
);

create sequence tbl_deptboard_seq
 start with 1
   increment by 1
   nocycle
   nocache;
   