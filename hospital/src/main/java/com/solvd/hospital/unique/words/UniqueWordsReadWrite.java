package com.solvd.hospital.unique.words;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UniqueWordsReadWrite {
    private static final Logger LOGGER = LogManager.getLogger(UniqueWordsReadWrite.class);

    public static void main(String[] args) throws IOException {
        // read text from a file
        File file = new File("src//main//resources//lights.txt");
        String text = FileUtils.readFileToString(file, "UTF-8");

        // split the text into words and count the unique ones
        String[] words = StringUtils.split(text);
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            // Remove any non-alphanumeric characters from the word
            String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "");

            if (!cleanedWord.isEmpty()) {
                wordCounts.put(cleanedWord, wordCounts.getOrDefault(cleanedWord, 0) + 1);
            }
        }

        int uniqueWordCount = wordCounts.size();

        // write the results to a new file
        File outputFile = new File("src//main//resources//output.txt");
        FileWriter writer = new FileWriter(outputFile);

        writer.write("Number of unique words: " + uniqueWordCount + "\n");

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            writer.write(word + ": " + count + "\n");
        }

        writer.close();

        LOGGER.info("Number of unique words and their counts saved to output.txt");
        LOGGER.info("Number of unique words: " + uniqueWordCount);
    }
}