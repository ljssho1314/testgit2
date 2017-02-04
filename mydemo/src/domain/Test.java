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
		   //����һ������������������ȥ������mybatis�����ļ�
		   String resource = "domain/configuration.xml";  
		   //��������mybatis��reader��
	       Reader reader = Resources.getResourceAsReader(resource);  
	       //��ȡ�������ã�ͨ����ȡ����ȡ��sqlsessionfac������ִ�����ݿ����
	       SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
	       SqlSession session = ssf.openSession();  //��ȡmybatisִ��sql������
	       try {  
	            User user = (User) session.selectOne("selectUser",3); //ִ�нű�
	            System.out.println(user.getName()); 
	       } catch (Exception e) {  
	            e.printStackTrace();  
	       } finally {  
	            session.close();  
	       }  
	}

}
