package com.example.easynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.PersonDetails;

@Repository
public class PersonalDAOimpl implements PersonalDAO{

	@Autowired
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	

	@Override
	public PersonDetails getPersonalDetails(String customerId) {
		// TODO Auto-generated method stub
		
		
		String sql = "SELECT * FROM CUSTOMER_PERSONAL_DETAILS  WHERE CUSTOMER_ID  = ? ";
		
		Connection conn = null;
		PersonDetails pd=new PersonDetails();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(customerId));
			
			
			ResultSet rs = ps.executeQuery();
			
				
				
			if(rs.first()) {
				pd.setCustomerId(rs.getInt("CUSTOMER_ID"));
				pd.setCustomerName(rs.getString("CUSTOMER_NAME"));
				pd.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
			//	pd.setCustomerPhone(rs.getLong("CUSTOMER_ID"));
				pd.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				pd.setGender(rs.getString("GENDER"));
				
				
				
			
				
			}
				
				
			
			
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}

		return pd;
	}
	
}
