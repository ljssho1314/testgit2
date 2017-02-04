package domain;

/**
 * 这是一个递归的算法案例，符合第十题的规范，但是第十题具体内容没看懂，不过可以按照递归树给他写一个算法
 * 这个类的算法是随意给一个数，计算这个数以内的和
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
