package com.solvd.aux_homework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FReader {
    public static void main(String[] args) {
        try {
            List<String> lines = FileUtils.readLines(new File("src/main/resources/1.txt"));
            System.out.println(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
