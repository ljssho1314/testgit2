package domain;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test2 {
	
	
	//����ȫ�ֱ�������ÿ�������ṩ
	SqlSessionFactory sqlSessionFactory;
	 
	
	//��ʼ��sql����
	public void initFactory() throws IOException{
		//����һ������������������ȥ������mybatis�����ļ�
	   String resource = "domain/configuration.xml";  
	   //��������mybatis��reader��
       Reader reader = Resources.getResourceAsReader(resource);  
       //��ȡ�������ã�ͨ����ȡ����ȡ��sqlsessionfac������ִ�����ݿ����
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	}
	
	
	//��ѯ����
	public List<User> selectAll()
	{
		//ͨ��session�����õ�sessionʵ��������
        SqlSession session = sqlSessionFactory.openSession();  //��ȡmybatisִ��sql������
        //����Ҫִ�е�sql��id
        List<User> us = session.selectList("selectAll");
        return us;
	}
	
	
	//����û��ķ���
	public int insertUser(User u)
	{
        SqlSession session = sqlSessionFactory.openSession();  //��ȡmybatisִ��sql������
		int num =0;
		num = session.insert("insertUser",u);
		session.commit();//һ��Ҫ�ֶ���ִ��commit�������ύ����ִ�е�sql���
		return num;
	}
	
	public int updateUser(User u)
	{
	    SqlSession session = sqlSessionFactory.openSession();  //��ȡmybatisִ��sql������
		int num =0;
		num = session.update("updateUser",u);
		session.commit();
		return num;
	}
	

	public int deleteUser(int id)
	{
	    SqlSession session = sqlSessionFactory.openSession();  //��ȡmybatisִ��sql������
		int num =0;
		num = session.delete("deleteUser",id);
		session.commit();
		return num;
	}
	public static void main(String[] args) throws IOException {
		Test2 t = new Test2();	
		t.initFactory();
//		List<User> us = t.selectAll();
//		for(User u:us)
//		{
//			System.out.println(u.getName());
//		}
		User u = new User();
		u.setId(11);
		u.setName("xxxxxx");
		System.out.println(t.insertUser(u));
//		System.out.println(t.updateUser(u));
//		System.out.println(t.deleteUser(9));
	}

}
