package com.coffee.example2;

import org.junit.Test;

public class ThreadTest {
	
	/**
	 * 测试继承Thread类方式的线程创建
	 */
//	@Test//junit测试线程不好用
//	public void testMyThread() {
//		new MyThread().start();
//		new MyThread().start();
//	}
	
	/**
	 * 测试继承Thread类方式的线程创建
	 * @param args
	 */
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}
}
