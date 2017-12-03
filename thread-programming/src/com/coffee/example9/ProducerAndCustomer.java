package com.coffee.example9;

public class ProducerAndCustomer {
	final static NumberFactory numberFactory = new NumberFactory();
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					numberFactory.create();
				}	
			}
		}).start();;
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					numberFactory.consumer();
				}	
			}
		}).start();;
	}
}

class NumberFactory {
	private int i = 0;
	private Object lock = new Object();
	
	public void create() {
		synchronized(lock) {
			System.out.println("creat...i-" + i++);
		}
	}
	
	public void consumer() {
		synchronized(lock) {
			System.out.println("consume...i--" + i);
		}
	}
}
