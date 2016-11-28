package kr.co.useful.commute.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.useful.commute.domain.CommuteVO;

@Repository
public class CommuteDAOImpl implements CommuteDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(int empno) throws Exception {
		String checked;
		
		Calendar now = Calendar.getInstance( );
		now.get(Calendar.HOUR_OF_DAY);
			
		Map<String, Object> map = new HashMap<>();
			if(now.get(Calendar.HOUR_OF_DAY) < 9){
				checked = "���";
			}else{
				checked = "����";
			}
		map.put("empno", empno);
		map.put("checked",checked);
		
		sqlSession.insert("commute.insert", map);
	}

	@Override
	public void update(int empno) throws Exception {
		sqlSession.update("commute.update", empno);
	}

}
