package Array;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueuesMakingPopOperationCostly {
	public static void main(String[] args) {
		Stack2 s = new Stack2();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());

	}

}

class Stack2 {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	static int size = 0;

	public void push(int i) {
		q1.add(i);
		size++;
	}

	public int top()
	{
		Queue<Integer> q = new LinkedList<>();
		if (q1.isEmpty()) 
		{
			return -1;
		}
		while (q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}
		int x = q1.poll();
		q2.add(x);

		q = q1;
		q1 = q2;
		q2 = q;
		return x;

	}

	public void pop() {
		if (q1.isEmpty())
			return;
		while (q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}
		q1.poll();
		Queue<Integer> q = new LinkedList<>();
		q = q1;
		q1 = q2;
		q2 = q;
		size--;

	}

	public int size() {

		return size;
	}

}