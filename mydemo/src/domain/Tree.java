package domain;

/**
 * ����һ���ݹ���㷨���������ϵ�ʮ��Ĺ淶�����ǵ�ʮ���������û�������������԰��յݹ�������дһ���㷨
 * �������㷨�������һ������������������ڵĺ�
 * @author lenovo
 *
 */
public class Tree {
	
	
	public static void main(String liu[]){
	
		Tree h = new Tree();
		System.out.println(h.add(100));
	}

	
	public static int add(int i)
	{
		if(i==0){
			return 0;
		}else
		{
			return i+add(i-1);
		}
	}
	
	
}
