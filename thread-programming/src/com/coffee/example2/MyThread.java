package com.coffee.example2;
/**
 * 通过继承Thread类来创建线程
 * 步骤：
 * 	1.继承Thread类
 * 	2.重写run()方法
 * 	3.使用时调用start()方法即可启动一个线程
 * @author coffee
 *
 */
public class MyThread extends Thread{//java.lang.Thread
	private static int index = 0;
	private int name;
	public MyThread() {
		//静态变量标识每个对象
		index++;
		//把标识赋值给普通变量
		name = index;
	}
	//覆写run
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("MyThread-线程"+name+":" + i);
		}
	}
}
