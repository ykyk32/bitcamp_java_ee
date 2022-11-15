package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();//싱글톤
		UserDTO userDTO = userDAO.getUser(id);
		
		//응답
		if (userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;//execute() 나가버리기
			
		}

		userDAO.delete(id);
		System.out.println("아이디를 삭제하였습니다.");

	}

}
/*
 * 삭제할 아이디 입력 : angel 찾고자 하는 아이디 없습니다
 * 
 * 삭제할 아이디 입력 : hong 아이디가 삭제되었습니다.
 */