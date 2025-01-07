package dev.guillet.csvtomap;

import static dev.guillet.csvtomap.CsvToMap.csvToMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class CsvToMapTest {

    @Test
    void shouldParseCsv() throws IOException {
        var input = new File("src/test/resources/data_with_comma.csv");
        var data = csvToMap(input, ',');
        assertEquals(2, data.size());
        assertEquals(2, data.get(0).size());
        assertEquals(2, data.get(1).size());
    }
}
