package kr.co.useful.sharetask.domain;

import java.util.Date;

public class ReplyVO {
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	
	public ReplyVO() {
	
	}
	
	@Override
	public String toString() {
		return "ReplyVO [��۹�ȣ=" + rno + ", �Խù���ȣ=" + bno + ", ����=" + replytext + ", �ۼ���=" + replyer
				+ ", �ۼ�����=" + regdate + ", ��������=" + updatedate + "]";
	}

	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

}
