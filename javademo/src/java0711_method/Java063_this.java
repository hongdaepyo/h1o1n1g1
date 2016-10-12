package java0711_method;

/*
 * this:객체자신을 의미한다.
 * this.멤버변수
 * this.메소드()
 * this( )
 */


class CustomerList{
	String name;
	char gen;
	String addr;
	
	public CustomerList(){
		//생성자 안에서 생성자 호출
		this("홍길동",'남',"충청남도");
	}
	
	public CustomerList(String name, char gen, String addr){
		//멤버변수와 매개변수가 이름이 같을때는 멤버변수 앞에 this키워드를 사용한다.
		this.name=name;
		this.gen=gen;
		this.addr=addr;
	}
	
	public void prn(){
		System.out.printf("%s %c %s\n",name,gen,addr);
	}
		
	public void call(){
		//메소드안에서 다른 메소드 호출
		this.prn();
		//prn();
	}
	
	
}//end class

public class Java063_this {

	public static void main(String[] args) {
		CustomerList cm=new CustomerList("이도룡",'남',"서울 종로구 가산동");
		cm.prn();
		
		CustomerList cs=new CustomerList();
		cs.prn();
		//cs.call();
		System.out.println("//////////////////////");
		CustomerList[] cc=new CustomerList[2];
		//cc[0]=cm;
		cc[0]=new CustomerList("이도룡",'남',"서울 종로구 가산동");
		cc[1]=new CustomerList();
		
		for(int i=0;i<cc.length;i++)
			cc[i].prn();

	}//end main()

}//end class
