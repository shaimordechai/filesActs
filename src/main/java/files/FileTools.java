package files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class FileTools {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private List<String> lines = new ArrayList<String>();

    public List<String> getLines() {
        return lines;
    }

    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace(); // TODO to file
        }
    }

    public void writeFile(String fileName, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace(); // TODO to file
        }
    }
}
