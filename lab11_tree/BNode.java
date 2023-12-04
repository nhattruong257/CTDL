package lab11_tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void add(E e) {
		int compareResult = e.compareTo(data);
		if (compareResult > 0) {
			if (right == null)
				right = new BNode<E>(e);
			else
				right.add(e);
		}
		if (compareResult < 0) {
			if (left == null)
				left = new BNode<E>(e);
			else
				left.add(e);
		}
		if (compareResult == 0)
			return;
	}

	public int depth(E node) {
		int compareResult = node.compareTo(data);
		if (compareResult == 0)
			return 0;
		else if (compareResult < 0 && left != null) {
			return 1 + left.depth(node);
		} else if (compareResult > 0 && right != null) {
			return 1 + right.depth(node);
		} else {
			return -1;
		}
	}

	public int height() {
		if (left == null && right == null) {
			return 0;
		} else if (left == null) {
			return 1 + right.height();
		} else if (right == null) {
			return 1 + left.height();
		} else {
			return 1 + Math.max(left.height(), right.height());
		}
	}

	public int size() {
		if (data == null)
			return 0;
		if (left == null && right == null)
			return 1;
		if (left == null && right != null)
			return 1 + right.size();
		if (left != null && right == null)
			return 1 + left.size();
		return 1 + left.size() + right.size();
	}

	public boolean contains(E e) {
		int compareResult = e.compareTo(data);
		if (compareResult == 0)
			return true;
		else
			return (compareResult < 0) ? left.contains(e) : right.contains(e);
	}

	public E findMin() {
		return (left == null) ? data : left.findMin();
	}

	public E findMax() {
		return (right == null) ? data : right.findMax();
	}

//	public BNode<E> findNode(E node) {
//		int compareResult = node.compareTo(data);
//		if (compareResult == 0)
//			return this;
//		else if (compareResult > 0) {
//			if (right == null)
//				return null;
//			return right.findNode(node);
//		}
//
//		else if (compareResult < 0) {
//			if (left == null)
//				return null;
//
//			return left.findNode(node);
//		}
//		return null;
//	}

//	public void timphuhuynh(BNode<E> them) {
//
//		if (left != null)
//			left.timphuhuynh(them);
//		if (left == null)
//			left = them;
//
//	}

	public boolean remove(BNode<E> root, E value) {
		if (contains(value)) {
			root = removeNode(root, value);
			return true;
		} else {
			return false;
		}
	}

	public void setLeft(BNode<E> node) {
		this.left = node;

	}

	public void setRight(BNode<E> node) {
		this.right = node;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return this.left;
	}

	public BNode<E> getRight() {
		return this.right;
	}

	public E getData() {
		return data;
	}

	public BNode<E> findSuccessor(BNode<E> node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public BNode<E> removeNode(BNode<E> current, E value) {
		if (current == null) {
			return null;
		}

		int compareResult = value.compareTo(current.getData());

		if (compareResult < 0) {
			current.setLeft(removeNode(current.getLeft(), value));
		} else if (compareResult > 0) {
			current.setRight(removeNode(current.getRight(), value));
		} else {
			if (current.getLeft() == null) {
				return current.getRight();
			} else if (current.getRight() == null) {
				return current.getLeft();
			} else {
				BNode<E> successor = findSuccessor(current.getRight());
				current.setData(successor.getData());
				current.setRight(removeNode(current.getRight(), successor.getData()));
			}
		}
		return current;
	}

	public void addDataToList(List<E> list) {
		if (data != null)
			list.add(data);
		if (right != null)
			right.addDataToList(list);
		if (left != null)
			left.addDataToList(list);
	}

	public void addDescendant(E data1, List<E> list) {
		int compareResult = data1.compareTo(data);
		if (compareResult > 0)
			right.addDescendant(data1, list);
		if (compareResult < 0)
			left.addDescendant(data1, list);
		if (compareResult == 0) {
			if (left != null) {
				left.addDataToList(list);
			}
			if (right != null) {
				right.addDataToList(list);
			}
		}
	}

	public List<E> descendants(E data1) {
		List<E> re = new ArrayList<E>();
		addDescendant(data1, re);
		return re;
	}

	public void ancestors(E data1, List<E> re) {
		if (!contains(data1))
			return;
		int compareResult = data1.compareTo(data);
		if (compareResult > 0) {
			re.add(data);
			if (right != null)
				right.ancestors(data1, re);
		}
		if (compareResult < 0) {
			re.add(data);
			if (left != null)
				left.ancestors(data1, re);
		}
	}

	public void inorder() {
		if (left != null)
			left.inorder();
		if (data == null) {
			System.out.println("NUll");
		} else
			System.out.print(data + " ");
		if (right != null)
			right.inorder();
	}

	public void preorder() {
		if (data != null)
			System.out.print(data + " ");
		if (left != null)
			left.preorder();
		if (right != null)
			right.preorder();
	}

	public void postorder() {
		if (left != null)
			left.postorder();
		if (right != null)
			right.postorder();
		if (data != null)
			System.out.print(data + " ");
	}

	public static void main(String[] args) {

	}

}