DROP TABLE TBL_SHARETASK;
CREATE TABLE TBL_SHARETASK(
BNO NUMBER PRIMARY KEY,
CATEGORY VARCHAR2(500) NOT NULL,
TITLE VARCHAR2(500) NOT NULL,
CONTENT VARCHAR2(1000) NOT NULL,
WRITER NUMBER,
REGDATE DATE DEFAULT SYSDATE,
VIEWCNT NUMBER,
DEPTNO NUMBER
);
CREATE SEQUENCE TBL_SHARETASK_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;