package com.example.easynotes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.DefaulterList;

@Repository
public class DefaulterDetailsDaoImpl implements DefaulterDetailsDao{
	
	@Autowired
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<DefaulterList> getDefaulterList(){
		String sql = "SELECT * FROM LOAN_PAID_DETAILS WHERE PAID_MONTH < ? ";
		
		Connection conn = null;
		List<DefaulterList> lst =new ArrayList<DefaulterList>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new Date(System.currentTimeMillis()));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())  {
				DefaulterList  def = new DefaulterList();
				def.setCustomerAddress("");
				lst.add(def);
			}
			rs.close();
			ps.close();
			return lst;
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
