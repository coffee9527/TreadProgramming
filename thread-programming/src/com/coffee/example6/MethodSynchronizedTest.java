package com.coffee.example6;

public class MethodSynchronizedTest {
	public static void main(String[] args) {
		final ClassA clazzA = new ClassA();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				clazzA.method1();
			}
		});
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				clazzA.method2();
			}
		});
	}
}

class ClassA {
	public synchronized void method1() {
		System.out.println("-------ClassA-method1------");

		
		for(int i=0;i<100;i++) {
				System.out.println("A1");
		}
	}
	
	public synchronized void method2() {
		System.out.println("-------ClassA-method2------");

		
		for(int i=0;i<100;i++) {
				System.out.println("A2");
		}
	}
}

class ClassB {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	public void method1() {
		System.out.println("-------ClassB-method1------");

		
		for(int i=0;i<100;i++) {
			synchronized(lock1) {
				System.out.println("B1");
			}
		}
	}
	
	public void method2() {
		System.out.println("-------ClassB-method2------");

		
		for(int i=0;i<100;i++) {
			synchronized(lock2) {
				System.out.println("B2");
			}
		}
	}
}