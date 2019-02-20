package Tree;

public class TreeTraversal 
{

	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Pre  Order traversal of binary tree is ");
		Preorder(tree.root);
		
		System.out.println("In Order traversal of binary tree is ");
		Inorder(tree.root);
		
		System.out.println("Post Order traversal of binary tree is ");
		postOrder(tree.root);
		
		
	}

	private static void postOrder(Node root) {
		if(root==null)
			return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+"  ");
		
		
		
	}

	private static void Inorder(Node root) 
	{
	if(root==null)
		return ;
		
	Inorder(root.left);
	 System.out.print(root.data+"  ");
	 Inorder(root.right);
	
		
	}

	private static void Preorder(Node root) 
	{
	  if(root==null)
		  return;
	  
	  System.out.print(root.data+"  ");
	  Preorder(root.left);
	  Preorder(root.right);
		
	  
		
		
		
	}

	
	

}
