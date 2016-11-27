package kr.co.useful.approval.persistence;

import java.util.List;

import kr.co.useful.approval.domain.ApprovalRestVO;

public interface ApprovalRestDAO {
	// Ÿ�μ� �̸� ������
	public List<ApprovalRestVO> getDept(int deptno) throws Exception;
	// ���缱 ������
	public List<ApprovalRestVO> getLine(ApprovalRestVO vo) throws Exception;
}
