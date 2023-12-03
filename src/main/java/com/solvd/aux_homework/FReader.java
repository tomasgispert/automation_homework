package com.solvd.aux_homework;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FReader {
    public static void main(String[] args) {
        try {
            String text = FileUtils.readFileToString(new File("src/main/resources/input.txt"),"UTF-8");
            Set<String> uniqueWords = new HashSet<>();
            uniqueWords.addAll(Arrays.asList(StringUtils.split(text)));
            int uniqueWordCount = uniqueWords.size();
            FileUtils.writeStringToFile(new File("src/main/resources/output.txt"), "Number of unique words: " + uniqueWordCount, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
