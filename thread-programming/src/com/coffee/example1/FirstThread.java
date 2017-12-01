package com.coffee.example1;

public class FirstThread {
	//main方法其实是一个线程，称为主线程，jvm中还有其他线程，比如垃圾回收
	public static void main(String[] args) {
		//创建并启动一个线程
		new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<50;i++) {
					System.out.println("线程A:"+i);
				}
			}
		}).start();;
		//创建并启动一个线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++) {
					System.out.println("线程B:"+i);
				}
			}
		}).start();;
	}
}
