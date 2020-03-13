package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest {
	
	//声明一个SqlSessionFactory工厂
	public SqlSessionFactory sqlSessionFactory;
	//这个方法用来做前期准备工作，加载工厂的作用
	@Before
	public void before() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testMapper() throws Exception {
	
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession帮我生成一个实现类  （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
}
