create table tbl_mail(
serial integer primary key, --�Ϸù�ȣ
title varchar2(100) not null, --����
sender varchar2(100) not null, --�ۼ���
receiver varchar2(100) not null, -- �޴»��
gdate date, --��¥
content varchar2(2000), --����
attfile varchar2(2000) --÷������
);

--�ۼ��� �޴»�� ������̺�����
drop table tbl_mail;
create table tbl_mail(
serial integer primary key, --�Ϸù�ȣ
title varchar2(100) not null, --����
sender varchar2(100) not null references tbl_emp(ename), --�ۼ���
receiver varchar2(100) not null references tbl_emp(ename), -- �޴»��
gdate date, --��¥
content varchar2(2000), --����
attfile varchar2(2000) --÷������
);


create sequence tbl_mail_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
   
 