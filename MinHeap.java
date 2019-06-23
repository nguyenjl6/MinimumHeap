
public class MinHeap <E extends Comparable<? super E>> {
	private E[] heap;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 8;

	@SuppressWarnings("unchecked")
	public MinHeap(int capacity) {
		
		 heap = (E[]) new Comparable[capacity];
		 
		 }
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public boolean IsEmpty() {
		return size == 0;
	}
	
	private void expand() {
		 E[] newHeap = (E[]) new Comparable[heap.length * 2];
		 for (int i = 0; i < size(); i++) {
			 
			 newHeap[i] = heap[i];
		 }
		 heap = newHeap;
		 }
	
	private void swapElements(int p1, int p2) {
		
		 E temp = heap[p1];
		 heap[p1] = heap[p2];
		 heap[p2] = temp;
		 }
	
	private int getParentIndex(int childIndex) {
		
		 // if odd, child is a left node
		 if (childIndex % 2 != 0) {
		 return childIndex / 2;
		 		}
		 // if even, child is a right node
		 else {
		 return childIndex / 2 - 1;
		 		}
		}
	
	public void insert(E element) {
		int position = size();
		
		if(position == heap.length) {
			expand();
		}
		size++;
		heap[position] = element;
		
		int parent = getParentIndex(position);
		
		while (position > 0 && heap[position].compareTo(heap[parent]) < 0) {
			 // if parent is greater, swap parent and node
			 swapElements(parent, position);
			 // update position of the new element and find next parent up
			 position = getParentIndex(position);
			 parent = getParentIndex(position);
			 }
	}
	
	 private int smallerChildIndex(int parent) {

		 int smallest = parent;
		 int leftChild = 2 * parent + 1;
		 int rightChild = 2 * parent + 2;
		 
		 if (leftChild < size() - 1 && heap[leftChild].compareTo(heap[smallest]) < 0 ) {
			
			 smallest = leftChild;
		 }
		 else if (rightChild < size() - 1 && heap[rightChild].compareTo(heap[smallest]) < 0 ) {
			 
			 smallest = rightChild;
		 }
		 return smallest;
		 
		 

		 
		 

	 }


	public E remove() {
		if (IsEmpty()) {
			return null;
		}
		E min = heap[0];
		heap[0] = heap[size() - 1];
		heap[size() - 1] = null;
		size--;
		
		 // position of new root and its smaller child
		 int position = 0;
		 int smallerChild = smallerChildIndex(position);

		 // while there is a smaller child, swap parent and child
		 while (smallerChild != position) {
		 swapElements(position, smallerChild);
		 // update position of node and get new smaller child
		 position = smallerChild;
		 smallerChild = smallerChildIndex(position);
		 }

		 return min;

	}

	

}
