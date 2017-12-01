package com.coffee.example5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过实现Runnable接口来启动线程，完成银行排号的例子，无需静态变量
 * 
 * Runnable和Thread的区别
 * 	1.Runnable就是一个可执行任务的表示而已，一次而已；而Thread次啊是线程所有API的体现
 * 	2.继承了Thread弗雷就没有办法去继承其他类，而实现了Runable接口也可以继承其他类并实现其他接口，这个区别
 * 也是很多书中千篇一律的提到的，其实java中的对象即使继承了其他类，也可以通过再构造一个父类的 方法继承很多各类，或者
 * 通过内部类的方法继承很多个类，因此这个区别个人觉得不痛不痒;
 * 	3.将执行任务单元和线程的执行控制区分开来，这才是引入Runnable最主要的目的，Thread你就是一个线程的操控者，
 * 或者独裁者，你又Thread的所有方法，而Runnable只是一个任务的标识，只有实现了它才能称之为一个任务，这也符合面向对象接口的逻辑，
 * 接口其实就是行为的规范和标识
 * @author coffee
 *
 */
public class Bank {
	public static void main(String[] args) {
		TicketWindow2 tw2 = new TicketWindow2();
		Thread t1 = new Thread(tw2);
		Thread t2 = new Thread(tw2);
		Thread t3 = new Thread(tw2);
		
		t1.start();
		t2.start();
		t3.start();
		/**
		 * 运行程序会发现结果中出现了超过50的数和出现重复的数
		 * 
		 * 	出现重复的数的关键步骤在于    value_max++
		 * 因为多个线程都在执行到了value_max进行+1操作之前进入了阻塞状态，当再次进入运行状态后会读取上次阻塞前的数值，直接++，
		 * 而不知道与此同时其他线程也进行了++操作，
		 */
		
	}
}

class TicketWindow2 implements Runnable {
	private int max_value = 0;
	public static final List<Integer> numList = new ArrayList<Integer>();
	
	@Override
	public void run() {
		while(true) {
			if(max_value>50) {
				break;
			}
			try {
				Thread.sleep(100);//在该程序的判断步骤之后加入线程休眠可以放大该程序存在的缺陷，因为这是两个明显不同的步骤，睡眠可以时多个线程处于同一步骤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!numList.contains(max_value)) {
				numList.add(max_value);//在max_vlaue++之前添加
			}else {
				System.out.println(Thread.currentThread().getName()+"-------重复啦--------");
			}
			System.out.println(Thread.currentThread().getName()+":"+max_value++);
			
		}
	}
	
}
