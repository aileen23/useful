create table tbl_reservation(
serial number primary key, --�Ϸù�ȣ
roomno number not null, --ȸ�ǽǹ�ȣ
begin date not null, --���۽ð�
end date not null, --����ð�
booker varchar2(50), --������
checked varchar2(20) --���α���
);

--�����ڸ� ����� ���̺��� �ܷ�Ű ����
drop table tbl_reservation;
create table tbl_reservation(
serial number primary key, --�Ϸù�ȣ
roomno number not null, --ȸ�ǽǹ�ȣ
begin date not null, --���۽ð�
end date not null, --����ð�
ename varchar2(50) references tbl_emp(ename), --������
checked varchar2(20) --���α���
);

create sequence tbl_reservation_seq
  start with 1
   increment by 1
   nocycle
   nocache;
   