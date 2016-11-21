package kr.co.useful;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SqlSession��ü Ȯ�� (iBatis�� SqlMapClient ����)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-l.xml"})
public class MyBatisTest {
	// ������ ���� ��� �ʱ�ȭ (from root-context.xml)
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory(){
		System.out.println("SqlSessionFactory : "+sqlFactory);
	}
	@Test
	public void testSession(){
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println("Session : "+session);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
