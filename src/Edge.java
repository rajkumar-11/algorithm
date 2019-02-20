class Edge implements Comparable<Edge> {
	int src, dest, weight;


	public void Edge()
	{
		this.src = 0;
		this.dest = 0;
		this.weight = 0;
	}

	@Override
	public int compareTo(Edge arg0) {
		return this.weight-arg0.weight;
		
	}



}