package Tree;

// Java program for insertion in AVL Tree 
class NodeAVL { 
	int key, height; 
	NodeAVL left, right; 

	NodeAVL(int d) { 
		key = d; 
		height = 1; 
	} 
} 

class AVLTreeDeletion { 

	NodeAVL root; 

	// A utility function to get the height of the tree 
	int height(NodeAVL N) { 
		if (N == null) 
			return 0; 

		return N.height; 
	} 

	// A utility function to get maximum of two integers 
	int max(int a, int b) { 
		return (a > b) ? a : b; 
	} 

	// A utility function to right rotate subtree rooted with y 
	// See the diagram given above. 
	NodeAVL rightRotate(NodeAVL z) { 
		NodeAVL y = z.left; 
		NodeAVL T2 = y.right; 

		// Perform rotation 
		y.right = z; 
		z.left = T2; 
		
		

		// Update heights 
		z.height = max(height(z.left), height(z.right)) + 1; 
		y.height = max(height(y.left), height(y.right)) + 1; 

		// Return new root 
		return y; 
	} 

	// A utility function to left rotate subtree rooted with x 
	// See the diagram given above. 
	NodeAVL leftRotate(NodeAVL z) { 
		System.out.println("z for left rotation= "+z.key);
		NodeAVL y = z.right; 
		NodeAVL T2 = y.left; 

		// Perform rotation 
		y.left = z; 
		z.right = T2; 

		// Update heights 
		z.height = max(height(z.left), height(z.right)) + 1; 
		y.height = max(height(y.left), height(y.right)) + 1; 
		System.out.println("z height = "+z.height);
		System.out.println("y height ="+y.height);

		// Return new root 
		return y; 
	} 

	// Get Balance factor of nodeavl N 
	int getBalance(NodeAVL N) { 
		if (N == null) 
			return 0; 

		return height(N.left) - height(N.right); 
	} 

	NodeAVL insert(NodeAVL nodeavl, int key) { 

		/* 1. Perform the normal BST insertion */
		if (nodeavl == null) 
			return (new NodeAVL(key)); 

		else if (key < nodeavl.key) 
			nodeavl.left = insert(nodeavl.left, key); 
//		else if (key > nodeavl.key) 
		else
			{
			 if(key==50)
				System.out.println("here");
			
			nodeavl.right = insert(nodeavl.right, key); 
			
			}
//		else // Duplicate keys not allowed 
//			return nodeavl; 

		/* 2. Update height of this ancestor nodeavl */
		nodeavl.height = 1 + max(height(nodeavl.left), 
							height(nodeavl.right)); 

		/* 3. Get the balance factor of this ancestor 
			nodeavl to check whether this nodeavl became 
			unbalanced */
		int balance = getBalance(nodeavl); 
		System.out.println("balance "+balance+" node value ="+nodeavl.key);
//
//		// If this nodeavl becomes unbalanced, then there 
//		// are 4 cases Left Left Case 
//		if (balance > 1 && key < nodeavl.left.key) 
//			return rightRotate(nodeavl); 
//
//		// Right Right Case 
//		if (balance < -1 && key > nodeavl.right.key) 
//			return leftRotate(nodeavl); 
//
//		// Left Right Case 
//		if (balance > 1 && key > nodeavl.left.key) { 
//			nodeavl.left = leftRotate(nodeavl.left); 
//			return rightRotate(nodeavl); 
//		} 
//
//		// Right Left Case 
//		if (balance < -1 && key < nodeavl.right.key) { 
//			nodeavl.right = rightRotate(nodeavl.right); 
//			return leftRotate(nodeavl); 
//		} 
		if (balance > 1 && getBalance(root.left) >= 0) 
			{root.right= rightRotate(root); 
		    return root;}
		
		if (balance < -1 && getBalance(root.right) <= 0) 
			{root.left= leftRotate(root); 
			 return root;
			}

		// Left Right Case 
		if (balance > 1 && getBalance(root.left) < 0) 
		{ 
			root.left = leftRotate(root.left); 
			return rightRotate(root); 
		} 

		// Right Right Case 
		

		// Right Left Case 
		if (balance < -1 && getBalance(root.right) > 0) 
		{ 
			root.right = rightRotate(root.right); 
			return leftRotate(root); 
		} 
		
		

		/* return the (unchanged) nodeavl pointer */
		return nodeavl; 
	} 

	// A utility function to print preorder traversal 
	// of the tree. 
	// The function also prints height of every nodeavl 
	void preOrder(NodeAVL nodeavl) { 
		if (nodeavl != null) { 
			System.out.print(nodeavl.key + " "); 
			preOrder(nodeavl.left); 
			preOrder(nodeavl.right); 
		} 
	} 

	public static void main(String[] args) { 
		AVLTreeDeletion tree = new AVLTreeDeletion(); 

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 20); 
		tree.root = tree.insert(tree.root, 30); 
		tree.root = tree.insert(tree.root, 40); 
		tree.root = tree.insert(tree.root, 50); 
//		tree.root = tree.insert(tree.root, 25); 

		/* The constructed AVL Tree would be 
			30 
			/ \ 
		20 40 
		/ \	 \ 
		10 25 50 
		*/
		System.out.println("Preorder traversal" + 
						" of constructed tree is : "); 
		tree.preOrder(tree.root); 
	} 
} 
// This code has been contributed by Mayank Jaiswal 
