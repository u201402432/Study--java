import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Application {

	private AppView _appView ;
	private AdjacencyListDirectedGraph _graph ;
	private TopologicalSort _topologicalSort;

	public Application(){
		this._appView = new AppView() ;
	}

	public void run(){
		if ( this.inputAndMakeGraph() ) {
			this.showGraph() ;
			this._topologicalSort = new TopologicalSort(this._graph);
			this._topologicalSort.perform();
			this.showSortedList();
			this._appView.outputMessage(MessageID.Notice_EndProgram);
		}
		else {
			this._appView.outputMessage(MessageID.Error_FailInputGraph);
		}
	}

	private void showSortedList() {
		// TODO Auto-generated method stub
		this._appView.outputMessage(MessageID.Notice_ShowSortedList);
		ListIterator<Integer> resultListIterator =
				this._topologicalSort.sortedList().listIterator() ;
		while(resultListIterator.hasNext())
			System.out.print(resultListIterator.next()+" ");
		System.out.println();
	}

	private boolean inputAndMakeGraph(){
		// �׷��� ������ �Է¹���, �������� �Էµ� �׷����� ����Ͽ� ������
		int countEdges ;
		int numOfVertices ;
		int numOfEdges ;

		this._appView.outputMessage("- �׷����� vertex, edge �� �Է� �޾ƾ� �մϴ�.\n") ;
		this._appView.outputMessage("? �׷����� vertex ���� �Է� �Ͻÿ� : ") ;
		numOfVertices = this._appView.inputNumber() ;
		this._appView.outputMessage("? �׷����� edge ���� �Է� �Ͻÿ� : ") ;
		numOfEdges = this._appView.inputNumber() ;

		this._graph = new AdjacencyListDirectedGraph(numOfVertices) ;

		countEdges = 0 ;
		this._appView.outputMessage("- �׷����� edge�� �ݺ��Ͽ� " + numOfEdges + "�� �Է� �޾ƾ� �մϴ�.\n");
		this._appView.outputMessage("	�ϳ��� edge�� (vertex1 vertex2) �� ������ ǥ�õ˴ϴ�.\n");
		this._appView.outputMessage("? Edge�� �Է��Ͻÿ� : ") ;

		while(true){

			DirectedEdge anEdge = new DirectedEdge(this._appView.inputNumber(), 
					this._appView.inputNumber());
			if(this._graph.addEdge(anEdge)){
				countEdges ++ ;
			}
			else
				this._appView.outputMessage(MessageID.Error_WrongEdge) ;

			if(countEdges == numOfEdges)
				break ;
			this._appView.outputMessage("? Edge�� �Է��Ͻÿ� : ");
		}

		return (countEdges == numOfEdges) ;

	}

	public void showGraph(){
		// Graph�� showGraph() �Լ� ȣ��
		this._graph.showGraph() ;
	}	

	private void showMessage(MessageID aMessageID) {
		this._appView.outputMessage(aMessageID);
	}



} // class End
