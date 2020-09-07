import java.util.Arrays;

public class AdjacencyListDirectedGraph {

	private static final int NumOfVertices = 50;
	private Node[] _adjacency;
	private int _numOfVertices;
	private int _numOfEdges;

	public AdjacencyListDirectedGraph(int givenNumOfVertices){		
		this._numOfVertices = givenNumOfVertices ;
		this._numOfEdges = 0 ;
		this._adjacency = new Node[this._numOfVertices] ;
		for(int i=0 ; i<this._numOfVertices ; i++)
			this._adjacency[i] = new Node() ;
	}

	public boolean doesVertexExist(int aVertex){
		if(aVertex>-1 && aVertex<this._numOfVertices)
			return true ;

		return false ;
	}
	public boolean doesEdgeExist(Edge anEdge){
		DirectedEdge anDirectedEdge = (DirectedEdge)anEdge ;
		int headVertex = anDirectedEdge.headVertex() ;
		
		AdjacentVerticesIterator iterator =	this.adjacentVerticesIterator(anDirectedEdge.tailVertex()) ;
		while(iterator.hasNext())
			if(iterator.next()==headVertex)
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

	DirectedEdge anDirectedEdge = (DirectedEdge)anEdge ;
	if(this._adjacency[anDirectedEdge.tailVertex()].get_element()==-1)
		this._adjacency[anDirectedEdge.tailVertex()] = new Node(anDirectedEdge.headVertex()) ;
	else{
		AdjacentVerticesIterator iterator 
			= this.adjacentVerticesIterator(anDirectedEdge.tailVertex()) ;
		while(iterator.hasNodeNext())
			iterator.next() ;
		iterator.getNode().set_next(new Node(anDirectedEdge.headVertex()));
	}
	
	this._numOfEdges++ ;
		return true ;
	}
	
	public void showGraph(){
		int i = 0 ;
		System.out.println();
		AdjacentVerticesIterator iterator ;
		while(i<this._numOfVertices){
			System.out.print("["+i+"] -> ");
			iterator = this.adjacentVerticesIterator(i) ;
			
			while(iterator.hasNext()){
				int vertex = iterator.next() ;
				if(vertex!=-1)
					System.out.print(vertex+" ") ;
			}
			
			i++ ;
			System.out.println();
		}
		
	}
		
	public AdjacentVerticesIterator adjacentVerticesIterator(int givenVertex){
		return new AdjacentVerticesIterator(givenVertex) ;
	}

	public class AdjacentVerticesIterator{
		private Node _nextNode ;
		
		private AdjacentVerticesIterator(int givenVertex){
			this._nextNode = _adjacency[givenVertex] ;
		}
		
		public boolean hasNext(){
			return this._nextNode != null ;
		}
		
		public boolean hasNodeNext(){
			return this._nextNode.get_next() != null ;
		}
		public Node getNode(){
			return this._nextNode ;
		}
		
		public int next(){
			int aVertex = this._nextNode.get_element() ;
			this._nextNode = this._nextNode.get_next() ;
			return aVertex ;
		}
		
	} // Inner class

	
} // class