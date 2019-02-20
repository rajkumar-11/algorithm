package Tree;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class CloneABinaryTreeRandomPointers {
	public static void main(String[] args) {
		BinaryTreeRandom tree = new BinaryTreeRandom();

		tree.root = new NodeRandom(1);
		tree.root.left = new NodeRandom(2);
		tree.root.right = new NodeRandom(3);
		tree.root.left.left = new NodeRandom(4);
		tree.root.left.right = new NodeRandom(5);
		tree.root.random = tree.root.left.right;
		tree.root.left.left.random = tree.root;
		tree.root.left.right.random = tree.root.right;
		// tree.root.left.right.right = new NodeRandom(5);

		System.out.println("InOrder Traversal");
		Inorder(tree.root);

		System.out.println();

		NodeRandom root = clone(tree.root);

		System.out.println("InOrder Traversal of cloned binary tree is ");

		Inorder(root);

	}

	private static NodeRandom clone(NodeRandom root) {
		if (root == null)
			return null;

		Map<NodeRandom, NodeRandom> map = new HashMap<>();

		NodeRandom node = cloneLeftRight(root, map);
		copyRandom(root, node, map);

		return node;
	}

	private static void copyRandom(NodeRandom root, NodeRandom node, Map<NodeRandom, NodeRandom> map) {
		if (node == null)
			return;
		node.random = map.get(root);
		copyRandom(root.left, node.left, map);
		copyRandom(root.right, node.right, map);

	}

	private static NodeRandom cloneLeftRight(NodeRandom root, Map<NodeRandom, NodeRandom> map)
	{
		if (root == null)
			return null;

		NodeRandom node = new NodeRandom(root.data);
		map.put(root.random, node.random);

		node.left = cloneLeftRight(root.left, map);
		node.right = cloneLeftRight(root.right, map);

		return node;
	}

	private static void Inorder(NodeRandom root) {
		if (root == null)
			return;

		Inorder(root.left);
		System.out.print(root.data + "  " + root.random + " , ");
		Inorder(root.right);

	}
}
