import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        Random rand = new Random();
        String filename = "Marlene_datafile.dat"; 

        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write("Random Integers: ");
            for (int i = 0; i < 5; i++) {
                int num = rand.nextInt(100); 
                fw.write(num + " ");
            }
            fw.write("\n");

            fw.write("Random Doubles: ");
            for (int i = 0; i < 5; i++) {
                double d = rand.nextDouble() * 100;
                fw.write(String.format("%.2f ", d));
            }
            fw.write("\n\n");

            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }
}