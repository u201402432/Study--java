import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	private int [] _predecessorCount ; // �� vertex�� ���� �������� ����
	private Stack<Integer>_zeroCountVertices ; // �����ڰ� ���� vertex�� ����Ʈ
	private ArrayList<Integer> _sortedList ; // sort�� vertex ������ �����ϴ� ����Ʈ
	private AdjacencyListDirectedGraph _graph;

	public TopologicalSort(AdjacencyListDirectedGraph givenGraph ){
		this._graph = givenGraph ;
		createAndSetPredecessorCount() ;
		int numOfVerticesInGraph = givenGraph.numOfVertices() ;
		this._zeroCountVertices = new Stack<Integer>() ;
		pushVerticesWithNoPredecessors() ;
		this._sortedList = new ArrayList<Integer> (numOfVerticesInGraph) ;
	}

	public ArrayList<Integer> sortedList(){
		return this._sortedList ;
	}

	public boolean perform(){
		
		int tail, head ;
		this.showPredecessorCount() ;
		while(!this._zeroCountVertices.isEmpty()){
			tail = this._zeroCountVertices.pop() ;

			System.out.println("- Pop & Output : "+ tail) ;
			this._sortedList.add(tail);
			AdjacencyListDirectedGraph.AdjacentVerticesIterator iterator
			= this._graph.adjacentVerticesIterator(tail) ;
			while(iterator.hasNext()){
				head = iterator.next() ;
				if(head==-1)
					break ;
				
				this._predecessorCount[head]-- ;
				if(this._predecessorCount[head]==0)
					this._zeroCountVertices.push(head) ;
			}

			this.showPredecessorCount();
			this.showZeroCountVertices() ;

		}

		return (this._sortedList.size() == this._graph.numOfVertices() );
	}

	private void pushVerticesWithNoPredecessors() {
		for(int i= 0 ; i<this._graph.numOfVertices() ; i++)
			if(this._predecessorCount[i]==0)
				this._zeroCountVertices.push(i) ;
	}

	private void createAndSetPredecessorCount() {
		
		this._predecessorCount = new int[this._graph.numOfVertices()] ;
		for(int i=0 ; i<this._graph.numOfVertices() ; i++){
			AdjacencyListDirectedGraph.AdjacentVerticesIterator iterator 
				= this._graph.adjacentVerticesIterator(i) ;
			while(iterator.hasNext()){
				int num = iterator.next() ;
				if(num!=-1)
					this._predecessorCount[num]++ ;			
			}
		}
	
		
	}

	private void showZeroCountVertices() {
		System.out.print("- ��� ������  vertex���� stack : <Top>") ;
		Stack tmp = (Stack)this._zeroCountVertices.clone() ;
		while(!tmp.isEmpty())
			System.out.print(tmp.pop()+" ");
		System.out.println("<Bottom>");
	}

	private void showPredecessorCount() {
		System.out.println("- �� vertex�� ���� vertex �� : ");
		int i = 0 ;
		
		while(i<this._predecessorCount.length){
			System.out.print("["+i+"] "+this._predecessorCount[i]);
			i++ ;
			System.out.println();
		}
	}

	

}
