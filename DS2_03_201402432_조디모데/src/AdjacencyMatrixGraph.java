import java.util.Arrays;

public class AdjacencyMatrixGraph {

	private final int MAX_COST = 9999;
	private int[][] _adjacency ;
	private int _numOfVertices;
	private int _numOfEdges;

	
	public AdjacencyMatrixGraph(int givenNumOfVertices){
		
		this._numOfVertices = givenNumOfVertices ;
		this._numOfEdges = 0 ;
		this._adjacency = new int[this._numOfVertices][this._numOfVertices] ;
		for(int i=0 ; i<this._adjacency.length ; i++)
			Arrays.fill(this._adjacency[i], MAX_COST) ;
	}

	public boolean doesVertexExist(int aVertex){
		if(aVertex>-1 && aVertex<this._numOfVertices)
			return true ;

		return false ;
	}
	public boolean doesEdgeExist(Edge anEdge){
		if( this._adjacency[anEdge.headVertex()][anEdge.tailVertex()]!=MAX_COST)
			return true ;
		return false ;
	}

	public int numOfVertices(){
		return this._numOfVertices ;
	}

	public int numOfEdges(){
		return this._numOfEdges ;
	}

	public boolean addEdge(Edge anEdge){
		if(!this.doesVertexExist(anEdge.headVertex()))
			return false ;
		if(!this.doesVertexExist(anEdge.tailVertex()))
			return false ;
		if(this.doesEdgeExist(anEdge))
			return false ;

		this._adjacency[anEdge.headVertex()][anEdge.tailVertex()] = anEdge.cost() ;
		
		return true ;
	}
	
	public void showGraph(){
		int i = 0 ;
		System.out.println();

		while(i<this._adjacency.length ){
			System.out.print("["+i+"] -> ");
			for(int j=0 ; j<this._adjacency[i].length ; j++ )
				if(this._adjacency[i][j]!=this.maxCost())
					System.out.print(j+"("+this._adjacency[i][j]+") ") ;
			System.out.println();
			i++ ;
		}
	}
	
	protected int maxCost(){
		return MAX_COST ;
	}
	
	public int costOfEdge(int aFromVertex, int aToVertex){
		return this._adjacency[aFromVertex][aToVertex] ;
	}
		
	public AdjacentVerticesIterator adjacentVerticesIterator(int givenVertex){
		return new AdjacentVerticesIterator(givenVertex) ;
	}

	public class AdjacentVerticesIterator{
		private int _nextPosition ;
		private int _vertex ;
		
		private AdjacentVerticesIterator(int givenVertex){
			this._nextPosition = 0 ;
			this._vertex = givenVertex ;
		}
		public boolean hasNext(){
			while(_adjacency[this._vertex][this._nextPosition] == MAX_COST 
					&& this._nextPosition != numOfVertices()) ;
			this._nextPosition++ ;
			return (this._nextPosition < numOfVertices()) ;
		}
		
		public DirectedEdge next(){
			DirectedEdge anEdge =
					new DirectedEdge (_vertex, this._nextPosition, _adjacency[this._vertex][this._nextPosition]) ;
			this._nextPosition++ ;
			return anEdge ;
		}
		
	} // Inner class

	
} // class