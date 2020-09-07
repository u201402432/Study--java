import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraShortestPaths {

	private int _numOfVertices ;
	private int[] _distance;
	private AdjacencyMatrixGraph _graph ;
	private int[] _path ;

	public DijkstraShortestPaths(AdjacencyMatrixGraph givenGraph ){
		this._graph = givenGraph ;
		this._numOfVertices = this._graph.numOfVertices() ;
		this._distance = new int[this._numOfVertices] ;
		this._path = new int[this._numOfVertices] ;	
	}

	public void perform(){

		int i, u, w ;
		boolean[] found = new boolean[this._numOfVertices] ;
		Arrays.fill(found, false) ;


		for (i= 0; i< this._numOfVertices; i++) {
			this._distance[i] = this._graph.costOfEdge(0, i) ;
		}
		found[0] = true ;
		this._distance[0] = 0 ;
		
		for (i=0; i< this._numOfVertices-2; i++) {
			u = this.choos(found) ;
			found[u] = true;
			for (w = 0; w < this._numOfVertices; w++) {
				if ( !found[w] ) {
					if(this._graph.costOfEdge(u, w)!=this._graph.maxCost())
						if ( this._distance[w] > this._distance[u] + this._graph.costOfEdge(u, w) ){
							this._distance[w] = this._distance[u] + this._graph.costOfEdge(u, w);
							this._path[w] = u ;
						}
				}
			}
		}

	}

	public ArrayList<Integer> findPath(int start, int end, ArrayList<Integer> pathList){
		if(pathList == null){
			pathList = new ArrayList<Integer> (this._numOfVertices) ;
			pathList.add(start) ;
		}

		if(_path[end] != start)
			pathList = findPath(start, _path[end], pathList) ;

		pathList.add(end) ;
		return pathList ;
	}

	private int choos(boolean[] givenFound){
		int min = 0;
		int[] tmp = this._distance.clone() ;

		for(int i=0 ; i<this._distance.length ; i++)
			if(givenFound[i]==true)
				tmp[i] = this._graph.maxCost() ;

		Arrays.sort(tmp);
		while(true){
			if(this._distance[min]==tmp[0])
				break ;
			min++ ;
		}

		return min ;
	}

	public ShortestPathsIterator shortestPathsIterator(){
		return new ShortestPathsIterator() ;
	}

	public class ShortestPathsIterator{
		private int _next ;

		private ShortestPathsIterator(){
			this._next = 0 ;
		}

		public boolean hasNext(){
			return (this._next != _numOfVertices) ;
		}

		public int next(){
			int next = _distance[this._next] ;
			_next ++ ;
			return next ;
		}

	}

}
