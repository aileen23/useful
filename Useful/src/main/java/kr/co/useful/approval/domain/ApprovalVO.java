package kr.co.useful.approval.domain;

import java.io.File;
import java.util.Date;

public class ApprovalVO {
	private int no;					// ������ȣ
	private String status;			// ���� ���� ����
	private String title;			// ��������
	private String content;			// ��������
	private String writer;			// ����� (���� �ۼ���)
	private Date regdate;			// �ۼ�����
	private Date enddate;			// ��������
	private String curr_approval;	// �ֱ� ������ (����ڿ� ���� ��� ���� ������)
	private String next_approval;	// ���� ������ (null�� ��� ���� �Ϸ����)
	private File addfile;			// ÷������ (�ִ� 4GB binary file ���� ����)
	private String filename;		// ÷�������� ���ϸ�

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCurr_approval() {
		return curr_approval;
	}

	public void setCurr_approval(String curr_approval) {
		this.curr_approval = curr_approval;
	}

	public String getNext_approval() {
		return next_approval;
	}

	public void setNext_approval(String next_approval) {
		this.next_approval = next_approval;
	}

	public File getAddfile() {
		return addfile;
	}

	public void setAddfile(File addfile) {
		this.addfile = addfile;
	}

	public ApprovalVO() {}
}
