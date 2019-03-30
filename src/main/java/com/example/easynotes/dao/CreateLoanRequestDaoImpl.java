package com.example.easynotes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.easynotes.model.LoanRequest;

public class CreateLoanRequestDaoImpl implements CreateLoanRequestDao{
	
	@Autowired
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public LoanRequest createNewLoanRequest(LoanRequest loanData) {
		
		Connection conn = null;
		
		try {
			String customerDataSql = "INSERT INTO CUSTOMER_PERSONAL_DETAILS " +
					"(CUSTOMER_NAME, CUSTOMER_EMAIL,CUSTOMER_PHONE,CUSTOMER_ADDRESS,GENDER,DATE_CREATED) VALUES (?, ?, ?,?,?,?)";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(customerDataSql);
			ps.setString(1, loanData.getCustomerName());
			ps.setString(2, loanData.getCustomerEmail());
			ps.setLong(3, loanData.getCustomerPhone());
			ps.setString(4, loanData.getCustomerAddress());
			ps.setString(5, loanData.getGender());
			ps.setDate(6, new Date(System.currentTimeMillis()));
			int count  = ps.executeUpdate();
			ps.close();
			
			if(count == 1) {
				long customerId = getCustomerId(loanData.getCustomerEmail());
				String loanDataSql = "INSERT INTO CUSTOMER_LOAN_ACCOUNT_DETAILS " +
						"(CUSTOMER_ID, LOAN_AMOUNT,STATUS,INTEREST_RATE,LOAN_DURATION,LOAN_APPLICATION_DATE) VALUES (?, ?, ?,?,?,?)";
				conn = dataSource.getConnection();
				PreparedStatement loanS = conn.prepareStatement(loanDataSql);
				loanS.setLong(1, customerId);
				loanS.setLong(2, loanData.getLoanAmount());
				loanS.setString(3, "PENDING");
				loanS.setLong(4, 3);
				loanS.setString(5, loanData.getGender());
				loanS.setDate(6, new Date(System.currentTimeMillis()));
				int loanCount  = loanS.executeUpdate();
				ps.close();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return loanData;
	}

	private long getCustomerId(String email) {
		// TODO Auto-generated method stub
String sql = "SELECT * FROM CUSTOMER_PERSONAL_DETAILS WHERE CUSTOMER_EMAIL = ?";
		
		Connection conn = null;
		Long customerId = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customerId = rs.getLong("CUSTOMER_ID");
			}
			rs.close();
			ps.close();
			return customerId;
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
