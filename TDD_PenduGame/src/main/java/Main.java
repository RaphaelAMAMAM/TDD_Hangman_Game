import java.util.Scanner;

public class Main {

    private final static int TOTAL_ERROR_AVAILABLE = 7;

    public static void main(String[] args) {

        PenduSystem penduSystem = new PenduSystem();
        String wordToFind = penduSystem.getWord();
        String hiddenWord = penduSystem.getTotallyHiddenWord(wordToFind);
        WordGame wordGame = new WordGame(wordToFind, hiddenWord);

        System.out.println("Hey, we'll play ! \n You have 7 chances.");
        System.out.println(wordGame.getWordToDiscover());
        int numberLetterFound = 0;
        int numberFalseLetter = 0;

        while (true) {
            System.out.println("Put a letter :");
            String userInput = getCharacterFromUser();

            if (!penduSystem.letterMatch(userInput, wordGame)) {
                numberFalseLetter++;
                System.out.println(userInput.toUpperCase() + " is not in the word. Please retry." +
                        "\n You still have " + (TOTAL_ERROR_AVAILABLE - numberFalseLetter) + " chances");
                System.out.println(wordGame.getWordToDiscover());
            } else {
                System.out.println("You found the letter " + userInput + " :)");
                System.out.println(penduSystem.replaceWordWithLetter(userInput, wordGame));
                numberLetterFound += penduSystem.countLetterFound(userInput, wordGame);
            }
            if (numberLetterFound == wordGame.getWord().length()) {
                System.out.println("YESSSS, you won. \n Word was " + wordGame.getWord());
                break;
            }
            if (numberFalseLetter == TOTAL_ERROR_AVAILABLE) {
                System.out.println("NOOOO, you lost. \n Word was " + wordGame.getWord());
                break;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static String getCharacterFromUser() {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                return input;
            }
            System.out.println("Error : You have to put one character. \nPlease retry :");
        }
    }
}
