
public class Node {
	private int _element ;
	private Node _next ;
	
	public Node(){
		this._element = -1 ;
		this._next = null ;
	}
	
	public Node(int anElement){
		this._element = anElement ;
		this._next = null ;
	}
	
	public Node(int anElement, Node aNode){
		this._element = anElement ;
		this._next = aNode ;
	}
	
	public int get_element() {
		return _element;
	}

	public void set_element(int _element) {
		this._element = _element;
	}

	public Node get_next() {
		return _next;
	}

	public void set_next(Node _next) {
		this._next = _next;
	}
	
	
}
