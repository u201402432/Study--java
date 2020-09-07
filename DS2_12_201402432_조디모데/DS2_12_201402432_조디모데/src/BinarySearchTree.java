public class BinarySearchTree<Key extends Comparable, Obj> {
	private BinaryNode<Key, Obj> _root;
	private int _size;
	private VisitEventForTreeTraversal _callerForVisitEvent;

	public BinarySearchTree() {
		this._root = null;
		this._size = 0;
	}

	private boolean keydoesExistInTree(BinaryNode currentRoot, Key aKey) {
		if (currentRoot == null)
			return false;
		else {
			if (currentRoot.element().key() == aKey)
				return true;
			else if (currentRoot.element().key().compareTo(aKey) > 0)
				return keydoesExistInTree(currentRoot.left(), aKey);
			else
				return keydoesExistInTree(currentRoot.right(), aKey);

		}
	}

	private boolean addKeyAndObjectToSubtree(BinaryNode currentRoot, Key aKey,
			Obj anObject) {
		BinaryNode newNode = null;
		if (currentRoot.element().key().compareTo(aKey) == 0)
			return false;
		else if (currentRoot.element().key().compareTo(aKey) > 0) {
			if (currentRoot.left() == null) {
				newNode = new BinaryNode(new Element(aKey, anObject), null,
						null);
				currentRoot.setLeft(newNode);
				this._size++;
				return true;
			} else
				return addKeyAndObjectToSubtree(currentRoot.left(), aKey,
						anObject);
		} else {
			if (currentRoot.right() == null) {
				newNode = new BinaryNode(new Element(aKey, anObject), null,
						null);
				currentRoot.setRight(newNode);
				this._size++;
				return true;
			} else
				return addKeyAndObjectToSubtree(currentRoot.right(), aKey,
						anObject);
		}
	}

	public boolean keyDoesExist(Key aKey) {
		return this.keydoesExistInTree(this._root, aKey);
	}

	public boolean addKeyandObject(Key aKey, Obj anObject) {
		if (this._root == null) {
			this._root = new BinaryNode(new Element(aKey, anObject), null, null);
			this._size++;
			return true;
		} else
			return addKeyAndObjectToSubtree(this._root, aKey, anObject);
	}

	public Obj objectForKey(Key aKey) {
		boolean found = false;
		BinaryNode currentRoot = this._root;
		while ((!found) && (currentRoot != null)) {
			if (currentRoot.element().key().compareTo(aKey) == 0)
				found = true;
			else if (currentRoot.element().key().compareTo(aKey) > 0)
				currentRoot = currentRoot.left();
			else
				currentRoot = currentRoot.right();
		}
		if (found)
			return (Obj) currentRoot.element().object();
		else
			return null;
	}

	public boolean replaceObjectForKey(Obj newObject, Key aKey) {
		boolean found = false;
		BinaryNode currentRoot = this._root;
		while ((!found) && (currentRoot != null)) {
			if (currentRoot.element().key().compareTo(aKey) > 0)
				currentRoot = currentRoot.left();
			else if (currentRoot.element().key().compareTo(aKey) < 0)
				currentRoot = currentRoot.right();
			else
				found = true;
		}
		if (found) {
			currentRoot.element().setObject(newObject);
			return true;
		} else
			return false;
	}

	public Obj removeObjectForKey(Key aKey) {
		Obj removedObject = null;
		if (this._root == null)
			return null;
		else if (this._root.element().key().compareTo(aKey) == 0) {
			removedObject = (Obj) this._root.element().object();
			if ((this._root.left() == null) && (this._root.right() == null))
				this._root = null;
			else if (this._root.left() == null)
				this._root = this._root.right();
			else if (this._root.right() == null)
				this._root = this._root.left();
			else {
				BinaryNode<Key, Obj> newRoot = removeRightMostOfLeftTree(this._root);
				newRoot.setLeft(this._root.left());
				newRoot.setRight(this._root.right());
				this._root = newRoot;
			}
			this._size--;
			return removedObject;
		} else {
			return removeObjectForKeyFromSubtree(this._root, aKey);
		}
	}

	private Obj removeObjectForKeyFromSubtree(BinaryNode<Key, Obj> currentRoot,
			Key aKey) {
		if (currentRoot.element().key().compareTo(aKey) > 0) {
			BinaryNode<Key, Obj> child = currentRoot.left();
			if (child == null)
				return null;
			else {
				if (child.element().key().compareTo(aKey) == 0) {
					Obj removedObject = (Obj) child.element().object();
					if (child.left() == null && child.right() == null)
						currentRoot.setLeft(null);
					else if (child.left() == null)
						currentRoot.setLeft(child.right());
					else if (child.right() == null)
						currentRoot.setLeft(child.left());
					else {
						BinaryNode<Key, Obj> newChild = removeRightMostOfLeftTree(child);
						newChild.setLeft(child.left());
						newChild.setRight(child.right());
						currentRoot.setLeft(newChild);
					}
					this._size--;
					return removedObject;
				} else {
					return removeObjectForKeyFromSubtree(child, aKey);
				}
			}
		} else {
			BinaryNode<Key, Obj> child = currentRoot.right();
			if (child == null)
				return null;
			else {
				if (child.element().key().compareTo(aKey) == 0) {
					Obj removedObject = (Obj) child.element().object();
					if (child.left() == null && child.right() == null)
						currentRoot.setRight(null);
					else if (child.left() == null)
						currentRoot.setRight(child.left());
					else if (child.right() == null)
						currentRoot.setRight(child.left());
					else {
						BinaryNode<Key, Obj> newChild = removeRightMostOfLeftTree(child);
						newChild.setLeft(child.left());
						newChild.setRight(child.right());
						currentRoot.setLeft(newChild);
					}
					this._size--;
					return removedObject;
				} else
					return removeObjectForKeyFromSubtree(child, aKey);

			}
		}
	}

	private BinaryNode<Key, Obj> removeRightMostOfLeftTree(
			BinaryNode<Key, Obj> currentRoot) {

		BinaryNode<Key, Obj> leftOfCurrentRoot = currentRoot.left();
		if (leftOfCurrentRoot == null)
			return null;
		if (leftOfCurrentRoot.right() == null) {
			currentRoot.setLeft(leftOfCurrentRoot.left());
			return leftOfCurrentRoot;
		} else {
			BinaryNode<Key, Obj> parentOfRightMost = leftOfCurrentRoot;
			BinaryNode<Key, Obj> rightMost = leftOfCurrentRoot.right();
			while (rightMost.right() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			rightMost.setLeft(null);
			return rightMost;
		}
	}

	public void postOrder() {
		this.postOrderRecursively(this._root);
	}

	public void postOrderRecursively(BinaryNode aRoot) {
		if (aRoot != null) {
			this.postOrderRecursively(aRoot.left());
			this.postOrderRecursively(aRoot.right());
			this.visit(aRoot.element());
		} else
			return;
	}

	public void preOrder() {
		this.preOrderRecursively(this._root);
	}

	public void preOrderRecursively(BinaryNode aRoot) {
		if (aRoot != null) {
			this.visit(aRoot.element());
			this.preOrderRecursively(aRoot.left());
			this.preOrderRecursively(aRoot.right());
		}
	}

	public void inOrder() {
		this.inOrderRecursively(this._root);
	}

	public void inOrderRecursively(BinaryNode aRoot) {
		if (aRoot != null) {
			this.inOrderRecursively(aRoot.left());
			this.visit(aRoot.element());
			this.inOrderRecursively(aRoot.right());
		} else
			return;
	}

	private void visit(Element anElement) {
		System.out.print((Character) anElement.object() + "-");
	}

	public void setCallerForVisitEvent(VisitEventForTreeTraversal aCaller) {
		this._callerForVisitEvent = aCaller;

	}

	public void showDictionary() {
		this.showTreeRecursively(this._root, 1);
	}

	private void showTreeRecursively(BinaryNode<Key, Obj> currentNode, int depth) {
		if (currentNode != null) {
			showTreeRecursively(currentNode.right(), depth + 1);
			for (int i = 0; i < depth - 1; i++)
				System.out.print("\t");
			System.out.println("(" + currentNode.element().key() + ", "
					+ (Character) currentNode.element().object() + ")");
			showTreeRecursively(currentNode.left(), depth + 1);
		}
	}
}
