package com.itheima.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {

	//注入
	private SqlSessionFactory sqlSessionFactory;
	//构造函数
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//通过用户ID查询一个用户
	public User selectUserById(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("findUserById", id);
	}
}
