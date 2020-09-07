public class Node<Key extends Comparable, Obj> {
	private Element<Key, Obj> _element;
	private Node<Key, Obj> _next;

	public Node() {
		this._element = null;
		this._next = null;
	}

	public Node(Key aKey) {
		this._element = new Element(aKey);
		this._next = null;
	}

	public Node(Key aKey, Obj anObject) {
		this._element = new Element(aKey);
		this._element.setObject(anObject);
		this._next = null;
	}

	public Key key() {
		return this._element.key();
	}

	public void setKey(Key aKey) {
		this._element.setKey(aKey);
	}

	public Obj object() {
		return this._element.object();
	}

	public void setObject(Obj anObject) {
		this._element.setObject(anObject);
	}

	public Node next() {
		return this._next;
	}

	public void setNext(Node aNode) {
		this._next = aNode;
	}
}