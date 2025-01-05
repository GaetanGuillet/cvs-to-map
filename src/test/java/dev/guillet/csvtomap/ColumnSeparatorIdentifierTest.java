package dev.guillet.csvtomap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;

import static dev.guillet.csvtomap.ColumnSeparatorIdentifier.findColumnSeparator;
import static org.junit.jupiter.api.Assertions.*;

class ColumnSeparatorIdentifierTest {

    @ParameterizedTest
    @CsvSource({
            "data_with_comma.csv, ','",
            "data_with_semicolon.csv, ';'"
    })
    public void shouldFindColumnSeparator(String fileName, Character expectedColumnSeparator) throws IOException {
        var input = new File("src/test/resources/" + fileName);
        var columnSeparator = findColumnSeparator(input);
        assertEquals(expectedColumnSeparator, columnSeparator);
    }

}