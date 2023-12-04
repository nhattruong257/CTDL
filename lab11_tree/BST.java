package lab11_tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null)
			root = new BNode<E>(e);
		else
			root.add(e);
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	public int depth(E node) {
		return root.depth(node);
	}

	public int height() {
		return root.height();
	}

	public int size() {

		if (root == null)
			return 0;
		else
			return root.size();
	}

	public boolean contains(E e) {
		return root.contains(e);
	}

	public E findMin() {
		if (root == null)
			return null;
		return root.findMin();
	}

	public E findMax() {
		if (root == null)
			return null;
		return root.findMax();
	}

	public boolean remove(E e) {
		return root.remove(root, e);
	}

	public List<E> descendants(E data) {
		return root.descendants(data);
	}

	public List<E> ancestors(E data) {
		List<E> re = new ArrayList<E>();
		root.ancestors(data, re);
		return re;
	}

	public void inorder() {
		root.inorder();
		System.out.println();
	}

	public void preorder() {
		root.preorder();
		System.out.println();
	}

	public void postorder() {
		root.postorder();
		System.out.println();
	}

	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		tree.add(5);
		tree.add(2);
		tree.add(6);
		tree.add(1);
		tree.add(7);
		tree.add(3);
		tree.add(10);
		System.out.println("This tree contains 5 is " + tree.contains(5));
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		System.out.println("Tree's height is " + tree.height() + ", node 5's depth is " + tree.depth(5));
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		System.out.println("Min: " + tree.findMin() + "; Max: " + tree.findMax());
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		System.out.println("Descendants of node 6: " + tree.descendants(6));
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		System.out.println("Ancestors of node 10: " + tree.ancestors(10));
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		System.out.print("Inorder Traversal before removing node 5: ");
		tree.inorder();

		System.out.print("Preorder Traversal before removing node 5: ");
		tree.preorder();

		System.out.print("Postorder Traversal before removing node 5: ");
		tree.postorder();
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

		tree.remove(5);

		System.out.print("Inorder Traversal after removing node 5: ");
		tree.inorder();

		System.out.print("Preorder Traversal after removing node 5: ");
		tree.preorder();

		System.out.print("Postorder Traversal after removing node 5: ");
		tree.postorder();

	}
}
