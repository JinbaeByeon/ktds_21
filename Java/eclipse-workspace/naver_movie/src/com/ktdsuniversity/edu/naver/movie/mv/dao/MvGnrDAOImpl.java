package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class MvGnrDAOImpl extends AbstractDaoPoolSupport<MvVO>
						  implements MvGnrDAO {

	@Override
	public int createMvGnr(MvVO mvVO) {
		String mvId = mvVO.getMvId();
		List<GnrVO> gnrList = mvVO.getGnrList();
		
		return 0;
	}

	@Override
	public int updateMvGnr(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deleteMvGnr(String mvId) {
		return 0;
	}

}
