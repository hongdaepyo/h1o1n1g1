package part02;

import java.util.Random;

public class ServiceImp implements Service{
	
	private String name;
	private int age;
	private String dept;
	private Random ran;
	//private int ran;
	
	public ServiceImp() {
		
	}
	
	public ServiceImp(String name){
		this.name=name;
	}
	
	public ServiceImp(int age, String dept){
		this.age=age;
		this.dept=dept;
	}
	
	public ServiceImp(Random ran){
		this.ran=ran;
	}

	@Override
	public void prn1() {
		System.out.println("name:"+name);
		
	}

	@Override
	public void prn2() {
		System.out.println("age :"+ age);
		System.out.println("dept :"+ dept);
		
	}

	@Override
	public void prn3() {
		System.out.printf("ran=%d\n", ran.nextInt());
		
	}

}
