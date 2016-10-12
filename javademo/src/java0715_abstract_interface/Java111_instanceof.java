package java0715_abstract_interface;

class ExamA{
	
}

class ExamB extends ExamA{
	
}

class ExamC extends ExamB{
	
}

class ExamD extends ExamC{
	
}

public class Java111_instanceof {

	public static void main(String[] args) {
		ExamB bb=new ExamB();
		System.out.println(bb instanceof ExamA); //true
		//자기 자신 아니면 부모의 타입
		ExamA aa=new ExamA();
		System.out.println(aa instanceof ExamC); //false

	}//end main()

}//end class
