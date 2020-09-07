public class SortedLinkedDictionary<Key extends Comparable, Obj> {
	private static final int DEFAULT_INITIAL_CAPACITY = 20;
	private int _maxSize;
	private int _size;
	private Node<Key, Obj> _head;

	public SortedLinkedDictionary() {
		this._maxSize = this.DEFAULT_INITIAL_CAPACITY;
		this._size = 0;
		this._head = null;
	}

	public SortedLinkedDictionary(int aMaxsize) {
		this._maxSize = aMaxsize;
		this._size = 0;
		this._head = null;
	}

	public boolean isEmpty() {
		return this._size == 0;
	}

	public boolean isFull() {
		return this._maxSize == this._size;
	}

	public int size() {
		return this._size;
	}

	public boolean keyDoesExist(Key aKey) {
		Node exNode = this._head;
		while (exNode != null) {
			if (exNode.key() == aKey)
				return true;
			exNode = exNode.next();
		}
		return false;
	}

	public Obj objectForKey(Key aKey) {
		Node exNode = this._head;
		Obj findObj = this._head.object();
		while (exNode != null) {
			if (exNode.key() == aKey)
				return findObj;
			exNode = exNode.next();
		}
		return null;
	}

	public boolean addKeyandObject(Key aKey, Obj anObject) {
		if (!this.keyDoesExist(aKey)) {
			Node newNode = new Node(aKey, anObject);
			Node previousNode = null;
			Node currentNode = this._head;
			if (!isEmpty()) {
				while (currentNode != null) {
					if (currentNode.key().compareTo(aKey) > 0) {
						previousNode.setNext(newNode);
						newNode.setNext(currentNode);
						return true;
					}
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			} else {
				this._head = newNode;
				return true;
			}
		}
		return false;
	}

	public Obj removeObjectForKey(Key aKey) {
		if (this.isEmpty())
			return null;
		else {
			Node previousNode = null;
			Node currentNode = this._head;
			Obj removeObj = this._head.object();

			while (currentNode != null) {
				if (currentNode.key() == aKey) {
					removeObj = (Obj) currentNode.object();
					previousNode.setNext(currentNode);
					return removeObj;
				}
				previousNode = currentNode;
				currentNode = currentNode.next();
			}

			return null;
		}
	}

	public boolean replaceObjectForKey(Obj newObject, Key aKey) {
		if (!this.keyDoesExist(aKey))
			return false;
		else {
			Node exNode = this._head;
			while (exNode != null) {
				if (exNode.key() == aKey) {
					exNode.setObject(newObject);
					return true;
				}
				exNode = exNode.next();
			}
			return false;
		}
	}

	public void clear() {
		this._size = 0;
		this._head = null;
	}

}
