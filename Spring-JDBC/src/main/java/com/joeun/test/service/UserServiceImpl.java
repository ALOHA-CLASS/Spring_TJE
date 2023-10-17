package com.joeun.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joeun.test.HomeController;
import com.joeun.test.dao.UserDAO;
import com.joeun.test.dto.User;
import com.joeun.test.dto.UserAuth;

@Service			// 비즈니스 로직을 처리하는 서비스 클래스로 빈 등록
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> list() throws Exception {
		List<User> userList = userDAO.list();
		return userList;
	}

	@Override
	public User select(int userNo)  {
		User user = userDAO.select(userNo);
		return user;
	}

	// 회원 가입(등록)
	@Transactional			// 트랜잭션 적용 어노테이션 
	@Override
	public Integer insert(User user) throws Exception {
		int result = userDAO.insert(user);
		
		// 회원 권한 등록
		UserAuth userAuth = new UserAuth();
		userAuth.setAuth("ROLE_USER");
		userAuth.setUserId(user.getUserId());
		userDAO.insertAuth(userAuth);
		
		return result;
	}

	@Override
	public Integer update(User user) throws Exception {
		int result = userDAO.update(user);
		return result;
	}

	@Override
	public Integer delete(int userNo) throws Exception {
		int result = userDAO.delete(userNo);
		return result;
	}

	@Override
	public User login(User user) throws Exception {
		User loginUser = userDAO.login(user);
		return loginUser;
	}

}










