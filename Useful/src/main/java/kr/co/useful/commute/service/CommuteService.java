package kr.co.useful.commute.service;

import kr.co.useful.commute.domain.CommuteVO;

public interface CommuteService {
	
	public boolean insert(int empno)throws Exception;
	
	public void update(int empno)throws Exception;
	
}