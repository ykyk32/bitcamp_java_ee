package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static UserDAO userDAO = new UserDAO();
	
	//private 으로 설정했기 때문에 외부에서는 접근 불가
	public static UserDAO getInstance() {
		return userDAO;
		
	}
	
	public UserDAO() {
		//환경설정 파일(mybatis-config.xml)을 읽어온다.
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//Reader추상클래스라 new못함//환경설정파일 읽어오기
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//interface를 다른 클래스통해서 생성//환경설정파일로 만들기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성//interface를 다른 클래스통해서 생성
		sqlSession.insert("userSQL.write",userDTO);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<UserDTO> getList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getList");//메소드 이름으로 같이가는게 편하다
		sqlSession.close();
		return list;
	}
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser",id);//한사람분을 userDTO로 내놔라
		System.out.println("userDTO = "+ userDTO);
		sqlSession.close();
		return userDTO;
	}

	public int update(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.update",map);
		
		sqlSession.commit();
		sqlSession.close();
		
		return su;
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete",id);//mapper namespace="userSQL"
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<UserDTO> search(Map<String,String> map) {
	//public UserDTO search(String columnName,String value) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//List<UserDTO> list =sqlSession.selectList("userSQL.search",columnName,value);//여기서 map 으로 묶을때?
		List<UserDTO> list =sqlSession.selectList("userSQL.search",map);
		
		sqlSession.close();
		return list;
		
	}

}
