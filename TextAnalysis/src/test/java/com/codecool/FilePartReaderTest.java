package com.codecool;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    void Should_ThrowException_When_ToLineIsLessThanFromLine() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {reader.setup("filePath", 10, 1);});
    }

    @Test
    void Should_ThrowException_When_FromLineIsLessThanOne() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () ->
        {reader.setup("filePath", 0, 99);});
    }

    @Test
    void Should_ThrowException_When_InvalidFilePath() {
        FilePartReader reader = new FilePartReader("invalid/File/Path", 1, 2);
        assertThrows(IOException.class, () -> {reader.readLines();});
    }

    @Test
    void Should_LoadFile_When_UsesDefaultProperties() {
        FilePartReader reader = new FilePartReader();
        String fileContent = "Hello there!\n" +
                "\n" +
                "General Kenobi!";
        String loadedFile = "";
        try {
            loadedFile = reader.readLines();
        }catch (IOException e) {}

        assertEquals(fileContent, loadedFile);
    }

    @Test
    void Should_LoadSingleLine_When_FromLineEqualsToLine() {
        FilePartReader reader = new FilePartReader("src/main/resources/defaultFile.txt", 1, 1);
        String expectedResult = "Hello there!";
        String fileContent = "";
        try {
            fileContent = reader.readLines();
        } catch (IOException e) {}

        assertEquals(expectedResult, fileContent);

    }

    @Test
    void Should_LoadTwoLines_When_From1To2() {
        FilePartReader reader = new FilePartReader("src/main/resources/defaultFile.txt", 1, 2);
        String expectedResult = "Hello there!\n";
        String fileContent = "";
        try {
            fileContent = reader.readLines();
        } catch (IOException e) {}

        assertEquals(expectedResult, fileContent);

    }

    @Test
    void Should_LoadThreeLines_When_From2To4() {
        FilePartReader reader = new FilePartReader("src/main/resources/defaultFile.txt", 2, 4);
        String expectedResult = "\nGeneral Kenobi!\n";
        String fileContent = "";
        try {
            fileContent = reader.readLines();
        } catch (IOException e) {}

        assertEquals(expectedResult, fileContent);

    }

}