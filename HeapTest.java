
public class HeapTest {

	public static void main(String[] args) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		minHeap.insert(2);
		minHeap.insert(4);
		minHeap.insert(1);
		minHeap.insert(10);
		minHeap.insert(3);
		minHeap.insert(6);
		minHeap.insert(15);
		minHeap.insert(12);
		minHeap.insert(16);
		minHeap.insert(5);
		
		
		while (!minHeap.IsEmpty()) {
			System.out.println(minHeap.remove());
		}
	

	}

}
