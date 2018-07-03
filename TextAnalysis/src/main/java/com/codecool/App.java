package com.codecool;

public class App {
    public static void main(String[] args) {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
    }
}
