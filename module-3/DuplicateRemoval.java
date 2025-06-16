import java.util.ArrayList;
import java.util.Random;

public class DuplicateRemoval {
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1); 
        }
        
        System.out.println("List (" + originalList.size() + " elements):");
        System.out.println(originalList);
        
       
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
        System.out.println("\nList without duplicates (" + uniqueList.size() + " elements):");
        System.out.println(uniqueList);
    }
    
       public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
}