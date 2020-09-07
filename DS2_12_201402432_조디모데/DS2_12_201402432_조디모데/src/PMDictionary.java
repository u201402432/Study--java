import java.util.Random;

public class PMDictionary {
	private int _maxTestSize;
	private Element<Integer, Integer>[] _element;

	public PMDictionary() {
		this._maxTestSize = 500;
		this._element = new Element[this._maxTestSize];
	}

	public void generateData() {
		Random random = new Random();
		int currentSize = 0;
		while (currentSize < this._maxTestSize) {
			int newData = random.nextInt(this._maxTestSize);
			if (!this.givenDataDoesExist(newData, currentSize)) {
				Element<Integer, Integer> newElement = new Element<Integer, Integer>(
						newData, currentSize);
				this._element[currentSize] = newElement;
				currentSize++;
			}
		}
	}

	public boolean givenDataDoesExist(int newData, int currentDataSize) {
		for (int i = 0; i < currentDataSize; i++)
			if (this._element[i].key() == newData)
				return true;

		return false;
	}

	public TestResult doSortedArray(int testSize) {
		SortedArrayDictionary<Integer, Integer> dic = new SortedArrayDictionary<Integer, Integer>();
		long timeForAdd, timeForSearch, timeForRemove;
		long start, stop;

		timeForAdd = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			start = System.nanoTime();
			dic.addKeyandObject(this._element[testCount].key(),
					this._element[testCount].object());
			stop = System.nanoTime();
			timeForAdd += (stop - start);
		}
		timeForSearch = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer searchObj;
			start = System.nanoTime();
			searchObj = dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (stop - start);
		}
		timeForRemove = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer removedObj;
			start = System.nanoTime();
			removedObj = dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (stop - start);
		}
		return new TestResult(testSize, timeForAdd, timeForSearch,
				timeForRemove);
	}

	public TestResult doSortedLinkedList(int testSize) {
		SortedLinkedDictionary<Integer, Integer> dic = new SortedLinkedDictionary<Integer, Integer>();
		long timeForAdd, timeForSearch, timeForRemove;
		long start, stop;

		timeForAdd = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			start = System.nanoTime();
			dic.addKeyandObject(this._element[testCount].key(),
					this._element[testCount].object());
			
			stop = System.nanoTime();
			timeForAdd += (stop - start);
		}
		timeForSearch = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer searchObj;
			start = System.nanoTime();
			searchObj = dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (stop - start);
		}
		timeForRemove = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer removedObj;
			start = System.nanoTime();
			removedObj = dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (stop - start);
		}
		return new TestResult(testSize, timeForAdd, timeForSearch,
				timeForRemove);
	}

	public TestResult doBinarySearchTree(int testSize) {
		BinarySearchTree<Integer, Integer> dic = new BinarySearchTree<Integer, Integer>();
		double timeForAdd, timeForSearch, timeForRemove;
		long start, stop;

		timeForAdd = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			start = System.nanoTime();
			dic.addKeyandObject(this._element[testCount].key(),
					this._element[testCount].object());
			stop = System.nanoTime();
			timeForAdd += (double) (stop - start);
		}
		timeForSearch = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer searchObj;
			start = System.nanoTime();
			searchObj = dic.objectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForSearch += (double) (stop - start);
		}
		timeForRemove = 0;
		for (int testCount = 0; testCount < testSize; testCount++) {
			Integer removedObj;
			start = System.nanoTime();
			removedObj = dic.removeObjectForKey(this._element[testCount].key());
			stop = System.nanoTime();
			timeForRemove += (double) (stop - start);
		}
		return new TestResult(testSize, timeForAdd, timeForSearch,
				timeForRemove);
	}
}
