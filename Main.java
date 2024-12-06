package ro.cleancode.academy;
import java.io.*;
import java.util.*;


public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("C:\\cleancode\\modul 1\\week 2\\hangman-Pikezoid\\Words.txt"));
        String line = reader.readLine();
        List<String> words = new ArrayList<>();

        while (line != null) {
            String[] wordsLine = line.split(", ");
            for (String word : wordsLine) {
                words.add(word);
            }
            line = reader.readLine();
        }

          boolean playAgain=true;
        while(playAgain) {
            System.out.println("Welcome to Hangman.");
            Random rand = new Random(System.currentTimeMillis());
            String randomWord = words.get(rand.nextInt(words.size()));
            Set<Character> lettersUsed = new HashSet<>();
            char[] guessedWord = new char[randomWord.length()];
            for (int i = 0; i < randomWord.length(); i++) {
                guessedWord[i] = '_';
            }

            int attemptsLeft = 3;

            Scanner scanner = new Scanner(System.in);

            while (attemptsLeft > 0) {
                System.out.println("Current word: " + String.valueOf(guessedWord));
                System.out.println("Letters used: " + lettersUsed);
                System.out.println("Attempts remaining: " + attemptsLeft);
                System.out.print("Guess a letter: ");
                try {
                    String input = scanner.nextLine();
                    if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                        throw new IllegalArgumentException();
                    }
                    char guess = input.charAt(0);

                    if (lettersUsed.contains(guess)) {
                        System.out.println("You already used that letter.");
                        continue;
                    }

                    lettersUsed.add(guess);

                    boolean found = false;
                    for (int i = 0; i < randomWord.length(); i++) {
                        if (randomWord.charAt(i) == guess) {
                            guessedWord[i] = guess;
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Wrong guess!");
                        attemptsLeft--;
                    }

                    if (String.valueOf(guessedWord).equals(randomWord)) {
                        System.out.println("Congratulations! You've guessed the word: " + randomWord);
                        System.out.println("Want to play again? Y/N");
                        String answer = scanner.nextLine();
                        if (answer.equals("Y")) {
                            playAgain=true;
                        } else if (answer.equals("N")) {
                            System.out.println("Thank you for playing");
                            playAgain=false;
                            break;
                        }
                        else {
                            System.out.println("Invalid Input,Please enter Y or N.");
                            String reply = scanner.nextLine();
                            answer = reply;
                        }

                    }


                    if (attemptsLeft == 0) {
                        System.out.println("Game over! The word was: " + randomWord);
                        System.out.println("Want to play again? Y/N");
                        String answer = scanner.nextLine();
                        if (answer.equals("Y")) {
                            playAgain=true;
                        } else if (answer.equals("N")) {
                            System.out.println("Thank you for playing");
                            playAgain=false;
                            break;
                        }
                        else{
                            System.out.println("Invalid Input,Please enter Y or N.");
                            String reply=scanner.nextLine();
                            answer=reply;
                        }
                    }





                } catch (Exception e) {
                    System.out.println("Invalid Input.Insert a letter.");
                }
            }
        }






    }
}































