package kr.co.useful.login.persistence;

import java.util.List;

import kr.co.useful.manager.domain.EmpVO;


public interface LoginDAO {
	
	public EmpVO select(int empno)throws Exception; //��� ����Ʈ ���
}
