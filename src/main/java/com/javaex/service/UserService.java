package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 필드
	@Autowired
	private UserDao userDao;
	
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin");
		
		UserVo authUser = userDao.userSelectByIdPw(userVo);
		
		System.out.println(authUser);
		return authUser;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	// 등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		int count = userDao.personInsert(personVo);

		return count;
	}

	// 등록2
	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");

		// map 사용
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);

		int count = userDao.personInsert2(personMap);

		return count;
	}
	*/
}
