package sedgewick.algos.chapterOne.analysisOfAlgorithms;

/**
 * Created by anand_rajneesh on 12/15/2016.
 */
public class BitonicSearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 6, 8, 10, 9, 7, 5, 4, 3};
        int index = findMax(array, 0, 9);
        int num = 0;
        int f = search(num, array, 0, index);
        if (f == -1) f = search(num, array, index, array.length - 1);
        System.out.println(f);
    }

    public static int findMax(int[] array, int lo, int high) {
        int mid = (lo + high) / 2;
        if (isMax(array, mid)) return mid;
        else if (array[mid] > array[mid + 1]) return findMax(array, lo, mid - 1);
        else return findMax(array, mid + 1, high);
    }

    public static boolean isMax(int[] array, int index) {
        return (array[index] > array[index + 1] && array[index] > array[index - 1]);
    }

    public static int search(int num, int[] array, int lo, int high) {
        if (lo == high) return num == array[lo] ? lo : -1;
        int mid = (lo + high) / 2;
        if (array[mid] == num) return mid;
        else if (array[mid] > num) {
            if (array[mid - 1] > array[mid]) {
                return search(num, array, mid + 1, high);
            } else {
                return search(num, array, lo, mid - 1);
            }
        } else {
            if (array[mid - 1] > array[mid]) {
                return search(num, array, lo, mid - 1);
            } else {
                return search(num, array, mid + 1, high);
            }
        }
    }
}
