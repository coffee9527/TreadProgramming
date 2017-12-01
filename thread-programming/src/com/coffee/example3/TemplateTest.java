package com.coffee.example3;
/**
 * 在程序的设计中我们经常会将算法进行抽象，因为它有很多种运算的可能，所以我们为了更好地扩展，我们将算法进行了抽象，并统一交给父类进行实现，
 * 子类中只需要知道某个单元模块的功能即可，具体是如何穿插起来的子类不用去关心
 * 这里我们实现一个输出图形的算法，然后有两种不同的实现，
 * @author coffee
 *
 */
public class TemplateTest {
	public static void main(String[] args) {
		Diagram d1 = new StarDiagram('*');
		d1.dispaly("coffee");
	}
}

abstract class Diagram {
	protected char c;
	public Diagram(char c) {
		this.c = c;
	}
	
	//只能子类继承
	abstract protected void print(int size);
	
	abstract protected void printContent(String msg);
	
	//不可覆写
	public final void dispaly(String msg) {
		int len = msg.getBytes().length;
		print(len);
		printContent(msg);
		print(len);
	}
}

class StarDiagram extends Diagram {
	public StarDiagram(char c) {
		super(c);
	}

	@Override
	protected void print(int size) {
		for(int i=0;i<size+2;i++) {
			System.out.print(c);
		}
		System.out.println();
	}

	@Override
	protected void printContent(String msg) {
		System.out.print("*");
		System.out.print(msg);
		System.out.println("*");
	}
	
}
