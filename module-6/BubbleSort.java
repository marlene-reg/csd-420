import java.util.Comparator;

public class BubbleSort {

        public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Early exit if no swaps
        }
    }

        public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        // Test 1: Integer array using Comparable
        Integer[] intArray = {4, 1, 3, 9, 2};
        System.out.println("Original Integer array:");
        printArray(intArray);

        bubbleSort(intArray);  // Uses Comparable
        System.out.println("Sorted Integer array (Comparable):");
        printArray(intArray);

        // Test 2: String array using Comparator (reverse order)
        String[] names = {"Charlie", "Alice", "Eve", "Bob"};
        System.out.println("\nOriginal String array:");
        printArray(names);

        bubbleSort(names, Comparator.reverseOrder());  // Uses Comparator
        System.out.println("Sorted String array (Comparator - reverse):");
        printArray(names);
    }
}
