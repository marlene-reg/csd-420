import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MarleneThreeThreads {
    private static JTextArea textArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Output");
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Thread letterThread = new Thread(() -> outputLetters());
        Thread numberThread = new Thread(() -> outputNumbers());
        Thread symbolThread = new Thread(() -> outputSymbols());

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }

    private static void outputLetters() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            textArea.append(letter + " ");
        }
    }

    private static void outputNumbers() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int number = random.nextInt(10);
            textArea.append(number + " ");
        }
    }

    private static void outputSymbols() {
        Random random = new Random();
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < 10000; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];
            textArea.append(symbol + " ");
        }
    }
}