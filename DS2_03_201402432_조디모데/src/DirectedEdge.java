
public class DirectedEdge extends Edge {
	public DirectedEdge(int givenHeadVertex, int givenTailVertex,
			int givenCost){

		super( givenHeadVertex, givenTailVertex, givenCost);
	}

	@Override
	public boolean sameEdgeAs(Edge anEdge) {
		if(this.tailVertex() == anEdge.tailVertex() && anEdge.headVertex() == this.headVertex())
			return true ;
		else
			return false ;
	}

	
}
