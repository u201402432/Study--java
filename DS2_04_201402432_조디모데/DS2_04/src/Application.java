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
		// 그래프 정보를 입력받음, 마지막에 입력된 그래프를 출력하여 보여줌
		int countEdges ;
		int numOfVertices ;
		int numOfEdges ;

		this._appView.outputMessage("- 그래프의 vertex, edge 를 입력 받아야 합니다.\n") ;
		this._appView.outputMessage("? 그래프의 vertex 수를 입력 하시오 : ") ;
		numOfVertices = this._appView.inputNumber() ;
		this._appView.outputMessage("? 그래프의 edge 수를 입력 하시오 : ") ;
		numOfEdges = this._appView.inputNumber() ;

		this._graph = new AdjacencyListDirectedGraph(numOfVertices) ;

		countEdges = 0 ;
		this._appView.outputMessage("- 그래프의 edge를 반복하여 " + numOfEdges + "개 입력 받아야 합니다.\n");
		this._appView.outputMessage("	하나의 edge는 (vertex1 vertex2) 의 순서로 표시됩니다.\n");
		this._appView.outputMessage("? Edge를 입력하시오 : ") ;

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
			this._appView.outputMessage("? Edge를 입력하시오 : ");
		}

		return (countEdges == numOfEdges) ;

	}

	public void showGraph(){
		// Graph의 showGraph() 함수 호출
		this._graph.showGraph() ;
	}	

	private void showMessage(MessageID aMessageID) {
		this._appView.outputMessage(aMessageID);
	}



} // class End
