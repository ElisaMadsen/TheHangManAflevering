import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class FileReader {
    static Random random = new Random();
    static ArrayList<String> words = new ArrayList<String>();

    public void listOfWords() {

        try {
            Scanner scanner = new Scanner(new File("resources/words.csv"));
            while (scanner.hasNextLine()){
               words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public String getRandomWord(){
        int randomNumber = random.nextInt(words.size());
        String word = words.get(randomNumber);
        return word;
    }
}
