create table tbl_voteresult(
serial number, --�۹�ȣ
empno varchar2(100), --������ �������� ������
answer varchar2(50) --����
);

--����� emp���̺��� ����
create table tbl_voteresult(
serial number, --�۹�ȣ
empno varchar2(100) references tbl_emp(empno), --������ �������� ������
answer varchar2(50) --����
);
