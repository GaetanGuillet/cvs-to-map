package dev.guillet.csvtomap;

import java.io.*;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Find the csv column separator by checking if the first line contains either , or ; or tabs.
 * It is a simple but very perfectible way to achieve this goal. Be cautious using it
 */
class ColumnSeparatorIdentifier {

    private static final List<Character> separators = List.of(',', ';', '\t');

    static Character findColumnSeparator(byte[] bytes) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)))) {
            return ofNullable(br.readLine()).flatMap(ColumnSeparatorIdentifier::findColumnSeparator).orElseThrow();
        }
    }

    static Character findColumnSeparator(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            return ofNullable(br.readLine()).flatMap(ColumnSeparatorIdentifier::findColumnSeparator).orElseThrow();
        }
    }

    private static Optional<Character> findColumnSeparator(String text) {
        return separators.stream()
                .filter(delimiter -> text.indexOf(delimiter) != -1)
                .findFirst();
    }
}
