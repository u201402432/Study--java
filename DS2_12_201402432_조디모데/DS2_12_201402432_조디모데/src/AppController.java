public class AppController implements VisitEventForTreeTraversal {
	private AppView _appView;
	PMDictionary _pmDictionary;
	private static final int MaxTestSize = 500;
	private static final int FirstTestSize = 100;
	private static final int SizeIncrement = 100;

	public AppController() {
		this._appView = new AppView();
	}

	private void testSortedArray() {
		this.showMessage(MessageID.Notice_ResultSortedArray);
		for (int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary.doSortedArray(testSize);
			this._appView.outputResult(testResult.testSize(),
					testResult.testInsertTime(), testResult.testSearchTime(),
					testResult.testRemoveTime());
		}
	}

	private void testSortedLinkedList() {
		this.showMessage(MessageID.Notice_ResultSortedLinkedList);
		for (int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary
					.doSortedLinkedList(testSize);
			this._appView.outputResult(testResult.testSize(),
					testResult.testInsertTime(), testResult.testSearchTime(),
					testResult.testRemoveTime());
		}
	}

	private void testBinarySearchTree() {
		this.showMessage(MessageID.Notice_ResultBinarySearchTree);
		for (int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary
					.doBinarySearchTree(testSize);
			this._appView.outputResult(testResult.testSize(),
					testResult.testInsertTime(), testResult.testSearchTime(),
					testResult.testRemoveTime());
		}
	}

	public void run() {
		this.showMessage(MessageID.Notice_StartProgram);
		this._pmDictionary = new PMDictionary();
		this._pmDictionary.generateData();
		this.testSortedArray();
		this.testBinarySearchTree();
		this.testSortedLinkedList();

		this.showMessage(MessageID.Notice_EndProgram);

		System.out.println();
		this.testTraverse();

	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_ResultSortedArray:
			System.out.println("<< SortedArray로 구현된 Dictionary의 성능측정 결과 >>");
			break;
		case Notice_StartProgram:
			System.out.println("<< 사전 성능측정 프로그램을 시작합니다 >>");
			break;
		case Notice_EndProgram:
			System.out.println("<< 사전 성능측정 프로그램을 종료합니다 >>");
			break;
		case Notice_ResultSortedLinkedList:
			System.out
			.println("<< SortedLinkedList로 구현된 Dictionary의 성능측정 결과 >>");
			break;
		case Notice_ResultBinarySearchTree:
			System.out
			.println("<< BinarySearchTree로 구현된 Dictionary의 성능측정 결과 >>");
			break;
		case Notice_InorderTraverse:
			System.out.print(">> INORDER TRAVERSE : ");
			break;
		case Notice_PreorderTraverse:
			System.out.print(">> PREORDER TRAVERSE : ");
			break;
		case Notice_PostorderTraverse:
			System.out.print(">> POSTORDER TRAVERSE : ");
			break;
		default:
			break;

		}
	}

	private void testTraverse() {
		BinarySearchTree<Integer, Character> binaryTree = new BinarySearchTree<Integer, Character>();
		char value = 'A';
		int[] input = new int[] { 50, 30, 70, 10, 40, 60, 80, 0, 20 };
		for (int i = 0; i < input.length; i++)
			binaryTree.addKeyandObject(input[i], value++);

		this._appView.nextLine();
		binaryTree.showDictionary();

		binaryTree.setCallerForVisitEvent(this);
		this._appView.nextLine();

		this.showMessage(MessageID.Notice_InorderTraverse);
		binaryTree.inOrder();
		this._appView.nextLine();

		this.showMessage(MessageID.Notice_PreorderTraverse);
		binaryTree.preOrder();
		this._appView.nextLine();

		this.showMessage(MessageID.Notice_PostorderTraverse);
		binaryTree.postOrder();
		this._appView.nextLine();

	}

	@Override
	public void processVisitByCallback(Object anObj) {
		this._appView.outputTraverse((Character) anObj);
	}
}
