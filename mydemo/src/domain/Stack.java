package domain;

import java.util.LinkedList;

/**
 * java���еļ�ʵ��
 * ������ǰ�������ʱ�����ģ���Ҫ������java���У�������java���е�С��������ҿ�һ�£��ܼ򵥣�����ʹ��linkedlist
 * @author lenovo
 * @param <T>
 */
public class Stack {
	
	
	/*
	 * ����һ��linkedlist���������洢���ݣ���java�У���linkedlist����򵥵�ʵ�ֶ��й��ܡ�����ԭ�����Ƚ��ȳ�����
	 */
    private LinkedList ll = new LinkedList();

    
    /*
     * ����������ݷ������к���ǰ�ӣ�
     */
    public void push(String str) {
    	ll.addLast(str);//linkedlist�ķ�����ֵ���ǴӼ������˲�������
    }

    /*
     * ����һ����ȡ���ݷ�����ͨ��linkedlist��ȡ���ϵ�һ����¼��
     */
    public String peek() {
        return (String) ll.getFirst();
    }

 
    /*
     * ɾ��������ĵ�һ������
     */
    public String pop() {
        return (String) ll.removeFirst();
    }

    
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push("a");//��һ�α����
        stack.push("b");//�ڶ��α����
        stack.push("c");//�����α����
        System.out.println(stack.peek());//�õ���һ����¼
    }
}