package main.java.com.adaptavist;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCountProgram {
    private Map<String, Integer> wordCountMap;

    public WordCountProgram() {
        wordCountMap = new HashMap<>();
    }

    public void readFromInputFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String fileData;
            while ((fileData = reader.readLine()) != null) {
                String[] words = fileData.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map.Entry<String, Integer>> sortByMostOccurrences() {
        return wordCountMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());

    }

    public void printWordCount(List<Map.Entry<String, Integer>> sortedMapList){
        for (Map.Entry<String, Integer> entry : sortedMapList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String filePath = "<Please Provide File Path>";
//        String filePath = "/Users/xubii/Downloads/WordCount/src/main/resources/wordCount.txt";
        WordCountProgram wordCounter = new WordCountProgram();
        wordCounter.readFromInputFile(filePath);
        wordCounter.printWordCount(wordCounter.sortByMostOccurrences());
    }
}

