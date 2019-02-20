
public class KruskalsAlgorithm 
{
    public static void main(String[] args)
    {
			int V = 4, E = 5;
			WeightedGraph graph = new WeightedGraph(V, E);
			graph.edge[0].src = 0;
			graph.edge[0].dest = 1;
			graph.edge[0].weight = 10;

			graph.edge[1].src = 0;
			graph.edge[1].dest = 2;
			graph.edge[1].weight = 6;

			graph.edge[2].src = 0;
			graph.edge[2].dest = 3;
			graph.edge[2].weight = 5;
			
			graph.edge[3].src = 1;
			graph.edge[3].dest = 3;
			graph.edge[3].weight = 15;
			
			
			graph.edge[4].src = 2;
			graph.edge[4].dest = 3;
			graph.edge[4].weight = 4;

			graph.kruskalMST();
	  
}
	
	
}
