public abstract class Edge {

	private int _tailVertex ;
	private int _headVertex ;
	private int _cost ;
	
	public Edge(int givenHeadVertex, int givenTailVertex, int givenCost){
		this._headVertex = givenHeadVertex ;
		this._tailVertex = givenTailVertex ;
		this._cost = givenCost ;
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
	
	public void setCost(int aCost){
		this._cost = aCost ;
	}
	
	public int cost(){
		return this._cost ;
	}
	
	public abstract boolean sameEdgeAs(Edge anEdge) ;

}
