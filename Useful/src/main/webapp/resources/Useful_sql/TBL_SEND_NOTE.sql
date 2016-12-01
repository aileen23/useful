drop table tbl_send_note;
create table tbl_send_note(
serial number, --메시지 수
mynote varchar2(20), -- 나의 메일내역조회
sendman varchar2(20), --받는사람 아이디
sendcontent varchar2(2000), --보낸 내용
senddate date default sysdate --보낸날짜
);

create sequence tbl_send_note_seq;