package com.coffee.example6;

/**
 * static同步方法的静态锁:类的字节码信息
 * @author Administrator
 *
 */
public class Bank6 {
	public static void main(String[] args) throws InterruptedException {
		Runnable r6 = new TicetWindow6();
		Thread t1 = new Thread(r6);
		Thread t2 = new Thread(r6);
		t1.start();
		((TicetWindow6)r6).change();
		t2.start();
	}
}

class TicetWindow6 implements Runnable {
	//此处的共享资源编程静态资源
	private static int max_value = 0;
	private Object lock = new Object();
	private boolean flag = true;
	@Override
	public void run() {
		if(flag) {
			while(true) {
				synchronized(this) {//如果同步锁对象不是this，那么会出现501.如果是this就不会出现该现象,这说明同步方法的锁对象就是this
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
	/**
	 * 如果把该同步方法改为静态同步方法，那么此时的所对象就不是this了，而是类的字节码信息TicetWindow6.class,因此
	 * 如果其他地方用到了同步代码块，则其所对象也要是类的字节码信息，否则会出现不同步的现象
	 * @return
	 */
	private synchronized static boolean ticket() {
		if(max_value > 500) {//非静态方法可以使用静态变量，反之不可
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
