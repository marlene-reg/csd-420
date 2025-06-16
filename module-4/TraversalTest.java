import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TraversalTest {

    public static void main(String[] args) {
        testTraversalPerformance(50000);   // Testing with 50,000 integers

        testTraversalPerformance(500000);  // Testing with 500,000 integers
    }


    public static void testTraversalPerformance(int numIntegers) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < numIntegers; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        long endTime = System.nanoTime();
        System.out.println("Traversal iterator with " + numIntegers + " integers took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        sum = 0;
        for (int i = 0; i < numIntegers; i++) {
            sum += list.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("Traversal get(index) with " + numIntegers + " integers took " + (endTime - startTime) + " nanoseconds");

    
        int expectedSum = numIntegers * (numIntegers - 1) / 2;
        if (sum != expectedSum) {
            throw new AssertionError("Traversal incorrect");
        }
    }
}