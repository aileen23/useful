package kr.co.useful.approval.service;

import java.util.List;
import java.util.Map;

import kr.co.useful.approval.domain.ApprovalProgressVO;
import kr.co.useful.approval.domain.ApprovalVO;

public interface ApprovalService {
	public void create(ApprovalVO vo) throws Exception;						// ���繮�� ���
	public void update(ApprovalVO vo) throws Exception;						// �����ϱ� (�ݷ��� ����)
	public ApprovalVO select(int no) throws Exception;						// Ư������ ��ȸ
	public List<ApprovalVO> list(ApprovalVO vo)throws Exception;			// ���ǿ� ���� ���� ����Ʈ ��ȸ
	public List<ApprovalVO> listStatus(Map<String, Object> map)
											throws Exception;				// �츮�μ������� ���� �������� ���� ��ȸ
	public void do_approval(ApprovalVO vo,ApprovalProgressVO progressVO)
											throws Exception;				// ����/�ݷ� �ϱ� (�ڸ�Ʈ �ޱ�)
	public int getMyDeptno(int empno) throws Exception;						// �ڽ��� �μ���ȣ ��ȸ
	public String getDname(int deptno) throws Exception;					// Ư���μ���ȣ�� �μ��� ��ȸ

}
