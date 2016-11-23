package kr.co.useful.approval.service;

import java.util.List;

import kr.co.useful.approval.domain.ApprovalVO;

public interface ApprovalService {
	public void create(ApprovalVO vo) throws Exception;						// ���繮�� ���
	public void modify(ApprovalVO vo) throws Exception;						// �����ϱ� (�ݷ��� ����)
	public ApprovalVO select(int no) throws Exception;						// Ư������ ��ȸ
	public List<ApprovalVO> list(int deptno) throws Exception;				// �츮�μ�+��ü ��ȸ
	public List<ApprovalVO> list_from_me(int writer) throws Exception;		// ���� �ۼ��� ���� ��ȸ
	public List<ApprovalVO> list_approval(int next_approval)throws Exception;	// ���� ������ ���� ��ȸ
	public void do_approval(ApprovalVO vo) throws Exception;				// ����/�ݷ� �ϱ� (�ڸ�Ʈ �ޱ�)

}
