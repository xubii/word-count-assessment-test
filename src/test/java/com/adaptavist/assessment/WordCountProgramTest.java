package test.java.com.adaptavist.assessment;

import main.java.com.adaptavist.WordCountProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountProgramTest {

    private WordCountProgram wordCounter;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        wordCounter = new WordCountProgram();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void verifyCountOfOccurrencesWord() {
        String filePath = "<File Path>";
        wordCounter.readFromInputFile(filePath); // Replace with your input file
        wordCounter.printWordCount(wordCounter.sortByMostOccurrences());

        String[] expectedOutput = new String[]{"sample: 6", "words: 5", "text: 4"};
        String[] result = outContent.toString().split("\\n"); // split by new lines

        assertAll("",
                () -> assertEquals(expectedOutput[0], result[0]),
                () -> assertEquals(expectedOutput[1], result[1]),
                () -> assertEquals(expectedOutput[2], result[2])
        );

    }

}
