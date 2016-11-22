create table tbl_approval(	-- �������� ���̺�
	no number primary key,	-- ������ȣ
	status varchar2(15),	-- �����������
	title varchar2(100),	-- ���� ����
	content varchar2(1000),	-- ����
	writer varchar2(15),	-- �����
	regdate date default sysdate,	-- �ۼ���
	enddate date,					-- ���縶����
	curr_approval varchar2(15),		-- ������� �Ϸ�� ���缱 (����ڿ� ���� ��� �ƹ��� �������� ���� ����)
	next_approval varchar2(15),		-- ���� ������ (null�̸� ���� �Ϸ�)
	addfile blob					-- ÷������ (blob : �ִ� 4GB�� binary ���� ����)
)

create sequence tbl_approval_seq	-- ������ȣ�� sequence
start with 1
increment by 1
nocache nocycle;