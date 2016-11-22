package kr.co.useful.organization.persistence;

import java.util.List;

import kr.co.useful.organization.domain.OrganizationVO;

public interface OrganizationDAO {
	public List<OrganizationVO> getDeptList() throws Exception;		// ����ؾ��� �μ����� ����
	public List<OrganizationVO> list_by_deptno(int deptno) throws Exception;	// �ش� �μ��� ������ ���
	public OrganizationVO getDetails(int empno) throws Exception;		// Ư�� ����� �� ���� ���
}
