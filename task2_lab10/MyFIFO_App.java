package task2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back

	public static <E> void stutter(Queue<E> input) {
		// TODO
		ArrayDeque<E> re = new ArrayDeque<E>();
		while (input.size() > 0) {
			E e = input.poll();
			System.out.println(e);
			re.add(e);
			re.add(e);
		}
		input.addAll(re);
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {

		ArrayDeque<E> re1 = new ArrayDeque<E>();
		Stack<E> re2 = new Stack<E>();
		re2.addAll(input);
		System.out.println(re2);
		while (re2.size() > 0) {
			E e = re2.pop();
			input.add(e);
		}
	}

	public static void main(String[] args) {
		Queue<Integer> a = new ArrayDeque<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		stutter(a);
		System.out.println(a);

		System.out.println("---------------------");

		Queue<String> b = new ArrayDeque<String>();
		b.add("a");
		b.add("b");
		b.add("c");
		mirror(b);
		System.out.println(b);
	}
}
