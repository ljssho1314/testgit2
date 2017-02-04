package domain;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) throws IOException {
		   //创建一个变量，告诉主函数去哪里找mybatis配置文件
		   String resource = "domain/configuration.xml";  
		   //创建数据mybatis的reader；
	       Reader reader = Resources.getResourceAsReader(resource);  
	       //读取器创建好，通过读取器获取到sqlsessionfac，用来执行数据库操作
	       SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
	       SqlSession session = ssf.openSession();  //获取mybatis执行sql工具类
	       try {  
	            User user = (User) session.selectOne("selectUser",3); //执行脚本
	            System.out.println(user.getName()); 
	       } catch (Exception e) {  
	            e.printStackTrace();  
	       } finally {  
	            session.close();  
	       }  
	}

}
