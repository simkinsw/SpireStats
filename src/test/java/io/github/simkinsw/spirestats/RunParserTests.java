package io.github.simkinsw.spirestats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RunParserTests {
    @Test
    void testReadFromFile() {
        RunParser parser = new RunParser();
        RunData actualData = parser.readFromFile("src/main/resources/1639586633.run");
        RunData expectedData = new RunData();
        expectedData.play_id = "b3ced172-0a8f-4a58-91bf-1a3e30ecd6d8";
        expectedData.victory = true;
        expectedData.master_deck = actualData.master_deck;

        System.out.println(actualData.master_deck);
        assertEquals(actualData, expectedData);
    }
}
