package Tree;

public class TrieDelete {
	public static void main(String[] args) {
		String[] key = { "raj", "a", "rajkumar", "answer", "any", "by", "bye", "their", "hero", "heroplane", "herop" };
		int n = key.length;

		TrieNode root = getTrieNode();
		for (int i = 0; i < n; i++) {
			insert(root, key[i], 0, key[i].length());
		}
		System.out.println(search(root, "raj") ? "Yes" : "no");
		System.out.println(search(root, "these") ? "Yes" : "no");
		remove(root, "heroplane");
		System.out.println(search(root, "herop") ? "Yes" : "no");

	}

	private static void remove(TrieNode root, String string) {
		int l = string.length();
		removeUtil(root, string, 0, l);

	}

	private static TrieNode removeUtil(TrieNode node, String string, int index, int length) {
		if (node == null)
			return null;

		// if (node.nodes[branch] == null)
		// return node;

		if (index == length) {
			if (node.isEndOfWord) {
				boolean flag = false;
				for (int i = 0; i < 26; i++) {
					if (node.nodes[i] != null) {
						flag = true;
						break;
					}

				}
				if (flag == false) {
					node = null;
				} else {
					node.isEndOfWord = false;
				}

			}
			return node;

		}
		int branch = string.charAt(index) - 'a';

		if (node.isEndOfWord) {
			node.nodes[branch] = removeUtil(node.nodes[branch], string, index + 1, length);

		} else {
			node = removeUtil(node.nodes[branch], string, index + 1, length);
		}
		return node;

	}

	private static boolean search(TrieNode root, String string) {

		return searchUtil(root, string, 0, string.length());
	}

	private static boolean searchUtil(TrieNode node, String string, int index, int length) {
		if (node == null) {
			return false;
		}
		if (index == length) {
			if (node.isEndOfWord) {
				return true;
			} else {
				return false;
			}

		}
		int branch = string.charAt(index) - 'a';

		if (node.nodes[branch] == null) {
			return false;
		} else {
			return searchUtil(node.nodes[branch], string, index + 1, length);
		}
	}

	private static void insert(TrieNode node, String string, int index, int length) {
		// System.out.println("index= "+ index+" string= "+string);

		if (length == index) {
			node.isEndOfWord = true;
			return;

		}
		int branch = string.charAt(index) - 'a';
		// System.out.println("branch= "+branch);

		if (node.nodes[branch] == null) {
			node.nodes[branch] = getTrieNode();
			insert(node.nodes[branch], string, index + 1, length);

		} else {
			insert(node.nodes[branch], string, index + 1, length);

		}

	}

	private static TrieNode getTrieNode() {
		TrieNode node = new TrieNode();
		for (int i = 0; i < 26; i++) {
			node.nodes[i] = null;
		}
		return node;
	}

}

class TrieNode {
	TrieNode[] nodes = new TrieNode[26];
	boolean isEndOfWord;

}