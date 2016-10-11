package simple03;

public class MessageBeanKorea implements MessageBean{
	public MessageBeanKorea() {
		
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요,"+ name +"님!!!");
		
	}

}//end class
