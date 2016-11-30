package kr.co.useful.approval.domain;

import java.util.Date;

public class ApprovalCommentVO {
	private int cno;			// �ڸ�Ʈ ��ȣ
	private int no;				// ���� ���繮����ȣ
	private int writer;			// �ڸ�Ʈ �ۼ��� ���
	private String writer_name;	// �ڸ�Ʈ �ۼ��� ����
	private String comments;	// �ڸ�Ʈ ����
	private String checked;		// �ڸ�Ʈ �ۼ���� ���� (����/�ݷ�)
	private Date regdate;		// �ڸ�Ʈ �ۼ��ð�
	
	public ApprovalCommentVO() {}
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
