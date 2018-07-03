package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWordAnalyzer {

    private FilePartReader partReader;

    public FileWordAnalyzer(FilePartReader partReader) {
        this.partReader = partReader;
    }

    public ArrayList<String> wordsByABC() throws IOException {
        ArrayList<String> result;
        String requestedText = partReader.readLines();
        result = new ArrayList<>(Arrays.asList(requestedText.split("\\s+")));
        Collections.sort(result);
        return result;
    }

    public ArrayList<String> wordsContainingSubString(String searchedSubstring) throws IOException {
        ArrayList<String> words;
        String requestedText = partReader.readLines();
        words = new ArrayList<>(Arrays.asList(requestedText.split("\\s+")));
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.contains(searchedSubstring)) {
                result.add(word);
            }
        }
        return result;
    }

    public ArrayList<String> wordsArePalindrome() throws IOException {
        ArrayList<String> words;
        String requestedText = partReader.readLines();
        words = new ArrayList<>(Arrays.asList(requestedText.split("\\s+")));
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if(word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
                result.add(word);
            }
        }
        return result;
    }
}
