package ro.cleancode.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ReadFile {


    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        String singleWord;


        BufferedReader reader = new BufferedReader(new FileReader("C:\\cleancode\\modul 1\\week 2\\hangman-Pikezoid\\Words.txt"));
        String line= reader.readLine();
        List<String> words = new ArrayList<>();

        while(line!=null){
            String[] wordsLine=line.split(",");
            for (String word:wordsLine){
                words.add(word);
            }
            line= reader.readLine();
        }


        Random rand = new Random(System.currentTimeMillis());
        String randomWord = words.get(rand.nextInt(words.size()));
        System.out.println(randomWord);


    }
}









