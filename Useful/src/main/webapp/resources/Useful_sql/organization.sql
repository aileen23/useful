-- �������(tbl_emp) ���� ������ ����
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1000, '�̱���', '1111','121212-1234567','010-123-4567','���������',sysdate, 0, '����',null, 30,'123456-7890123','�ѱ�����');
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1001, 'äȿ��', '1111','121212-1234567','010-123-4567','���������',sysdate, 10, '����',null, 30,'123456-7890123','�ѱ�����');
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1002, '������', '1111','121212-1234567','010-123-4567','���������',sysdate, 10, '�븮',null, 30,'123456-7890123','�ѱ�����');
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1003, '�ȼ���', '1111','121212-1234567','010-123-4567','���������',sysdate, 10, '���',null, 30,'123456-7890123','�ѱ�����');
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1004, '�̴��', '1111','121212-1234567','010-123-4567','���������',sysdate, 10, '���',null, 30,'123456-7890123','�ѱ�����');
insert into tbl_emp (empno, ename, pass, ssn, phone, address, hiredate, deptno, position, manager, leave, account, bank)
values (1005, '������', '1111','121212-1234567','010-123-4567','���������',sysdate, 10, '���',null, 30,'123456-7890123','�ѱ�����');
-- �÷� ������ ũ�� ����
alter table tbl_emp modify (ssn varchar2(15));
alter table tbl_emp modify (phone varchar2(15));
alter table tbl_emp modify (bank varchar2(15));
alter table tbl_emp modify (address varchar2(100));
alter table tbl_position modify (position varchar2(20));
-- ��å ���̺�(tbl_position) ���õ����� ����
insert into tbl_position values ('����', 0);
insert into tbl_position values ('����', 10);
insert into tbl_position values ('�븮', 20);
insert into tbl_position values ('���', 30);
-- �μ����̺� (tbl_dept) ���õ����� ����
insert into tbl_dept values (10,'������');
insert into tbl_dept values (20,'����');
insert into tbl_dept values (30,'������');
insert into tbl_dept values (40,'��������');