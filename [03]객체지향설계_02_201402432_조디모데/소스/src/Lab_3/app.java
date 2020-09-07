package Lab_3 ;
public class app {
	int _month ;
	String _special ;
	card card ;

	public void run(){
		System.out.println("Ä«µå »Ì±â¸¦ ½ÃÀÛÇÕ´Ï´Ù.");
		System.out.println("Card : ¿ù °áÁ¤");
		this._month = this.setMonth() ;
		System.out.println("Card : ÆÐ °áÁ¤");
		this._special = this.setSpecial(this._month) ;
		
		this.card = new card(this._month, this._special) ;
		
		System.out.println(card.toString());

	}

	private int setMonth(){
		return (int)(Math.random()*12)+1 ;
	}

	private String setSpecial(int month){

		int num = (int)(Math.random()*4) ;
		String str ;
		switch(month){
		case 1 :
		case 3 :
			String[] str1 = {"±¤","¶ì","ÇÇ","ÇÇ"} ;
			str = str1[num] ;
			break ;
		case 8 :
			String[] str2 = {"±¤","¿­","ÇÇ","ÇÇ"} ;
			str = str2[num] ;
			break ;
		case 9 : 
			String[] str3 = {"½ÖÇÇ","¶ì","ÇÇ","ÇÇ"} ;
			str = str3[num] ;
			break ;
		case 11 :
			String[] str4 = {"±¤","½ÖÇÇ","ÇÇ","ÇÇ"} ;
			str = str4[num] ;
			break ;
		case 12 :
			String[] str5 = {"±¤","¿­","¿­","½ÖÇÇ"} ;
			str = str5[num] ;
			break ;
		default :
			String[] str6 = {"¿­","¶ì","ÇÇ","ÇÇ"} ;
			str = str6[num] ;
			break ;
		}
		
		return str ;
	}

}
