package kr.co.useful.approval.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.useful.approval.domain.ApprovalRestVO;
import kr.co.useful.approval.domain.ApprovalVO;
import kr.co.useful.approval.persistence.ApprovalDAO;
import kr.co.useful.approval.persistence.ApprovalRestDAO;

@Service
public class ApprovalServiceImpl implements ApprovalService{

	@Inject
	private ApprovalDAO dao;
	@Inject
	private ApprovalRestDAO restdao;
	
	public void create(ApprovalVO vo) throws Exception {
		vo.setCurr_approval(vo.getWriter());			// �ۼ��ڸ� �ֱ� �����ڷ� ����
		
		// ���� �����ڰ� �ִ��� Ȯ��
		ApprovalRestVO restVO = new ApprovalRestVO(); 
		restVO.setDeptno(vo.getReceiver());				
		restVO.setEmpno(vo.getWriter());
		if(restdao.getLine(restVO).size()>0){		// ���� �����ڰ� ������ ���� �����ڷ� ���ӻ�� ����
			vo.setNext_approval(dao.getManager(vo.getWriter()));
			vo.setStatus("����");
		}
		else{
			vo.setNext_approval(vo.getWriter());	// ���� �����ڰ� ������ �ۼ��ڰ� ���� �����ڰ� ��
			vo.setStatus("�Ϸ�");
		}
		System.out.println(vo.toString());
		dao.create(vo);
	}


	public void modify(ApprovalVO vo) throws Exception {
		
	}


	public List<ApprovalVO> list(int deptno) throws Exception {
		return null;
	}


	public List<ApprovalVO> list_from_me(int writer) throws Exception {

		return null;
	}


	public List<ApprovalVO> list_approval(int next_approval) throws Exception {

		return null;
	}

	public void do_approval(ApprovalVO vo) throws Exception {
		
	}

	public ApprovalVO select(int no) throws Exception {
		return null;
	}

}
