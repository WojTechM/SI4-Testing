package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    void Should_ReturnSortedWords_When_AllDataIsValid() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("General");
        expectedResult.add("Hello");
        expectedResult.add("Kenobi!");
        expectedResult.add("there!");

        ArrayList<String> loadedWords = new ArrayList<>();

        FileWordAnalyzer analyzer = new FileWordAnalyzer(filePartReader);
        try {
            loadedWords = analyzer.wordsByABC();
        } catch (IOException e) {}

        assertEquals(expectedResult, loadedWords);
    }

    @Test
    void Should_ReturnWordKenobi_When_SearchingSubStringEnobi() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Kenobi!");

        ArrayList<String> loadedWords = new ArrayList<>();

        FileWordAnalyzer analyzer = new FileWordAnalyzer(filePartReader);
        try {
            loadedWords = analyzer.wordsContainingSubString("enobi");
        } catch (IOException e) {}

        assertEquals(expectedResult, loadedWords);
    }

    @Test
    void Should_ReturnWordAbba_When_SearchingForPalindromes() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Abba");

        ArrayList<String> loadedWords = new ArrayList<>();
        filePartReader.setup("src/main/resources/defaultFile.txt", 1, 6);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(filePartReader);
        try {
            loadedWords = analyzer.wordsArePalindrome();
        } catch (IOException e) {}

        assertEquals(expectedResult, loadedWords);
    }

    @Test
    void Should_ReturnEmptyList_When_NoPalindromes() {
        ArrayList<String> expectedResult = new ArrayList<>();

        ArrayList<String> loadedWords = new ArrayList<>();
        filePartReader.setup("src/main/resources/defaultFile.txt", 1, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(filePartReader);
        try {
            loadedWords = analyzer.wordsArePalindrome();
        } catch (IOException e) {}

        assertEquals(expectedResult, loadedWords);
    }

}