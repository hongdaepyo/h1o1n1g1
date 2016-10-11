package simple03;

public class MessageBeanEnglish implements MessageBean{
	public MessageBeanEnglish() {
		
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello,"+ name +"님!!!");
		
	}
}//end class
