package kr.co.useful.mypage.persistence;

import kr.co.useful.manager.domain.EmpVO;

public interface MypageDAO {
	
	//��� ���� ���
	public EmpVO select(int empno)throws Exception;
	
	//��� �������� ����
	public void update(EmpVO vo)throws Exception;
}
