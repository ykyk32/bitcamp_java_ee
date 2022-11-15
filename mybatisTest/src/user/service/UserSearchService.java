package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***************");
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.println("***************");
		System.out.println("번호 선택 : ");
		int num = scan.nextInt();
	
		System.out.println();
		String columnName = null;//지역변수 null
		String value = null;
		
		if(num ==1) {
			System.out.println("이름 입력 :");
			value = scan.next();
			columnName = "name";
		
		}else if(num ==2) {
			System.out.println("아이디 입력 :");
			value = scan.next();
			columnName = "id";			
		}
		

		//DB
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("columnName", columnName);
		map.put("value", value);
		
		UserDAO userDAO = UserDAO.getInstance();//싱글톤
		
		List<UserDTO> list = userDAO.search(map);
		
		//응답
		if(list.size()==0) {
			System.out.println("찾으시는 값이 없습니다.");
			return;
		
		}
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"
					+userDTO.getId()+"\t"
					+userDTO.getPwd());
		}
			
		
		
	}
	

}

/*
 * 1. 이름 검색 
 * 2. 아이디 검색 
 * 번호 선택 : 1
 * 
 * 1번 선택 시 찾고자 하는 이름 입력 : 동
 * 
 * 홍길동 hong 111 희동이 baby 111
 * 
 * 2번 선택 시 찾고자 하는 아이디 입력: n
 * 
 * 홍길동 hong 111 코난 conan 111
 * 
 * => UserDAO.UserSearchService() 메소드 1개로 해결 => userMapper.xml에서 <select
 * id="search" 태그 1개로 해결, % 와#{} 는 같이 쓰일 수 없다
 */