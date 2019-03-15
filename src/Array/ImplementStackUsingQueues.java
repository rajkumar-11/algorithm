package Array;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());
	}
}

class Stack {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	static int size = 0;

	public void push(int i) {
		size++;
		q2.add(i);
		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.remove();

		}

		Queue<Integer> q = new LinkedList<>();
		q = q2;
		q2 = q1;
		q1 = q;

	}

	public int top() {
		if (size == 0)
			return -1;

		return q1.peek();
	}

	public int size() {

		return size;
	}

	public void pop() {
		if (q1.isEmpty())
			return;

		q1.remove();
		size = size - 1;

	}

}
