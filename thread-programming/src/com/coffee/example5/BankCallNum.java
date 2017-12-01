package com.coffee.example5;
/**
 * 执行银行排队叫号
 * @author Administrator
 *
 */
public class BankCallNum {
	public static void main(String[] args) {
		Thread t1 = new BankWindow();
		Thread t2 = new BankWindow();
		Thread t3 = new BankWindow();
		
		t1.start();
		t2.start();
		t3.start();
	}
}

/**
 * 银行处理窗口，对用户的排号数依次进行叫号
 * @author Administrator
 *
 */
class BankWindow extends Thread {
	//当前号数
	static int num;
	@Override
	public void run() {
		while(true) {
			if(num >50) {
				break;
			}
			System.out.println(currentThread().getName()+":"+ num++);
		}
	}
}
