package com.coffee.example6;

/**
 * 测试任意对象，this分别作为锁对象的情况
 * @author Administrator
 *
 */
public class MethodSynchronizedTest {
	public static void main(String[] args) {
//-------测试ClassA中的两个同步方法----------------
//		final ClassA clazzA = new ClassA();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				clazzA.method1();
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				clazzA.method2();
//			}
//		}).start();
		/**
		 * 执行结果:只有一个线程在执行，没有交互执行，说明同一个类中同步方法的锁对象是相同的。
		 */
//-------测试ClassA中的两个同步方法----------------
		
//-------测试ClassB中的两个同步方法----------------
		final ClassB clazzB = new ClassB();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				clazzB.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				clazzB.method2();
			}
		}).start();
		/**
		 * 如果两个同步代码块的锁对象一致那么输出的结果是按顺序输出的
		 * 如果连个同步代码块的锁对象不一样，那么输出的结果可能是不按顺序输出的
		 */
//-------测试ClassB中的两个同步方法----------------
	}
}

/**
 * 两个同步代码方法
 * @author Administrator
 *
 */
class ClassA {
	//共用资源
	private int ticket = 0;
	public synchronized void method1() {
		System.out.println("-------ClassA-method1------");

		
		for(int i=0;i<1000;i++) {
				System.out.println("A1: "+ticket++);
		}
	}
	
	public synchronized void method2() {
		System.out.println("-------ClassA-method2------");

		
		for(int i=0;i<1000;i++) {
				System.out.println("A2: "+ticket++);
		}
	}
}

/**
 * 两个同步代码块使用任意不同的对象作为锁对象
 * @author Administrator
 *
 */
class ClassB {
	//共享资源
	private int ticket = 0;
	//两个锁对象
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	public void method1() {
		System.out.println("-------ClassB-method1------");

		
		for(int i=0;i<1000;i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			synchronized(lock1) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("B1: "+ticket++);
			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
	public void method2() {
		System.out.println("-------ClassB-method2------");

		
		for(int i=0;i<1000;i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			synchronized(lock1) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("B2: "+ticket++);
			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}