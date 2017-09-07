package com.example.db;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DataSourceSpringExample {

	public static void main(String[] args) throws SQLException {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/spring/beans.xml");
		
		System.out.println("@///////////////)");
		System.out.println("   김밥 먹고 시작    ");
		System.out.println("(///////////////@");
		// DI Container , Bean Factory
		// Life Cycle
		// 1. 객체 생성
		// 2. 객체 초기화
		// 3. 의존 주입 Dependency Injection
		// 4. 객체 사용
		// 5. 객체 소멸
		
		BasicDataSource ds = ctx.getBean(BasicDataSource.class);
		
		System.out.println(ds.getDriverClassName());
		System.out.println(ds.getUrl());
		System.out.println(ds.getUsername());
		System.out.println(ds.getPassword());

		CityDao dao1 = ctx.getBean(CityDao.class);
		System.out.println(dao1.selectAll());
		
		CountryDao dao2 = ctx.getBean(CountryDao.class);
		System.out.println(dao2.selectAll());
		

		System.out.println("@//////////////)");
		System.out.println("   김밥 먹고 끝    ");
		System.out.println("(//////////////@");
		ctx.close();
	}

}
