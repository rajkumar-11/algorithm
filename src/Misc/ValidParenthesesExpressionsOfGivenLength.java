package Misc;

import java.util.Stack;

public class ValidParenthesesExpressionsOfGivenLength {
	static int count = 0;

	public static void main(String[] args) {
		int n = 8;
		findWays(n);
		System.out.println("Total possible expressions of length " + n + " is " + count);
	}

	private static void findWays(int i) {
		int result = 0;

		Stack<Character> stack = new Stack<>();

		find(0, 0, i, stack);

		// return result;
	}

	private static void find(int i, int j, int n, Stack<Character> stack) {

		// System.out.println("n= "+n);

		if (i > (n / 2) || j > (n / 2) || stack.size() > n)
			return;

		if (i == n / 2 && j == n / 2) {
			Stack<Character> stackcopy = (Stack<Character>) stack.clone();

			if (Possible(stackcopy)) {
				System.out.println(stack.toString());
				count++;
			}

		}

		stack.add(new Character('('));
		find(i + 1, j, n, stack);
		stack.pop();
		stack.add(new Character(')'));
		find(i, j + 1, n, stack);
		stack.pop();

	}

	private static boolean Possible(Stack<Character> stackcopy) {
		int closing = 0;

		while (!stackcopy.isEmpty()) {
			char c = stackcopy.pop();
			if (c == ')')
				closing++;
			else if (c == '(')
				closing--;

			if (closing < 0)
				return false;

		}

		return true;

	}
}
