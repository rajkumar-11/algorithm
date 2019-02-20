
public class DepthFirstTraversal
{
 public static void main(String[] args) 
 {
	 Graph  graph= new Graph(5);
	 graph.add(1,0);
	 graph.add(0,2);
	 graph.add(2,1);
	 graph.add(0,3);
	 graph.add(1,4);
	
	 
	 boolean[] visited = new boolean[5];
	 
	 for(int i=0;i<5;i++)
	 {
		 if(!visited[i])
	   graph.DFSDisconnected(i,visited);
	 }
	 
}
	
	
}
