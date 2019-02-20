import java.util.LinkedList;

public class BreadthFirstTraversal 
{
  public static void main(String[] args) 
  {
    Graph graph= new Graph(4);
    graph.add(0,1);
    graph.add(0,2);
    graph.add(1,2);
    graph.add(2,0);
    graph.add(2,3);
    graph.add(3,3);
	  
   System.out.println("Following is the Breadth first Traversal Starting with index 2");
   
   graph.BFS(2,4);
   
	  
}
	
	
	
}
