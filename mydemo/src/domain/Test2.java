package domain;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test2 {
	
	
	//声明全局变量，给每个方法提供
	SqlSessionFactory sqlSessionFactory;
	 
	
	//初始化sql工厂
	public void initFactory() throws IOException{
		//创建一个变量，告诉主函数去哪里找mybatis配置文件
	   String resource = "domain/configuration.xml";  
	   //创建数据mybatis的reader；
       Reader reader = Resources.getResourceAsReader(resource);  
       //读取器创建好，通过读取器获取到sqlsessionfac，用来执行数据库操作
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	}
	
	
	//查询所有
	public List<User> selectAll()
	{
		//通过session工厂得到session实例化对象
        SqlSession session = sqlSessionFactory.openSession();  //获取mybatis执行sql工具类
        //运行要执行的sql的id
        List<User> us = session.selectList("selectAll");
        return us;
	}
	
	
	//添加用户的方法
	public int insertUser(User u)
	{
        SqlSession session = sqlSessionFactory.openSession();  //获取mybatis执行sql工具类
		int num =0;
		num = session.insert("insertUser",u);
		session.commit();//一定要手动的执行commit操作，提交本次执行的sql语句
		return num;
	}
	
	public int updateUser(User u)
	{
	    SqlSession session = sqlSessionFactory.openSession();  //获取mybatis执行sql工具类
		int num =0;
		num = session.update("updateUser",u);
		session.commit();
		return num;
	}
	

	public int deleteUser(int id)
	{
	    SqlSession session = sqlSessionFactory.openSession();  //获取mybatis执行sql工具类
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
