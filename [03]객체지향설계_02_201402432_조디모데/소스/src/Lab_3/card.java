package Lab_3 ;
public class card {
	private int month ;
	private String special ;

	public card(int _month, String _special) {
		this.month = _month ;
		this.special = _special ;
	}

	public void setMonth(int month){
		this.month = month ;
	}

	public int month(){
		return this.month ;
	}

	public void setSpecial(String special){
		this.special = special ;
	}

	public String special(){
		return this.special ;
	}
	
	public String toString(){
		String str = "카드의 월은 "+this.month+" 이고 "+this.special+" 입니다." ;
		return str ; 
	}


}
