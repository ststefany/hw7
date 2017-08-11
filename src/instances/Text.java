package instances;

import exceptions.EmptyFileException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static instances.Symbol.LINE_SEPARATOR;

public class Text {
    private String text;
    private String filePath;


    public Text(String filePath) {
        this.text = reader(filePath);
        this.filePath = filePath;
    }

    private String reader(String filePath) {
        StringBuilder builder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(s -> {
                builder.append(s);
                builder.append(LINE_SEPARATOR.getValue());
            });
            if (builder.toString().isEmpty()) {
                throw new EmptyFileException();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
            return null;
        } catch (EmptyFileException e) {
            System.err.println("File is empty");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return builder.toString();
    }

    public String getText() {
        return text;
    }

    public String getFilePath() {
        return filePath;
    }
}
