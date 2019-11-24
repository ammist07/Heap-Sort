import java.util.Random;

public class HeapSort {
    public static <T extends Comparable<? super T>> void heapSort(T[] array){
        int c = array.length;
        int tracer = array.length-1;
        while (c > 0){
            maxHeap(array, c, tracer);
            swap(array,c-1);
            c--;
            tracer--;
        }
    }
    private static <T extends Comparable<? super T>> void maxHeap(T[] array, int c, int tracer){
        int lastnode = (c/2)-1;
        for(int i = lastnode; i >=0; i--){
            T root = array[i];
            if(exists(array,(2*i)+2) && !((2*i)+2 > tracer)){
                T right_child = array[(2*i)+2];
                T left_child = array[(2*i)+1];
                if(left_child.compareTo(right_child)>=0){
                    if(left_child.compareTo(root)>=0){
                        T temp = root;
                        array[i] = left_child;
                        array[(2*i)+1] = root;
                    }
                }
                else if(right_child.compareTo(left_child)>=0){
                    if(right_child.compareTo(root)>=0){
                        T temp = root;
                        array[i] = right_child;
                        array[(2*i)+2] = root;
                    }
                }
            }
            else {
                T left_child = array[(2 * i) + 1];
                if (left_child.compareTo(root) >= 0) {
                    T temp = root;
                    array[i] = left_child;
                    array[(2 * i) + 1] = root;
                }
            }
        }
    }
    private static <T extends Comparable<? super T>> boolean exists(T[] arr,int index){
        if(index >= arr.length)
            return false;
        else
            return true;
    }
    private  static <T extends Comparable<? super T>> void swap(T[] arr, int index){
        T temp = arr[0];
        arr[0] = arr[index];
        arr[index] = temp;
    }
    public static void main(String[] args){
        Integer[] array = {1,2,3,6,8,9,4,3,1,7,4,3,2,1,0,6,5,4,3,2,1};

        heapSort(array);
        for(Integer i : array){
            System.out.print(" " + i );
        }

    }
}
