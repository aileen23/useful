package kr.co.useful.approval.domain;

import java.io.File;
import java.util.Date;

public class ApprovalVO {
	private int no;					// ������ȣ
	private String status;			// ���� ���� ����
	private String title;			// ��������
	private String content;			// ��������
	private int writer;				// ����� (���� �ۼ���) ���
	private String writer_name;		// ����� (���� �ۼ���) ����
	private int receiver;			// ���źμ���ȣ
	private String receiver_dname;	// ���źμ���
	private Date regdate;			// �ۼ�����
	private int curr_approval;		// �ֱ� ������ ���(����ڿ� ���� ��� ���� ������)
	private int next_approval;		// ���� ������ ���(0�� ��� ���� �Ϸ����)
	private File addfile;			// ÷������ (�ִ� 4GB binary file ���� ����)
	private String filename;		// ÷�������� ���ϸ�
	
	public ApprovalVO() {}

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

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getReceiver_dname() {
		return receiver_dname;
	}

	public void setReceiver_dname(String receiver_dname) {
		this.receiver_dname = receiver_dname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCurr_approval() {
		return curr_approval;
	}

	public void setCurr_approval(int curr_approval) {
		this.curr_approval = curr_approval;
	}

	public int getNext_approval() {
		return next_approval;
	}

	public void setNext_approval(int next_approval) {
		this.next_approval = next_approval;
	}

	public File getAddfile() {
		return addfile;
	}

	public void setAddfile(File addfile) {
		this.addfile = addfile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}