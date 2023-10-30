package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (size == elements.length) {
			int newCapacity = elements.length * 2;
			elements = Arrays.copyOf(elements, newCapacity);

//			E[] newElements = (E[]) new Object[elements.length*2];
//			System.arraycopy(elements, 0, newElements, 0, size);

		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element.?/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		E replacedElement = elements[i];
		elements[i] = e;
		return replacedElement;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == elements.length) {
			growSize();
		}
//		for (int j = size; j > i; j--) {
//            elements[j] = elements[j - 1];
//        }

		System.arraycopy(elements, i, elements, i + 1, size - i);

		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removeElements = elements[i];

//		for (int j = i; j < size - 1; j++) {
//            elements[j] = elements[j + 1];
//        }

		System.arraycopy(elements, i + 1, elements, i, size - i - 1);

		elements[size - 1] = null;
		size--;
		return removeElements;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
//		Arrays.fill(elements, null);
		size = 0;
	}

	// It is used to return the index in this list of the
// last occurrence of the specified element, or-1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		int re = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				re = i;
			}
		}
		return re;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> cloneList = new MyArrayList<>(elements.length);
		cloneList.size = this.size;
		cloneList.elements = Arrays.copyOf(this.elements, this.elements.length);
		return cloneList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or-1 if the List does not contain this element.
	public int indexOf(E o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean removeFirst(E e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index);
			return true;
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static <E> void printArrayList(MyArrayList<Integer> list) {

		System.out.print("[");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i < list.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		// Sử dụng vòng for để in thay cho phương thức
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}

		// Test growSize()
		System.out.print("Testing growSize(): ");
		printArrayList(list);
		System.out.println();

		// Test size()
		System.out.println("Size: " + list.size());
		System.out.println();

		// Test isEmpty()
		System.out.println("Is list empty ? " + list.isEmpty());
		System.out.println();

		// Test get() method
		System.out.println("Element at index 10: " + list.get(10));
		System.out.println();

		// Test set()
		System.out.println("Replaced element: " + list.set(13, 14));
		printArrayList(list);
		System.out.println();

		// Test add()
		list.add(15);
		System.out.print("Add 15 to list : ");
		printArrayList(list);
		System.out.println();

		// Test Add(Index,x)
		list.add(13, 13);
		System.out.print("Add 13 to Index 13 : ");
		printArrayList(list);
		System.out.println();

		// Test remove()
		System.out.println("Removed element: " + list.remove(14));
		printArrayList(list);
		System.out.println();

		// Test clear()
		list.clear();
		System.out.print("List after clear: ");
		printArrayList(list);
		System.out.println();

		// Test lastIndexOf()
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(40);
		list.add(30);
		list.add(20);
		list.add(10);
		list.add(60);
		list.add(80);

		System.out.println("Last index of '10': " + list.lastIndexOf(10));
		printArrayList(list);
		System.out.println();

		// Test toArray()
		Object[] array = list.toArray();
		System.out.println("Array: " + Arrays.toString(array));
		System.out.println();

		// Test clone() method
		MyArrayList<Integer> cloneList = list.clone();
		System.out.print("Clone list: ");
		printArrayList(cloneList);
		System.out.println();

		// Test contains()
		System.out.println("Does list contain '50' ? " + list.contains(50));
		System.out.println("Does list contain '70' ? " + list.contains(70));
		System.out.println();

		// Test indexOf()
		System.out.println("Index of '40': " + list.indexOf(40));
		System.out.println("Index of '70': " + list.indexOf(70));
		System.out.println();

		// Test remove(Index)
		System.out.println("Removed element: " + list.removeFirst(30));
		printArrayList(list);
		System.out.println();

		// Test sort()
		Comparator<Integer> comparator = Comparator.naturalOrder();
		list.sort(comparator);
		System.out.println("Sorted list: ");
		printArrayList(list);

	}
}