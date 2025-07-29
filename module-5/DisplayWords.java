import java.io.*;
import java.util.*;

public class DisplayWords {

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
        return words;
    }

    public static Set<String> getUniqueWords(List<String> words) {
        // Normalize to lowercase for case-insensitive uniqueness
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords;
    }

    public static List<String> sortWordsAscending(Set<String> uniqueWords) {
        List<String> sorted = new ArrayList<>(uniqueWords);
        Collections.sort(sorted);
        return sorted;
    }

    public static List<String> sortWordsDescending(Set<String> uniqueWords) {
        List<String> sorted = new ArrayList<>(uniqueWords);
        sorted.sort(Collections.reverseOrder());
        return sorted;
    }

    public static void displayWords(List<String> words, String order) {
        System.out.println(order + " order:");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";
        List<String> words = readWordsFromFile(filename);
        Set<String> uniqueWords = getUniqueWords(words);

        List<String> ascending = sortWordsAscending(uniqueWords);
        List<String> descending = sortWordsDescending(uniqueWords);

        displayWords(ascending, "Ascending");
        displayWords(descending, "Descending");
    }
}
🧪 3. Test Code Using JUnit
File: WordProcessorTest.java

java
Copy
Edit
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @Test
    void testGetUniqueWords() {
        List<String> input = Arrays.asList("Apple", "apple", "Banana", "BANANA", "orange");
        Set<String> expected = new HashSet<>(Arrays.asList("apple", "banana", "orange"));
        assertEquals(expected, WordProcessor.getUniqueWords(input));
    }

    @Test
    void testSortWordsAscending() {
        Set<String> input = new HashSet<>(Arrays.asList("orange", "banana", "apple"));
        List<String> expected = Arrays.asList("apple", "banana", "orange");
        assertEquals(expected, WordProcessor.sortWordsAscending(input));
    }

    @Test
    void testSortWordsDescending() {
        Set<String> input = new HashSet<>(Arrays.asList("orange", "banana", "apple"));
        List<String> expected = Arrays.asList("orange", "banana", "apple");
        assertEquals(expected, WordProcessor.sortWordsDescending(input));
    }

    @Test
    void testEmptyInput() {
        List<String> emptyList = new ArrayList<>();
        Set<String> unique = WordProcessor.getUniqueWords(emptyList);
        assertTrue(unique.isEmpty());
    }
}