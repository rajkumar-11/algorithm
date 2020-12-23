import java.util.LinkedList;

class Node1
{
	int data;
	Node1 left,right;
	
 public Node1(int data)
 {
	this.data=data;
	this.left=null;
	this.right=null;
	 
 }
	
	
}

public class BreadthFirstTraversal
{
  public static void main(String[] args) 
  {
	Node1 root= new Node1(1);
	root.left=new Node1(2);
	root.right=new Node1(3);
	root.left.left= new Node1(4);
	root.left.right= new Node1(5);
	root.right.left= new Node1(6);
	root.right.right= new Node1(7);
	BFS(root);
  
}

private static void BFS(Node1 root) 
{
	LinkedList<Node1>list= new LinkedList<>();
	list.add(root);
	while(!list.isEmpty())
	{
		Node1 node=list.pollFirst();
		System.out.print(node.data+" ");
		if(node.left!=null)
		  list.add(node.left);
		if(node.right!=null)
		  list.add(node.right);
				
	}
	
	
	
	
	
}
	
	
}
