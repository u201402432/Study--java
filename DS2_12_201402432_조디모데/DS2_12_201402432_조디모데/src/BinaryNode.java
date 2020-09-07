public class BinaryNode<Key extends Comparable, Obj> {
	private Element<Key, Obj> _element;
	private BinaryNode<Key, Obj> _left;
	private BinaryNode<Key, Obj> _right;

	public BinaryNode() {
		this._element = null;
		this._left = null;
		this._right = null;
	}

	public BinaryNode(Element anElement) {
		this._element = anElement;
		this._left = null;
		this._right = null;
	}

	public BinaryNode(BinaryNode aLeft, BinaryNode aRight) {
		this._element = null;
		this._left = aLeft;
		this._right = aRight;
	}

	public BinaryNode(Element anElement, BinaryNode aLeft, BinaryNode aRight) {
		this._element = anElement;
		this._left = aLeft;
		this._right = aRight;
	}

	public Element element() {
		return this._element;
	}

	public void setElement(Element anElement) {
		this._element = anElement;
	}

	public BinaryNode left() {
		return this._left;
	}

	public void setLeft(BinaryNode aLeft) {
		this._left = aLeft;
	}

	public BinaryNode right() {
		return this._right;
	}

	public void setRight(BinaryNode aRight) {
		this._right = aRight;
	}

}
