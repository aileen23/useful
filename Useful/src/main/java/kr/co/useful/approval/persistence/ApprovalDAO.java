package kr.co.useful.approval.persistence;

import java.util.List;
import java.util.Map;

import kr.co.useful.approval.domain.ApprovalCriteria;
import kr.co.useful.approval.domain.ApprovalVO;

public interface ApprovalDAO {
	public void create(ApprovalVO vo) throws Exception;				// ���繮�� ���
	public void update(ApprovalVO vo) throws Exception;				// �����ϱ� (�ݷ��� ����)
	public void delete(int no) throws Exception;					// �����ϱ� (�ݷ��� ����)
	public ApprovalVO select(int no) throws Exception;				// Ư������ ��ȸ
	public List<ApprovalVO> list(ApprovalVO vo, ApprovalCriteria cri)
											throws Exception;		// ���ǿ� ���� ��������Ʈ ��ȸ
	public List<ApprovalVO> listStatus(Map<String, Object> map, ApprovalCriteria cri)
											throws Exception;		// �츮�μ������� ���� �������� ���� ��ȸ
	public int listCount(ApprovalVO vo, ApprovalCriteria cri)
											throws Exception;		// ���ǿ� ���� ��������Ʈ�� ������ȸ
	public int listStatusCount(Map<String, Object> map, ApprovalCriteria cri)
											throws Exception;		// �츮�μ������� ���� �������� ������ ���� ��ȸ
	public void change_approval(ApprovalVO vo) throws Exception;	// ����(����/�ݷ�)�� ���� ������ ���� ����
	public void change_status(ApprovalVO vo) throws Exception;		// ����(����/�ݷ�)�� ���� ����������� ����
	public int getManager(int empno)throws Exception;				// ���ӻ�� ��� ���� ��ȸ
	public int getMyDeptno(int empno) throws Exception;				// �ڽ��� �μ���ȣ ��ȸ
	public String getDname(int deptno) throws Exception;			// Ư�� �μ���ȣ�� �μ��� ��ȸ
	
	// ������������ ����Ʈ ��ȸ
	public List<ApprovalVO> listMyTurn_forMain(int empno) throws Exception;
	public List<ApprovalVO> listMine_forMain(int empno) throws Exception;
	
}
