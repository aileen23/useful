package kr.co.useful.approval.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.useful.approval.domain.ApprovalCommentVO;
import kr.co.useful.approval.domain.ApprovalProgressVO;
import kr.co.useful.approval.domain.ApprovalRestVO;
import kr.co.useful.approval.domain.ApprovalVO;
import kr.co.useful.approval.persistence.ApprovalCommentDAO;
import kr.co.useful.approval.persistence.ApprovalDAO;
import kr.co.useful.approval.persistence.ApprovalRestDAO;

@Service
public class ApprovalServiceImpl implements ApprovalService{

	@Inject
	private ApprovalDAO dao;
	@Inject
	private ApprovalRestDAO restdao;
	@Inject
	private ApprovalCommentDAO commentdao;
	
	@Transactional
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
		dao.create(vo);
	}
	
	public int getMyDeptno(int empno) throws Exception {
		return dao.getMyDeptno(empno);
	}

	@Transactional
	public void update(ApprovalVO vo) throws Exception {
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
		dao.update(vo);
	}

	@Transactional
	public void do_approval(ApprovalVO vo,ApprovalProgressVO progressVO) throws Exception {
		ApprovalVO newVO = new ApprovalVO();						// ����ó�� SQL�� ������ VO
		ApprovalCommentVO commentVO = new ApprovalCommentVO();		// �ڸ�Ʈó�� SQL�� ������ VO
		newVO.setStatus("����");							// ����������� �⺻�� ���� (���ǹ��� ���� �����)
		newVO.setNo(vo.getNo());
		newVO.setNext_approval(progressVO.getNo());		// ���� ����/�ݷ��� ������ ��ȣ ����
		int manager_empno=dao.getManager(progressVO.getEmpno());	// ���ӻ���� ������� ��ȸ
		// ���� ����
		if(progressVO.isSign()){
			commentVO.setChecked("����");
			// ���ι���, Ÿ�μ� �߽ſ� ����
			if(vo.getReceiver()!=0){
				/* next_approval�� ��å�� �����̾��� (=�������� ������ �����̴�)
				 				-> status : �Ϸ�, curr/next : 0	*/
				if(manager_empno==1000){
					newVO.setStatus("�Ϸ�");
					newVO.setCurr_approval(0);
					newVO.setNext_approval(0);
					dao.change_status(newVO);
				}
				
				/* next_approval�� ��å�� ������ �ƴϾ���(�������� ������ ����̸��̴�)
								-> curr : ���������, next : ����������� ���	*/
				else{
					newVO.setCurr_approval(progressVO.getEmpno());
					newVO.setNext_approval(manager_empno);
				}
			}
			// ��ü����
			else{
				if(manager_empno!=0){	// �������� ��å�� ����(manager!=0)�� �ƴϾ��� 
					newVO.setCurr_approval(progressVO.getEmpno());
					newVO.setNext_approval(manager_empno);
				}
				else{					// �������� ��å�� ����(manager==0)�̾��� -> ����Ϸ�ó��
					newVO.setStatus("�Ϸ�");
					newVO.setCurr_approval(0);
					newVO.setNext_approval(0);
					dao.change_status(newVO);
				}
			}
		}
		// ���� �ݷ� : ����� ���������� ��� �ۼ��ڷ� �ٲ�
		else{
			commentVO.setChecked("�ݷ�");
			newVO.setStatus("�ݷ�");
			newVO.setCurr_approval(vo.getWriter());
			newVO.setNext_approval(0);
			dao.change_status(newVO);
		}
		
		dao.change_status(newVO);
		dao.change_approval(newVO);

		// �ڸ�Ʈ ó�� (����ÿ��� �ڸ�Ʈ �Է��� ������ ����)
		if(progressVO.getComments()!=null){
			commentVO.setNo(progressVO.getNo());
			commentVO.setWriter(progressVO.getEmpno());
			commentVO.setWriter_name(progressVO.getEname());
			commentVO.setComments(progressVO.getComments());
			commentdao.insert(commentVO);
		}
	}

	public List<ApprovalVO> list(ApprovalVO vo) throws Exception {
		return dao.list(vo);
	}

	public ApprovalVO select(int no) throws Exception {
		return dao.select(no);
	}

	public List<ApprovalVO> listStatus(Map<String, Object> map) throws Exception {
		return dao.listStatus(map);
	}

	public String getDname(int deptno) throws Exception {
		return dao.getDname(deptno);
	}
	
	@Transactional
	public void delete(int no) throws Exception {
		dao.delete(no);
		commentdao.delelte(no);
	}
}
