package kr.co.useful.approval.persistence;

import java.util.List;

import kr.co.useful.approval.domain.ApprovalVO;

public interface ApprovalDAO {
	public void create(ApprovalVO vo) throws Exception;						// ���繮�� ���
	public void modify(ApprovalVO vo) throws Exception;						// �����ϱ� (�ݷ��� ����)
	public ApprovalVO select(int no) throws Exception;						// Ư������ ��ȸ
	public List<ApprovalVO> list(ApprovalVO vo)throws Exception;			// ���ǿ� ���� ��������Ʈ ��ȸ
	public void do_approval(ApprovalVO vo) throws Exception;				// ����/�ݷ� �ϱ� (�ڸ�Ʈ �ޱ�)
	public int getManager(int empno)throws Exception;						// ���ӻ�� ��� ���� ��ȸ
}
