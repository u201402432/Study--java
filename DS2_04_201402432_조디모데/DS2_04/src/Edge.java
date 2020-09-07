public abstract class Edge {

	private int _tailVertex ;
	private int _headVertex ;
	
	public Edge(int tail, int head){
		this._headVertex = head ;
		this._tailVertex = tail ;
	}
	

	public void setTailVertex(int aTailVertex){
		this._tailVertex = aTailVertex ;
	}
	
	public int tailVertex(){
		return this._tailVertex ;	
	}
	
	public void setHeadVertex(int aHeadVertex){
		this._headVertex = aHeadVertex ;
	}
	
	public int headVertex(){
		return this._headVertex ;
	}

	public abstract boolean sameEdgeAs(Edge anEdge) ;

}
