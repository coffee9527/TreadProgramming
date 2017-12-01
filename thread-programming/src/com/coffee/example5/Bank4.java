package com.coffee.example5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 通过同步方法解决线程并发问题,使用同步方法就无需锁对象了
 * synchronized关键字不要定义在run方法上，因为一个线程执行完run方法后就死亡了，这样就变成了单线程，只能有一个线程在运行，其他都在等待锁释放
 * 
 * Private|default|protected|public  [static]  synchronized  void|return  type
methodName(Parameters)
 * 
 * 锁声明的一些个人规则：
 * 	1.所谓加锁，就是为了防止多个线程同时操作一份数据，如果多个线程的数据都是各自的，那么就没有枷锁的必要
 * 	2.共享数据的锁对于访问它们的线程来说必须是同一份，否则锁只能私有的锁，各锁各的，起不到保护共享数据的目的，
 * 	3.锁的定义可以使任意一个对象，该对象可以不参与任何运算，只要保证在访问的多个线程看起来他是唯一的即可；
 * @author Administrator
 *
 */
public class Bank4 {
	public static void main(String[] args) {
		Runnable tw2 = new TicketWindow4();
		Thread t1 = new Thread(tw2);
		Thread t2 = new Thread(tw2);
		Thread t3 = new Thread(tw2);
		
		t1.start();
		t2.start();
		t3.start();
		/**
		 * 运行程序会发现结果中不会再出现超过50的数和出现重复的数
		 */
		
	}
}

class TicketWindow4 implements Runnable {
	private int max_value = 0;
	public static final List<Integer> numList = new ArrayList<Integer>();
	
	@Override
	public void run() {
		while(true) {
			//通过同步代码块来为多个步骤枷锁
			/**
			 * 
			 */
			if(ticket()) {
				break;
			}
			
			
		}
	}
	
	private synchronized boolean ticket() {
		if(max_value>100) {
			return true;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(!numList.contains(max_value)) {
			numList.add(max_value);//在max_vlaue++之前添加
		}else {
			System.out.println(Thread.currentThread().getName()+"-------重复啦--------");
		}
		System.out.println(Thread.currentThread().getName()+":"+max_value++);
		return false;
	}
	
}
