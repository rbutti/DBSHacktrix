package com.example.easynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.LoginRequest;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public LoginRequest login(LoginRequest request) {
		
			
			String sql = "SELECT * FROM USER_LOGIN WHERE USER_ID = ? and USER_PASSWORD = ?";
			
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, request.getUserId());
				ps.setString(2, request.getPassword());
				
				ResultSet rs = ps.executeQuery();
				if(rs.first())  {
				request.setRole(rs.getString("USER_ROLE"));
				request.setMessage("USER LOGIN SUCCESSFULL");
				} else {
					request.setMessage("USER LOGIN FAILED");
				}
				
				rs.close();
				ps.close();
				return request;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
					conn.close();
					} catch (SQLException e) {}
				}
			}
		}
	
}
