import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangMan {
    static ArrayList<Character> playerGuesses = new ArrayList<>();

    //Greatly inspired by "Coding with John" on YouTube

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileReader file = new FileReader();

        file.listOfWords();

        //getting the random word for player to guess
        String word = file.getRandomWord();

        intro();

        //while loop to run until the player guesses wrong six times OR guesses the word correct
        int amountOfTimesPlayerIsWrong = 0;
        while (true) {

            wrongCounter(amountOfTimesPlayerIsWrong);

            if (amountOfTimesPlayerIsWrong >= 6){
                System.out.println("You lose! The word was: " + word);
                break;
            }

            charToDashesConverter(word, playerGuesses);
            if (!playersGuess(scanner, word, playerGuesses)){
                amountOfTimesPlayerIsWrong++;
            }

            if (charToDashesConverter(word, playerGuesses)) {
                break;
            }

            System.out.println("Heres your opportunity to guess the word!");
            if (scanner.nextLine().equals(word)) {
                System.out.println("\nYou win!🥇🥇 Thanks for playing 👋");
                break;
            } else {
                System.out.println("\nSorry, that's not it 😢 Try again!\n");
            }
        }
    }

    //method to print dashes and replace dashes with the letter that the player guesses
    private static boolean charToDashesConverter(String word, List<Character> playerGuesses){
        //counter that checks if the player has guessed all the letters in the word
        int correctCounter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCounter++;

            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCounter);
    }

    //method to get the players guess and add to the Arraylist of guesses
    private static boolean playersGuess(Scanner scanner, String word, List<Character> list){
        System.out.println("Type a letter of your choice:");
        String playerGuess = scanner.nextLine();
        playerGuesses.add(playerGuess.charAt(0));

        return word.contains(playerGuess);

    }

    //method that counts the amount of times player guesses wrong and keeps track of lives left
    private static void wrongCounter(Integer amountOfTimesPlayerIsWrong){
        if (amountOfTimesPlayerIsWrong >= 1){
            System.out.println("XXXXX");
        }
        if (amountOfTimesPlayerIsWrong >= 2){
            System.out.println("XXXX");
        }
        if (amountOfTimesPlayerIsWrong >= 3){
            System.out.println("XXX");
        }
        if (amountOfTimesPlayerIsWrong >= 4){
            System.out.println("XX");
        }
        if (amountOfTimesPlayerIsWrong >= 5){
            System.out.println("X");
        }
        if (amountOfTimesPlayerIsWrong >= 6){
            System.out.println("You have 0 lives left!\n" );
        }
    }

    //method with all the text for the intro
    private static void intro(){
        System.out.println("________________________________________");
        System.out.println("          Welcome to HANGMAN            ");
        System.out.println("________________________________________");
        System.out.println("You will start with 6 lives.\nEverytime you guess the LETTER wrong, you will lose one life.\nLives will be shown as \"X\" in the console.\n");
        System.out.println("Your word has been chosen, it's time to guess.\n");
    }
}



