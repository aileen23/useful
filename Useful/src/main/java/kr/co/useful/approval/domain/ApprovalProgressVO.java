package kr.co.useful.approval.domain;

public class ApprovalProgressVO {
	private int empno;		// ������ ���
	private String ename;	// ������ ����
	private boolean sign;	// ���翩��
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
}
