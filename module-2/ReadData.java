import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        String filename = "Marlene_datafile.dat"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading data from " + filename + ":\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
}