package java0727_inner_thread.prob;

import java.io.ObjectOutputStream.PutField;
import java.util.Stack;

/*
 * [문제1] 자판기 프로그램을 만드시오

클래스명 : VendingMachine
               +getDrink():String
               +putDrink(drink String):void
클래스명 : Producer      <-- Thread상속
클래스명 : Consumer     <-- Thread상속
클래스명 : Prob001_thread.java
               VendingMachine vm=new VendingMachine();
     
               Producer p=new Producer(vm);
               Consumer c=new Consumer(vm);
     
		       Thread t1=new Thread(p, "생산자");
		       Thread t2=new Thread(c, "소비자");
		 
		       t1.start();
		       t2.start();
=============================================     
[출력화면]
생산자 : 음료수 No. 1 자판기에 넣기
소비자 : 음료수 No. 1 꺼내먹음
 
생산자 : 음료수 No. 2 자판기에 넣기
소비자 : 음료수 No. 2 꺼내먹음

생산자 : 음료수 No. 3 자판기에 넣기
소비자 : 음료수 No. 3 꺼내먹음
        :
        
생산자 : 음료수 No. 10 자판기에 넣기
소비자 : 음료수 No. 10 꺼내먹음 

 */
class VendingMachine{
	Stack store = new Stack();

	public synchronized String getDrink() {
		while (store.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return store.pop().toString();
	}

	// For producer(생산)
	public synchronized void putDrink(String drink) {		
		store.push(drink);		
		notifyAll();
	}
}
class Producer extends Thread{
	VendingMachine vm=new VendingMachine();
	public Producer(VendingMachine vm) {
		this.vm=vm;
	}
	public Producer(String name) {
		super(name);
		
	}
	@Override
	public void run() {
		
		for(int i=1;i<=10;i++){
		System.out.printf("%s : 음료수 NO. %d 자판기에 넣기\n",Thread.currentThread().getName(),i);
		vm.putDrink("음료수 NO. "+i);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
}//end Producer
class Consumer extends Thread{
	VendingMachine vm=new VendingMachine();

	public Consumer(VendingMachine vm) {
		this.vm=vm;
	}
	public Consumer(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
		System.out.printf("%s : %s 자판기에 꺼내먹음\n",Thread.currentThread().getName(),vm.getDrink());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}//end Consumer

public class Prob001_thread {

	public static void main(String[] args) {
		
		VendingMachine vm=new VendingMachine();
	     
        Producer p=new Producer(vm);
        Consumer c=new Consumer(vm);

	       Thread t1=new Thread(p, "생산자");
	       Thread t2=new Thread(c, "소비자");
	 
	       t1.start();
	       t2.start();

	}

}
