package Tree;

public class minimumValueInBST {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		// System.out.println("here");
		tree.root = insert(tree.root, 50);
		tree.root = insert(tree.root, 30);
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 40);
		tree.root = insert(tree.root, 70);
		tree.root = insert(tree.root, 60);
		tree.root = insert(tree.root, 80);
		
		
		System.out.println("Minimum Value is = "+min(tree.root));
		
		

	}

	private static int min(Node root) 
	{
	      int min=root.data;
	      
	      while(root.left!=null)
	      {
	    	  min=root.left.data;
	    	  root=root.left;
	    	  
	      }
		
		
		
		
		return min;
	}

	private static Node insert(Node root, int n) {

		if (root == null) {
			root = new Node(n);
			return root;

		}

		if (root.data > n) {
			root.left = insert(root.left, n);

		} else if (root.data <= n) {
			root.right = insert(root.right, n);
		}

		return root;

	}

}
