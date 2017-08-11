package instances;

import exceptions.EmptyFileException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private String regex = "";
    private Pattern sentencePattern = Pattern.compile(regex);


    public String findAllSentencesInGivenText(String text) throws EmptyFileException {
        if (text == null || text.isEmpty()) {
            throw new EmptyFileException();
        }
        StringBuilder builder = new StringBuilder();
        Matcher matcher = sentencePattern.matcher(text);
        while (matcher.find()) {
            builder.append(matcher.group());
        }
        return builder.toString();
    }
}
