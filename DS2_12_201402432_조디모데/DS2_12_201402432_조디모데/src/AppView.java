import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public void outputResult(int aTestSize, double aTestInsertTime,
			double aTestSearchTime, double aTestRemoveTime) {
		System.out.println("크기 : " + aTestSize + "  삽입 : " + aTestInsertTime
				+ "   검색 : " + aTestSearchTime + "   삭제 : " + aTestRemoveTime);
	}

	public char inputTree() {
		return this._scanner.nextLine().charAt(0);
	}

	public char inputCharacter() {
		return this._scanner.nextLine().charAt(0);
	}

	public void outputTraverse(char anObj) {
		System.out.println(anObj);
	}

	public void nextLine() {
		System.out.println();
	}
}
