package com.coffee.example4;
/**
 * 1.线程有五大状态：
 * 	新建状态，就绪状态，阻塞状态，运行状态，死亡状态
 * 
 * 2.线程几种状态间的转换
 * 	新建状态只能到就绪状态
 * 	就绪状态只能到运行状态，一个线程只能被启动一次，否则会抛出线程状态异常的错误
 * 	运行状态能到冻结状态也能到死亡状态
 * 	冻结状态能到运行状态也能到死亡状态
 * 	死亡装填只能接受死亡的事实
 * @author coffee
 *
 */
public class ThreadStatus {
	public static void main(String[] args) {
		//1线程处于新建状态
		Thread t1 = new YourThread();
		//2线程处于就绪状态，注意线程被start之后只具备运行资格，但未必获取到了执行权，此时就是就绪状态
		t1.start();
		
//		3.运行状态(Running)
		
//        当线程获得CPU时间后，它才进入运行状态，真正开始执行run()方法.
		
//		4. 阻塞状态(Blocked)
//
//      线程运行过程中，可能由于各种原因进入阻塞状态:
//      1>线程通过调用sleep方法进入睡眠状态；
//      2>线程调用一个在I/O上被阻塞的操作，即该操作在输入输出操作完成之前不会返回到它的调用者；
//      3>线程试图得到一个锁，而该锁正被其他线程持有；
//      4>线程在等待某个触发条件；
//      ......        
		//所谓阻塞状态是正在运行的线程没有运行结束，暂时让出CPU，这时其他处于就绪状态的线程就可以获得CPU时间，进入运行状态。
		
//		5. 死亡状态(Dead)
//
//        有两个原因会导致线程死亡：
//        1) run方法正常退出而自然死亡，
//        2) 一个未捕获的异常终止了run方法而使线程猝死。
//        为了确定线程在当前是否存活着（就是要么是可运行的，要么是被阻塞了），需要使用isAlive方法。如果是可运行或被阻塞，这个方法返回true； 
//        如果线程仍旧是new状态且不是可运行的， 或者线程死亡了，则返回false.
//		  线程死亡后不可能再回到任何状态
	}
}

class YourThread extends Thread {
	@Override
	public void run() {
		int i = 0;
		while(i<100) {
			System.out.println(i);
			i++;
		}
	}
}


