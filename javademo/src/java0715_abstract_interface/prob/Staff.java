package java0715_abstract_interface.prob;
public class Staff extends Person {

	public Staff(String name, String jumin) {
		super(name, jumin);
	}

	@Override
	public char gender() {
		// 주민번호를 이용해서 성별을 구한후 반환하는 로직을 구현하세요.
		
		if(jumin.charAt(6)=='1'||jumin.charAt(6)=='3'){
			return '남';
		}else{
			return '여';
		}
		
	}

	@Override
	public int getYear() {
		// 주민번호를 이용한 년도4자리를 구한후 반환하는 로직을 구현하세요.
		if(jumin.charAt(6)=='2'||jumin.charAt(6)=='1'){
			return 1900+Integer.parseInt(jumin.substring(0,2));
		}else
		return 2000+Integer.parseInt(jumin.substring(0,2));
	}

	@Override
	public int getMonth() {		
		return Integer.parseInt(getJumin().substring(2,4));
	}

	@Override
	public int getDATE() {		
		return Integer.parseInt(getJumin().substring(4,6));
	}

}// end Staff






