package dev.guillet.csvtomap;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvToMap {

    public static List<Map<String, ?>> csvToMap(byte[] bytes, Character columnSeparator) throws IOException {
        try (MappingIterator<Map<String, ?>> mappingIterator = csvReader(columnSeparator).readValues(bytes)) {
            return mappingIterator.readAll();
        }
    }

    public static List<Map<String, ?>> csvToMap(File file, Character columnSeparator) throws IOException {
        try (MappingIterator<Map<String, ?>> mappingIterator = csvReader(columnSeparator).readValues(file)) {
            return mappingIterator.readAll();
        }
    }

    private static ObjectReader csvReader(Character columnSeparator) {
        return new CsvMapper()
                .readerFor(Map.class)
                .with(CsvSchema.emptySchema().withHeader().withColumnSeparator(columnSeparator));
    }

}
