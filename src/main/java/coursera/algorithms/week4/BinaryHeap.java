package coursera.algorithms.week4;

/**
 * Created by Anand_Rajneesh on 10/26/2016.
 */
public class BinaryHeap<T extends Comparable<T>> {

    private T[] heap;
    private int size;

    public BinaryHeap(int n) {
        this.heap = (T[]) new Comparable[n + 1];
    }

    private void checkBounds() {
        if (size >= heap.length - 1) throw new ArrayIndexOutOfBoundsException();
    }

    public void add(T item) {
        checkBounds();
        heap[++size] = item;
        swim();
    }

    public T removeMax() {
        if (size == 0) return null;
        else if (size == 1) {
            T item = heap[1];
            heap[size--] = null;
            return item;
        } else {
            T item = heap[1];
            heap[1] = heap[size];
            heap[size--] = null;
            sink();
            return item;
        }
    }

    private void sink() {
        T violatingItem = heap[1];
        int k = 1;
        while (k * 2 <= size) {
            T child1 = heap[k * 2];
            T child2 = heap[k * 2 + 1];
            int j = k * 2;
            if (child2 != null && child1.compareTo(child2) < 0) {
                j = k * 2 + 1;
            }
            if (violatingItem.compareTo(heap[j]) < 0) {
                heap[k] = heap[j];
                heap[j] = violatingItem;
                k = j;
            } else {
                break;
            }
        }
    }

    private void swim() {
        T newItem = heap[size];
        int k = size;
        while (k > 1 && newItem.compareTo(heap[k / 2]) > 0) {
            heap[k] = heap[k / 2];
            heap[k / 2] = newItem;
            k = k / 2;
        }
    }


    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(9);

        binaryHeap.add(1);
        binaryHeap.add(3);
        binaryHeap.add(10);
        binaryHeap.add(2);
        System.out.println();


    }

}
