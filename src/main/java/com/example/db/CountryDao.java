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

public class CountryDao implements InitializingBean, DisposableBean {
	static Log log = LogFactory.getLog(CountryDao.class);
	public CountryDao(){
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("1. new CountryDao()...");
		log.info("class construct called...");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}

	BasicDataSource ds;
	public void setDataSource(BasicDataSource ds){
		this.ds = ds;
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("2. CountryDao.setDataSource() ...");
		log.info("beans.xml --> property value called...");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@PostConstruct
	public void postConstruct(){
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("3-1. @Annotation = CountryDao.postConstruct() ...");
		log.info("[[[ import javax.annotation.PostConstruct; ]]]");
		log.info("@Annotation >>> interface InitializingBean.afterPropertiesSet()");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("3-2. InitializingBean.afterPropertiesSet() ...");
		log.info("[[[ implements InitialzingBean ]]]");
		log.info("property apply from beans.xml -> DI completed ");
		log.info("interface InitializingBean.afterPropertiesSet() >>> customInit()");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	public void customInit(){
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("3-3. CountryDao.customInit() ...");
		log.info("[[[ beans.xml custom Initializer settings ]]]");
		log.info("init-method=\"customInit\"");
		log.info("@Annotation >>> interface InitializingBean.afterPropertiesSet() >>> customInit()...");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	public List<String> selectAll() throws SQLException{
		Connection con = ds.getConnection();  
		// beans.xml에서 설정한 property ref 값으로 미리 커넥션 정보를 받아놓음. 
		PreparedStatement pstmt = 
				con.prepareStatement("select name from country where continent=?");
		pstmt.setString(1, "asia");
		ResultSet rs = pstmt.executeQuery();
		log.info("CountryDao.selectAll()....");
		List<String> list = new ArrayList<>();
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}
	
	@PreDestroy
	public void preDestroy(){
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("4-1. @Annotation = CountryDao.preDestroy() ...");
		log.info("[[[ import javax.annotation.PreDestroy; ]]]");
		log.info("@Annotation >>> interface DisposableBean.destroy()");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Override
	public void destroy() throws Exception {
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("4-2. DisposableBean.destroy() ...");
		log.info("[[[ implements DisposableBean ]]]");
		log.info("interface DisposableBean.destroy() >>> customDestroy()...");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	public void customDestroy(){
		log.info("VVVVVVVVVVVVVVVVVVVVVVVVV");
		log.info("4-3. CountryDao.customDestroy() ...");
		log.info("[[[ beans.xml custom destroyer settings ]]]");
		log.info("destroy-method=\"customDestroy\"");
		log.info("@Annotation >>> interface DisposableBean.destroy() >>> customDestroy()...");
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAA");
	}
}
