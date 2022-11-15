package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private SqlSessionFactory sqlSessionFactory;
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<BoardDTO> boardList(Map<String,Integer> map) {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		List<BoardDTO> list=sqlSession.selectList("boardSQL.boardList",map);
		
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		int totalA =sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
}












