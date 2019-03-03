package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {

    private StringProcessor test;
    private String text;
    private String improvedText;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;





    @BeforeEach
    void createObject() {

        text = "This is a test text which contain "
                + "a out an the in or are on ";
        improvedText = "This is test text which contain ";
        test = new StringProcessor();
        test.addToList("a");
        test.addToList("an");
        test.addToList("the");
        test.addToList("in");
        test.addToList("or");
        test.addToList("are");
        test.addToList("on");
        test.addToList("out");


    }

    @Test
    void testReadInputText() {


        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(text.getBytes()));
            Scanner scanner = new Scanner(System.in);
            assertEquals(text, StringProcessor.readInputText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setIn(stdin);
        }

    }

    @Test
    void testShowResults() {

        System.setOut(new PrintStream(outContent));
        test.showResults(text);
        assertEquals(text, outContent.toString(),
                "Error in showResults method");
        System.setOut(originalOut);

    }

    @Test
    void testDeleteArticles() throws IOException {

        assertEquals(improvedText, test.deleteArticles(text),
                "Error deleteArticles doesn't work correct");

    }

    @Test
    void testGetList() {

        List<String> list = Arrays.asList("a", "an", "the", "in",
                "or", "are", "on", "out");

        assertEquals(test.getList(), list, "Error list's "
                + "are not equal's");

    }

}
