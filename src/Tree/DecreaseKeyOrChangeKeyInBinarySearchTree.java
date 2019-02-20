package Tree;

public class DecreaseKeyOrChangeKeyInBinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = insert(tree.root, 50);
		tree.root = insert(tree.root, 30);
		tree.root = insert(tree.root, 20);
		tree.root = insert(tree.root, 40);
		tree.root = insert(tree.root, 70);
		tree.root = insert(tree.root, 60);
		tree.root = insert(tree.root, 80);
		
		InOrder(tree.root);
		
	    changeKey(tree,40,10);
		System.out.println("After changing the value");
		
		InOrder(tree.root);
		

		
	}

	private static void changeKey(BinarySearchTree tree, int i, int j) 
	{
	  tree.root= deleteNode(tree.root,i);
	
	  tree.root=insert(tree.root, j);
		
		
//		return tree;
	}

	private static Node deleteNode(Node root, int key) 
	{
            if(root==null)
            	return root;
            
            if(root.data<key)
            {
            	root.right=deleteNode(root.right, key);
            	
            }
            else if(root.data>key)
            {
            	root.left=deleteNode(root.left, key);
            	
            }
            else
            {
            	if(root.left==null)
            	{
            		return root.right;
            	}
            	else if(root.right==null)
            	{
            		return root.left;
            	}
            	
            	root.data= maximum(root.left);
            	
            	root.left= deleteNode(root.left,root.data);
            	
            	
            }
		
		
		
		return root;
	}

	private static int maximum(Node root) 
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		
		return root.data;
	}

	private static void InOrder(Node root) 
	{
		if(root==null)
		return ;
		
		if(root.left!=null)
			InOrder(root.left);
		System.out.print(root.data+" ");
		
		if(root.right!=null)
			InOrder(root.right);
		
		
	}

	private static Node insert(Node root, int i) {
		if (root == null) {
			Node n = new Node(i);
			return n;

		}
		if (root.data < i) {
			root.right = insert(root.right, i);

		} else {

			root.left = insert(root.left, i);
		}

		return root;
	}
}
