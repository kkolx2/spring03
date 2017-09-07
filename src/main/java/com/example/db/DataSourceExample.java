package com.example.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.spring.Dept;

public class DataSourceExample {

	public static void main(String[] args) throws SQLException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/world");
		ds.setUsername("jspbook");
		ds.setPassword("1234");
		
		Connection con = ds.getConnection();
		Dept dept = new Dept();
		con.close();
		
		
	}

}
