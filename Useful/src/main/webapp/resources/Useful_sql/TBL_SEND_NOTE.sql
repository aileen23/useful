drop table tbl_send_note;
create table tbl_send_note(
serial number, --�޽��� ��
mynote varchar2(20), -- ���� ���ϳ�����ȸ
sendman varchar2(20), --�޴»�� ���̵�
sendcontent varchar2(2000), --���� ����
senddate date default sysdate --������¥
);

create sequence tbl_send_note_seq;