package main.java.com.solvd.automation_homework;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

class CustomFileHandler implements AutoCloseable {
    private final FileHandler fileHandler;

    public CustomFileHandler(String fileName, boolean append) throws IOException {
        fileHandler = new FileHandler(fileName, append);
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    @Override
    public void close() {
        if (fileHandler != null) {
            fileHandler.close();
        }
    }

    public void setFormatter(SimpleFormatter formatter) {
        fileHandler.setFormatter(formatter);
    }
}
