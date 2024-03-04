package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;
import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<GuestbookVo> guestbookSelect() {
		System.out.println("GuestbookDao.guestbookSelect()");

		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");

		// System.out.println(personList);

		return guestbookList;
	}

	// 1개 가져오기
	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");

		GuestbookVo guestbookVo = sqlSession.selectOne("guestbook.selectOne", no);
		System.out.println(guestbookVo);
		return guestbookVo;
	}

	// 1개 가져오기2
	public Map<String, Object> boardSelectOne2(int bno) {
		System.out.println("BoardDao.boardSelectOne()");

		Map<String, Object> pMap = sqlSession.selectOne("board.selectOne2", bno);
		// System.out.println(pMap);
		// System.out.println(pMap.get("name"));

		return pMap;
	}

	// 수정
	public int boardModify(BoardVo boardVo) {
		System.out.println("BoardDao.boardModify()");

		int count = sqlSession.update("board.boardUpdate", boardVo);

		return count;

	}

	// 삭제
	public int guestbookDelete(Map<String, String> gMap) {

		int count = sqlSession.delete("guestbook.guestbookDelete", gMap);
		// System.out.println(count);

		return count;
	}

	// 게스트북등록
	public int guestbookInsert(GuestbookVo guestbookVo) {

		int count = sqlSession.insert("guestbook.guestbookInsert", guestbookVo);

		return count;
	}

}
