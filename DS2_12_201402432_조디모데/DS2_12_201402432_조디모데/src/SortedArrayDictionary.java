public class SortedArrayDictionary<Key extends Comparable, Obj> {
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Element<Key, Obj>[] _element;

	public SortedArrayDictionary() {
		this._maxSize = this.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = new Element[this._maxSize];
	}

	public SortedArrayDictionary(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = new Element[this._maxSize];
	}

	public boolean isEmpty() {
		return this._size == 0;
	}

	public boolean isFull() {
		return this._size == this._maxSize;
	}

	public int size() {
		return this._size;
	}

	public boolean keyDoesExist(Key aKey) {
		if (this.isEmpty())
			return false;
		else {
			for (int i = 0; i < this._size; i++)
				if (this._element[i].key() == aKey)
					return true;
		}
		return false;
	}

	public Obj objectForKey(Key aKey) {
		for (int i = 0; i < this._size; i++)
			if (this._element[i].key() == aKey)
				return this._element[i].object();
		return null;
	}

	public Obj removeObjectForKey(Key aKey) {
		Element removedElement = null;
		for (int i = 0; i < this._size; i++)
			if (this._element[i].key() == aKey) {
				removedElement.setObject(this._element[i].object());

				for (int j = i; j < this._size; j++)
					this._element[j] = this._element[j + 1];
				this._element[this._size - 1] = null;
				this._size--;
				break;
			}
		return (Obj) removedElement;
	}

	public boolean addKeyandObject(Key aKey, Obj anObject) {
		if (!this.keyDoesExist(aKey)) {
			for (int i = 0; i < this._size; i++) {
				if (this._element[i].compareTo(aKey) > 0) {
					for (int j = this._size; j > i; j--) {
						this._element[j] = this._element[j - 1];
					}
					this._element[i].setObject(anObject);
					return true;
				}
			}
		}
		return false;

	}

	public boolean replaceObjectForKey(Obj newObject, Key aKey) {
		for (int i = 0; i < this._size; i++)
			if (this._element[i].key() == aKey) {
				this._element[i].setObject(newObject);
				return true;
			}
		return false;
	}

	public void clear() {
		this._size = 0;
		this._element = null;
	}
}
