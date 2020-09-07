import java.util.ArrayList;
import java.util.Iterator;

public class Application {

	private AppView _appView ;
	private AdjacencyMatrixGraph _graph ;
	private DijkstraShortestPaths _dijkstrashortestPaths;

	public Application(){
		this._appView = new AppView() ;
	}

	public void run(){
		this.showMessage(MessageID.Notice_StartProgram);

		if ( this.inputAndMakeGraph() ) {
			this.showGraph() ;
			this._dijkstrashortestPaths = new DijkstraShortestPaths(this._graph);
			this._dijkstrashortestPaths.perform();
			this.showDijkstraShortestDistance();
			this.showDijkstraShortestPath();
		}
		else {
			this._appView.outputMessage(MessageID.Error_FailInputGraph);
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}

	private boolean inputAndMakeGraph(){
		// �׷��� ������ �Է¹���, �������� �Էµ� �׷����� ����Ͽ� ������
		int countEdges ;
		int numOfVertices ;
		int numOfEdges ;

		this._appView.outputMessage("- �׷����� vertex, edge, cost �� �Է� �޾ƾ� �մϴ�.\n") ;
		this._appView.outputMessage("? �׷����� vertex ���� �Է� �Ͻÿ� : ") ;
		numOfVertices = this._appView.inputNumber() ;
		this._appView.outputMessage("? �׷����� edge ���� �Է� �Ͻÿ� : ") ;
		numOfEdges = this._appView.inputNumber() ;

		this._graph = new AdjacencyMatrixGraph(numOfVertices) ;

		countEdges = 0 ;
		this._appView.outputMessage("- �׷����� edge�� �ݺ��Ͽ� " + numOfEdges + "�� �Է� �޾ƾ� �մϴ�.\n");
		this._appView.outputMessage("	�ϳ��� edge�� (vertex1 vertex2 cost) �� ������ ǥ�õ˴ϴ�.\n");
		this._appView.outputMessage("? Edge�� �Է��Ͻÿ� : ") ;

		while(true){

			DirectedEdge anEdge = new DirectedEdge(this._appView.inputNumber(), 
					this._appView.inputNumber(), this._appView.inputNumber() );
			if(anEdge.cost() > 0 && this._graph.addEdge(anEdge)){
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

	private void showDijkstraShortestDistance() {
		int i = 0 ;
		this._appView.outputMessage(MessageID.Notice_ShowDistance);
		DijkstraShortestPaths.ShortestPathsIterator dijkstraShortestPathsIterator
		= this._dijkstrashortestPaths.shortestPathsIterator() ;
		while(dijkstraShortestPathsIterator.hasNext()){
			this._appView.outputShortestDistance(i, dijkstraShortestPathsIterator.next());
			i++ ;
		}
		this._appView.outputMessage("\n") ;

	}

	private void showDijkstraShortestPath() {

		this._appView.outputMessage(MessageID.Notice_ShowPath);
		for(int i=1 ; i<this._graph.numOfVertices() ; i++){
			ArrayList<Integer> resultShortestPath = this._dijkstrashortestPaths.findPath(0, i, null) ;
			Iterator<Integer> arrayListIterator = resultShortestPath.iterator() ;

			this._appView.outputPrintPathFirst(arrayListIterator.next()) ;

			while(arrayListIterator.hasNext()){
				this._appView.outputPrintPath(arrayListIterator.next()) ;
			}
			this._appView.outputMessage("\n") ;
		}
		this._appView.outputMessage("\n") ;

	}

	public void showGraph(){
		// Graph�� showGraph() �Լ� ȣ��
		this._graph.showGraph() ;
	}	

	private void showMessage(MessageID aMessageID) {
		this._appView.outputMessage(aMessageID);
	}



} // class End
