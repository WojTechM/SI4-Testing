package com.codecool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {
        setup(filePath, fromLine, toLine);
    }

    public FilePartReader() {
        this.filePath = "src/main/resources/defaultFile.txt";
        this.fromLine = 1;
        this.toLine = 3;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if(toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Invalid arguments");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        String result = "";
        while (scanner.hasNextLine()) {
            result += scanner.nextLine() + "\n";
        }
        return result;
    }

    public String readLines() throws IOException {
        String fileContent = read();
        String[] fileLines = fileContent.split("\n");
        String[] requestedLines = Arrays.copyOfRange(fileLines, fromLine - 1, toLine);
        return String.join("\n", requestedLines);
    }
}
