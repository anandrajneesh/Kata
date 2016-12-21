package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class DeleteIthElement {

    private int array[] = new int[20];
    private int sizeA = 0;
    private int sizeN = 0;

    private Node<Integer> first;
    private Node<Integer> last;

    public static void main(String[] args) {
        try {
            DeleteIthElement x = new DeleteIthElement();
            x.addN(1);
            x.addN(2);
            x.addN(3);
            x.addN(4);
            System.out.println(x.removeN(2));
            System.out.println(x.removeN(2));
            System.out.println(x.removeN(2));
            System.out.println(x.removeN(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addA(int n) {
        array[sizeA++] = n;
    }

    int removeA(int i) {
        int x = array[i - 1];
        for (; i < sizeA; i++) {
            array[i - 1] = array[i];
        }
        array[--sizeA] = 0;
        return x;
    }

    void addN(int n) {
        if (first == null) {
            first = new Node<>(n);
            last = first;
        } else {
            Node<Integer> x = new Node<>(n);
            last.next(x);
            last = x;
        }
        sizeN++;
    }

    int removeN(int i) {
        Node<Integer> n = null;

        if(sizeN == 0 || i > sizeN || i <1) return 0;

        if (i == 1) {
            n = first;
            first = first.getNext();
        } else {
            Node<Integer> prev = null;
            for (n = first; i > 1 && n != null; i--) {
                prev = n;
                n = n.getNext();
            }
            prev.next(n.getNext());
        }
        --sizeN;
        return n.getT();
    }


}
