create table tbl_approval_comment(		-- ����� �Է��� �ڸ�Ʈ ���̺�
	cno number primary key,		-- �ڸ�Ʈ ��ȣ
	no number,					-- ���� ���繮�� ��ȣ
	writer number,				-- �ڸ�Ʈ �ۼ��� ���
	comments varchar2(400),		-- �ڸ�Ʈ ����
	regdate date default sysdate -- �ڸ�Ʈ �ۼ� �ð�
);


create sequence tbl_approval_comment_seq	-- �ڸ�Ʈ ��ȣ �Է¿� sequence
start with 1
increment by 1
nocache nocycle;
