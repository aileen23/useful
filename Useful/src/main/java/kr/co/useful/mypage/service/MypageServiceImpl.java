package kr.co.useful.mypage.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.useful.manager.domain.EmpVO;
import kr.co.useful.mypage.domain.ProofEmpVO;
import kr.co.useful.mypage.persistence.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService{

	@Inject
	private MypageDAO dao;
	
	@Override
	public EmpVO select(int empno) throws Exception {
		return dao.select(empno);
	}

	@Override
	public void update(EmpVO vo) throws Exception {
		 dao.update(vo);
	}

	@Override
	public EmpVO select_pass(int empno) throws Exception {
		return dao.select_pass(empno);
	}
	
	@Override
	public ProofEmpVO proof_emp(int empno) throws Exception {
		return dao.proof_emp(empno);
	}

}
