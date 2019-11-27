import java.util.Random;

public class Sort{
    public static <T extends Comparable<? super T>> void heapSort(T[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);
        for (int i = arr.length - 1; i >= 0; i--) {
            swapFandL(arr,i);
            heapify(arr, i, 0);
        }
    }
    private static <T extends Comparable<? super T>> void heapify(T[] array, int arrlen , int root) {
        int maxValue = root;
        int l_c = 2 * root + 1;
        int r_c = 2 * root + 2;
        if (l_c < arrlen )
            if (array[l_c].compareTo(array[maxValue]) > 0)
                maxValue = l_c;
        if (r_c < arrlen )
            if(array[r_c].compareTo(array[maxValue]) > 0)
                maxValue = r_c;
        if (maxValue != root) {
            swap(array,root,maxValue);
            heapify(array, arrlen, maxValue);
        }
    }
    private static <T extends Comparable<? super T>> void swap(T[] array, int root, int maxValue) {
        T temp = array[root];
        array[root] = array[maxValue];
        array[maxValue] = temp;
    }
    private static  <T extends Comparable<? super T>> void swapFandL(T[] array, int last) {
        T temp = array[0];
        array[0] = array[last];
        array[last] = temp;
    }
    public static void main (String[]args){
        Integer[] array = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < array.length;i++) {
            array[i] = random.nextInt(10);
            System.out.print(" " + array[i]);
        }
        System.out.println();
        heapSort(array);
        for (int i = 0; i < array.length;i++) {
            System.out.print(" " + array[i]);
        }

    }

}
