package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void mainOutputDoesNotContainUnexpectedText() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(!output.contains("unexpected"));
    }

    @Test
    void mainOutputHandlesEmptyArgsGracefully() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[0]);

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(output.contains("Hello and welcome!"));
        for (int i = 1; i <= 5; i++) {
            assertTrue(output.contains("i = " + i));
        }
    }
}
