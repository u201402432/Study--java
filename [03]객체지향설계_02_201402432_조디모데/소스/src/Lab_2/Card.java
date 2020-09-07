package Lab_2;

public class Card {

	private String shape ;
	private int value;
	
	public Card(String s, int r){
		shape = s;
		value = r;
	}
	
	public void setShape( String s ){
		shape = s;
	}
	public void setValue( int n ){
		value = n;
	}
	public String getShape(){
		return shape;
	}
	public int getValue(){
		return value;
	}
	public String toString(){
		return "shape : "+getShape()+"\nvalue : "+getValue();
	}
}
