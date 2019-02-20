package DynamicProgramming;

public class VertexCover {
	public static void main(String[] args) {
		Tree tree = new Tree(20);

		tree.left = new Tree(8);
		tree.left.left = new Tree(4);
		tree.left.right = new Tree(12);
		tree.left.right.left = new Tree(10);
		tree.left.right.right = new Tree(14);
		tree.right = new Tree(22);
		tree.right.right = new Tree(25);

		System.out.println("size of smallest vertex cover is = " + vCover(tree));

	}

	private static int vCover(Tree tree) 
	{
		if (tree == null)
			return 0;

		if ((tree.left == null && tree.right == null))
			return 0;

		int rootIcluded = 1 + vCover(tree.left) + vCover(tree.right);

		int rootExcluded = 0;

		if (tree.left != null)
			rootExcluded = 1 + vCover(tree.left.left) + vCover(tree.left.right);

		if (tree.right != null)
			rootExcluded = rootExcluded + 1 + vCover(tree.right.left) + vCover(tree.right.right);
//		System.out.println("rootExcluded= " + rootExcluded + " rootIncluded= " + rootIcluded);
		
//		 if(rootIcluded<rootExcluded)
//			 System.out.print(tree.data+" ");

		return Math.min(rootExcluded, rootIcluded);
	}

}
