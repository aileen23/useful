create table tbl_approval(	-- �������� ���̺�
	no number primary key,				-- ������ȣ
	status varchar2(15),				-- �����������
	title varchar2(100),				-- ���� ����
	content varchar2(1000),				-- ����
	writer number,						-- ����� ���
	receiver number,					-- ���źμ���ȣ (0�̸� ��ü)
	regdate date default sysdate,		-- �ۼ���
	curr_approval number,				-- �ֱ� ������ ��� (����ڿ� ���� ��� �ƹ��� �������� ���� ����)
	next_approval number,				-- ���� ������ ��� (0�̸� ���� �Ϸ�)
	filename varchar2(100)				-- ÷�������� ���ϸ� 
)

create sequence tbl_approval_seq	-- ������ȣ�� sequence
start with 1
increment by 1
nocache nocycle;