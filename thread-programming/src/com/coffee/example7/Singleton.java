package com.coffee.example7;
/**
 * 懒汉式:
 * 
 * 
 * @author coffee
 *
 */
public class Singleton {
	//持有自己的一个私有的未初始化的静态对象
	private static Singleton instance;
	
	//构造函数私有化
	private Singleton() {
		
	}
	
	
	/**
	 * 版本1
	 * 使用时再初始化,存在线程安全问题
	 */
	//提供一个获取实例的方法
//	public static Singleton getInstance() {
//		//判断私有对象是否实例化，因为此时设计到了多个步骤的执行（先判断是否为null，再初始化），所以存在线程安全问题
//		if(instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}
	
	
	/**
	 * 版本2
	 * 解决了线程安全问题，但是出现了较大的性能效率问题
	 */
	//提供一个获取实例的方法
//	public synchronized static Singleton getInstance() {//每次获取对象都要进入同步方法
//		
//		if(instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}
	
	/**
	 * 版本3（推荐）
	 * 解决了线程安全问题，减小了性能效率问题
	 */
	//提供一个获取实例的方法
	public static Singleton getInstance() {
		
		if(instance == null) {			
			synchronized(Singleton.class) {//只有两次会进入到同步代码块中
				if(instance == null) {	
					instance = new Singleton();
				}
			}
		}
		return instance;
			
	}
}
