drop table tbl_emp;

create table tbl_emp(
empno integer primary key, --���
ename varchar2(10) not null, --�����
pass varchar2(20) not null, -- ��й�ȣ
ssn varchar2(15) not null,   --�ֹι�ȣ
phone varchar2(15),          --��
address varchar2(100),        --���ּ�
hiredate Date not null,      --�Ի���
deptno integer ,          --�μ���ȣ
position varchar2(10),       --��å
manager varchar2(10),        --���
leave double,               --�ܿ�������
account varchar2(20) not null, --�޿�����
bank varchar2(15) not null,  -- ����
sign varchar2(20)           --�����̹���
);

---------------------------
create table tbl_emp(
empno integer primary key, --���
ename varchar2(10) not null, --�����
pass varchar2(20) not null, -- ��й�ȣ
ssn varchar2(13) not null,   --�ֹι�ȣ
phone varchar2(11),          --��
address varchar2(50),        --���ּ�
hiredate Date not null,      --�Ի���
deptno integer references tbl_dept(deptno),          --�μ���ȣ
position varchar2(10) references tbl_levelpay(position),       --��å
manager varchar2(10),        --���
leave integer,               --�ܿ�������
account varchar2(20) not null, --�޿�����
bank varchar2(10) not null,  -- ����
sign varchar2(20)           --�����̹���
);
