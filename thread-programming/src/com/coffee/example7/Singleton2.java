package com.coffee.example7;
/**
 * 饿汉式:加载时就初始化,
 *   不存在线程安全问题，
 *   但是有一个性能上的问题，那就是提前对实例进行了初始化或者说构造。
 * 如果构造该类需要很多的性能消耗，这样会提前完成构造，如果在系统运行过程中压根没有
 * 对该实例进行使用，那岂不是很浪费系统资源
 * 
 * @author coffee
 *
 */
public class Singleton2 {
	//持有自己的一个私有的已初始化的静态对象
	private static Singleton2 instance = new Singleton2();
	
	//构造函数私有化
	private Singleton2() {
		
	}
	
	//提供一个获取实例的静态方法
	public static Singleton2 getInstance() {
		//私有实已经初始化，直接返回即可
		return instance;
	}
}
