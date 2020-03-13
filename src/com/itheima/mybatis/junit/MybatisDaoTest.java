package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

//这个测试充当Service层
public class MybatisDaoTest {

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
	public void testDao() throws Exception {
		
		//Service层需要Dao，并且给Dao层传递一个工厂，这样Dao层就可以操作数据库了
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
