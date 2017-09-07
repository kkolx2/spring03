package com.example.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CityDao implements InitializingBean, DisposableBean{

	static Log log = LogFactory.getLog(CityDao.class);
	public CityDao() {
		log.info("##########################");
		log.info("1. new CityDao()...");
		log.info("##########################");
	}
	
	BasicDataSource ds;
	public void setDataSource(BasicDataSource ds){
		this.ds = ds;
		log.info("##########################");
		log.info("2. CityDao.setDataSource()...");
		log.info("##########################");
	}
	
	@PostConstruct
	public void postConstruct(){
		log.info("##########################");
		log.info("3. CityDao.@postContruct()...");
		log.info("##########################");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("##########################");
		log.info("4. InitializingBean.afterPropertiesSet");
		log.info(ds.getDriverClassName());
		log.info(ds.getUrl());
		log.info(ds.getUsername());
		log.info(ds.getPassword());
		log.info("##########################");
	}
	public void init(){
		log.info("##########################");
		log.info("5. Custom CityDao.init().....");
		log.info("##########################");
	}
	
	public List<String> selectAll() throws SQLException{
		Connection conn =ds.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement("select name from city where countrycode=?");
		pstmt.setString(1, "KOR");
		
		ResultSet rs = pstmt.executeQuery();
		log.info("CityDao.selectAll()....");
		List<String> list = new ArrayList<>();
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	@PreDestroy
	public void preDestruct(){
		log.info("##########################");
		log.info("6. CityDao.@preDestruct().....");
		log.info("##########################");
	}
	
	@Override
	public void destroy() throws Exception {
		log.info("##########################");
		log.info("7. DisposableBean.destroy().....");
		log.info("##########################");
	}
	public void close(){
		log.info("##########################");
		log.info("8. Custom CityDao.close().....");
		log.info("##########################");
	}
	
	
}
