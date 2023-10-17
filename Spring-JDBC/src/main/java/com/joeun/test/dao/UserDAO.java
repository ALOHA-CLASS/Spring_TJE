package com.joeun.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.joeun.test.dto.User;
import com.joeun.test.dto.UserAuth;

@Repository			// 데이터 액세스 객체로 빈 등록
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 회원 목록 조회
	 * @return
	 */
	public List<User> list() {
	
		String sql = " SELECT * FROM user ";
		List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserNo( rs.getInt("user_no") );
				user.setUserId( rs.getString("user_id") );
				user.setUserPw( rs.getString("user_pw") );
				user.setName( rs.getString("name") );
				user.setEmail( rs.getString("email") );
				user.setRegDate( rs.getTimestamp("reg_date") );
				user.setUpdDate( rs.getTimestamp("upd_date") );
				return user;
			}
		});
		
		return userList;
	}
	
	
	
	public User select(int userNo) {
		String sql = " SELECT * FROM user WHERE user_no = ? ";
		
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserNo( rs.getInt("user_no") );
				user.setUserId( rs.getString("user_id") );
				user.setUserPw( rs.getString("user_pw") );
				user.setName( rs.getString("name") );
				user.setEmail( rs.getString("email") );
				user.setRegDate( rs.getTimestamp("reg_date") );
				user.setUpdDate( rs.getTimestamp("upd_date") );
				return user;
			}
		}, userNo);
		
		return user;
	}
	
	public int insert(User user) {
		String sql = " INSERT INTO user(user_id, user_pw, name, email) "
				   + " VALUES ( ?, ?, ?, ? ) ";
		
		Object[] args = new Object[] {user.getUserId(), user.getUserPw(), user.getName(), user.getEmail()};
		
		int result = jdbcTemplate.update(sql, args);
		return result;
	}
	
	public int update(User user) {
		String sql = " UPDATE user "
				   + "    SET user_pw = ? "
				   + "       ,name = ? "
				   + "       ,email = ? "
				   + "		 ,upd_date = now() "
				   + " WHERE user_id = ? ";
		
		Object[] args = new Object[] {user.getUserPw(), user.getName(), user.getEmail(), user.getUserId()};
		int result = jdbcTemplate.update(sql, args);
		return result;
	}
	
	public int delete(int userNo) {
		String sql = " DELETE FROM user "
				   + " WHERE user_no = ? ";
		
		Object[] args = new Object[] {userNo};
		int result = jdbcTemplate.update(sql, args);
		return result;
	}
	
	
	
	
	public User login(User user) {
		String sql = " SELECT * FROM user WHERE user_id = ? AND user_pw = ? ";
		
		User loginUser = null;
		
		try {
			loginUser = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUserNo( rs.getInt("user_no") );
					user.setUserId( rs.getString("user_id") );
					user.setUserPw( rs.getString("user_pw") );
					user.setName( rs.getString("name") );
					user.setEmail( rs.getString("email") );
					user.setRegDate( rs.getTimestamp("reg_date") );
					user.setUpdDate( rs.getTimestamp("upd_date") );
					return user;
				}
			}, user.getUserId(), user.getUserPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loginUser;
	}


	// 회원권한 등록
	public int insertAuth(UserAuth userAuth) {
		
		String sql = " INSERT INTO user_auth ( user_id, auth ) "
				   + " VALUES ( ?, ? ) ";
		
		Object[] args = new Object[] {userAuth.getUserId(), userAuth.getAuth()};

		int result = 0;
		try {
			result = jdbcTemplate.update(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}


















