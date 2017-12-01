package com.coffee.example2;
/**
 * 通过实现Runnable接口来创建线程
 * 步骤：
 * 	1.实现Runnable类
 * 	2.重写run()方法
 * 	3.把类对象作为参数传入Thread的构造方法中
 * 	4.调用Thread的start方法
 * @author coffee
 *
 */
public class MyThread2 implements Runnable{//java.lang.Runnable
	protected String name;
	public MyThread2() {
		
	}
	
	public MyThread2(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<120;i++) {
			System.out.println(name+":"+i);
		}
	}
	
}
