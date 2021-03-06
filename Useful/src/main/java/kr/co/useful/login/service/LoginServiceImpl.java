package kr.co.useful.login.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.useful.login.persistence.LoginDAO;
import kr.co.useful.manager.domain.EmpVO;
import kr.co.useful.organization.domain.OrganizationVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginDAO dao;
	
	@Override
	public EmpVO select(int empno) throws Exception {
		return dao.select(empno);
	}

	@Override
	public EmpVO selectLoginUser(int empno, String pass) throws Exception {
		return dao.selectLoginUser(empno, pass);
	}

	@Override
	public int update(int empno) throws Exception {
		return dao.update(empno);
	}

	@Override
	public EmpVO selectAll(EmpVO vo) throws Exception {
		return dao.selectAll(vo);
	}

	@Override
	public int updatepass(int empno, String pass) throws Exception {
		return dao.updatepass(empno, pass);
	}

	@Override
	public EmpVO selectempno(int empno, String pass) throws Exception {
		return dao.selectempno(empno, pass);
	}

	

	

	


	

	

}
