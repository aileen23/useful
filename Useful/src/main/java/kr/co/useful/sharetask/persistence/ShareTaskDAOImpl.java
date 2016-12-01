package kr.co.useful.sharetask.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.useful.sharetask.domain.Criteria;
import kr.co.useful.sharetask.domain.SearchCriteria;
import kr.co.useful.sharetask.domain.ShareTaskVO;

@Repository
public class ShareTaskDAOImpl implements ShareTaskDAO {

	@Inject
	private SqlSession sqs;
	
	@Override
	public void create(ShareTaskVO vo) throws Exception {
		sqs.insert("sharetask.create",vo);

	}

	@Override
	public ShareTaskVO read(int bno) throws Exception {
		
		return sqs.selectOne("sharetask.oneRead", bno);
	}

	@Override
	public void update(ShareTaskVO vo) throws Exception {
		sqs.update("sharetask.update", vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqs.delete("sharetask.delete", bno);
	}

	@Override
	public List<ShareTaskVO> listAll() throws Exception {
	
		RowBounds bound = new RowBounds(0,10);
		return sqs.selectList("sharetask.listAll", bound);
	}

	@Override
	public List<ShareTaskVO> listCriteria(Criteria cri) throws Exception {
	
		return sqs.selectList("sharetask.listAll", null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int totalListCount() throws Exception {
		return sqs.selectOne("sharetask.shareListCount");
	}//��ü����Ʈ��

	
	//�˻� ����Ʈ �� 
	@Override
	public List<ShareTaskVO> listSearch(SearchCriteria cri) throws Exception {
		
		return sqs.selectList("sharetask.listSearch", cri, 
				               new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
	
		return sqs.selectOne("sharetask.listSearchCount", cri);
	}

	@Override
	public ShareTaskVO prevRead(int bno) throws Exception {
		
		return sqs.selectOne("sharetask.prevShare", bno);
	}

	@Override
	public ShareTaskVO nextRead(int bno) throws Exception {
		
		return sqs.selectOne("sharetask.nextShare", bno);
	}

}
