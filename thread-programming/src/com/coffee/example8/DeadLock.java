package com.coffee.example8;

/**
 * 实现一个线程死锁案例
 * 	线程死锁主要是在同步代码中还有同步，因此避免这种情况就不会出现死锁
 * @author coffee
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		Dead d = new Dead();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					d.methodA();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
					
			@Override
			public void run() {
				while(true) {
					d.methodB();
				}
			}
		}).start();
	}
}

class Dead {
	private Object lock = new Object();//自定义一个锁
	//线程共享的资源
	private int x = 0;
	
	public void methodA() {
		synchronized(lock) {//先用lock锁住程序
			synchronized(this) {
				System.out.println("method a .." + (x++));
			}
		}
	}
	
	public void methodB() {
		synchronized(this) {
			synchronized(lock) {
				System.out.println("method b .." + (x++));
			}
		}
	}
}
