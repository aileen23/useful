drop table tbl_recipient_note;
create table tbl_recipient_note(
serial number, --�޽��� ��ȣ ��
mynote varchar2(20), --�� ���̵�� ����� ������ȸ�Ҷ�
reciid varchar2(20), -- ������� ���̵�
recontent varchar2(2000), -- ���� ����
recipientdate date default sysdate -- ������¥
);
select * from tbl_recipient_note;
drop sequence tbl_recipient_note_seq;
create sequence tbl_recipient_note_seq;

select empno,ename,pass from tbl_emp;