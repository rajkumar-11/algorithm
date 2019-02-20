
public class BellManFordAlgorithm 
{
 public static void main(String[] args) 
 {
	 int V=5;
	 int E=8;
   WeightedGraph graph= new WeightedGraph(V,E);
   
   graph.edge[0].src=0;
   graph.edge[0].dest=1;
   graph.edge[0].weight=-1;
   
   graph.edge[1].src=0;
   graph.edge[1].dest=2;
   graph.edge[1].weight=4;
   
   
   graph.edge[2].src=1;
   graph.edge[2].dest=2;
   graph.edge[2].weight=3;
   
   
   graph.edge[3].src=1;
   graph.edge[3].dest=3;
   graph.edge[3].weight=2;
   
   
   
   graph.edge[4].src=1;
   graph.edge[4].dest=4;
   graph.edge[4].weight=2;
   
   
   graph.edge[5].src=3;
   graph.edge[5].dest=2;
   graph.edge[5].weight=5;
   
   
   graph.edge[6].src=3;
   graph.edge[6].dest=1;
   graph.edge[6].weight=1;
   
   
   graph.edge[7].src=4;
   graph.edge[7].dest=3;
   graph.edge[7].weight=-3;
   
   
   graph.edge[0].src=0;
   graph.edge[0].dest=1;
   graph.edge[0].weight=-1;
   
   graph.BellmanFord(graph,0);
   
   
   
	 System.out.println("change");
	 
	 
	 
}
	
	
}
