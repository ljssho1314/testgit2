package domain;

import java.util.LinkedList;

/**
 * java队列的简单实现
 * 这道题是白玉面试时遇见的，主要考的是java队列，下面是java队列的小案例，大家看一下，很简单，就是使用linkedlist
 * @author lenovo
 * @param <T>
 */
public class Stack {
	
	
	/*
	 * 创建一个linkedlist对象用来存储数据（在java中，用linkedlist是最简单的实现队列功能【队列原理是先进先出】）
	 */
    private LinkedList ll = new LinkedList();

    
    /*
     * 创建添加数据方法（有后往前加）
     */
    public void push(String str) {
    	ll.addLast(str);//linkedlist的方法，值得是从集合最后端插入数据
    }

    /*
     * 创建一个获取数据方法（通过linkedlist获取集合第一条记录）
     */
    public String peek() {
        return (String) ll.getFirst();
    }

 
    /*
     * 删除集合里的第一条数据
     */
    public String pop() {
        return (String) ll.removeFirst();
    }

    
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push("a");//第一次被添加
        stack.push("b");//第二次被添加
        stack.push("c");//第三次被添加
        System.out.println(stack.peek());//得到第一条记录
    }
}