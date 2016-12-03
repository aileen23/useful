package kr.co.useful.approval.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kr.co.useful.approval.domain.ApprovalCriteria;
import kr.co.useful.approval.domain.ApprovalProgressVO;
import kr.co.useful.approval.domain.ApprovalVO;

public interface ApprovalService {
	public void create(ApprovalVO vo, MultipartFile file, String path)
																throws Exception;	// ���繮�� ���
	public void update(ApprovalVO vo) throws Exception;								// �����ϱ� (�ݷ��� ����)
	public void delete(int no) throws Exception;									// �����ϱ� (�ݷ��� ����)
	public ApprovalVO select(int no) throws Exception;								// Ư������ ��ȸ
	public List<ApprovalVO> list(ApprovalVO vo, ApprovalCriteria cri)
																throws Exception;	// ���ǿ� ���� ���� ����Ʈ ��ȸ
	public List<ApprovalVO> listStatus(Map<String, Object> map,
										ApprovalCriteria cri) 	throws Exception;	// �츮�μ������� ���� �������� ���� ��ȸ
	public void do_approval(ApprovalVO vo,ApprovalProgressVO progressVO)
																throws Exception;	// ����/�ݷ� �ϱ� (�ڸ�Ʈ �ޱ�)
	public int getMyDeptno(int empno) throws Exception;								// �ڽ��� �μ���ȣ ��ȸ
	public int listCount(ApprovalVO vo, ApprovalCriteria cri)	throws Exception;	// ���ǿ� ���� ���� ����Ʈ ��ȸ
	public int listStatusCount(Map<String, Object> map, ApprovalCriteria cri)	throws Exception;	// �츮�μ������� ���� �������� ���� ��ȸ
}
