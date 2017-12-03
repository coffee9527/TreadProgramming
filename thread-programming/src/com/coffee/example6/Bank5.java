package com.coffee.example6;

/**
 * 验证同步方法的所对象是this
 * @author Administrator
 *
 */
public class Bank5 {
	public static void main(String[] args) throws InterruptedException {
		Runnable r5 = new TicetWindow5();
		Thread t1 = new Thread(r5);
		Thread t2 = new Thread(r5);
		t1.start();
		((TicetWindow5)r5).change();
		t2.start();
	}
}

class TicetWindow5 implements Runnable {
	private int max_value = 0;
	private Object lock = new Object();
	private boolean flag = true;
	@Override
	public void run() {
		if(flag) {
			while(true) {
				synchronized(lock) {//如果同步锁对象不是this，那么会出现501.如果是this就不会出现该现象,这说明同步方法的锁对象就是this
					if(max_value > 500) {
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":lock..." +max_value++);
				}
			}
		}else {
			while(true) {
				if(ticket()) {
					break;
				}
			}
		}
	}
	
	private synchronized boolean ticket() {//同步锁对象是this
		if(max_value > 500) {
			return true;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":method.."+max_value++);
		return false;
	}
	
	public void change() throws InterruptedException {
		Thread.sleep(30);//为什么要sleep
		this.flag = false;
	}
}
