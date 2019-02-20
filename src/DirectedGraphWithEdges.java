
public class DirectedGraphWithEdges {
	int V,E;
	static Edge[] edge = null;

	public DirectedGraphWithEdges(int V, int E) {
		this.V = V;
		this.E=E;
		this.edge = new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]= new Edge();
		}

	}

}
