package kr.co.useful.approval.domain;

public class ApprovalProgressVO {
	private int no;			// ���繮����ȣ
	private int empno;		// ������ ���
	private String position;// ������ ��å
	private String ename;	// ������ ����
	private int deptno; 	// �������� �μ���ȣ
	private boolean sign;	// ���翩��
	
	public ApprovalProgressVO() {}
	
	public ApprovalProgressVO(int no, int empno, String position,String ename, int deptno, boolean sign) {
		this.no=no;				this.empno = empno;
		this.ename = ename;		this.deptno = deptno;
		this.sign = sign;		this.position=position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
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
