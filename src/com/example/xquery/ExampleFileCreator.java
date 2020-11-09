package com.example.xquery;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExampleFileCreator {

    private static final String EXAMPLE_XML = "resources/xml/example.xml";
    private static final String[] STATUS = {"open", "in-progress", "complete", "unknown"};

    public static void main (String... args) throws IOException {
        List<String> items = new ArrayList<>();
        while (items.size() < 9) {
            addExampleItem(items);
        }
        PrintWriter writer = new PrintWriter(EXAMPLE_XML);
        writer.write("<?xml version=\"1.0\"?>\n<items>\n");
        items.forEach(item -> writer.write("\t" + item + "\n"));
        writer.write("</items>");
        writer.flush();
        writer.close();
    }

    private static void addExampleItem(List<String> items) {
        int index = items.size() + 1;
        String randomStatus = STATUS[new Random().nextInt(4)];
        String item = String.format("<item id=\"item-%d\" status=\"%s\" name=\"Item #%d\">This is a content of Item #%d</item>", index, randomStatus, index, index);
        items.add(item);
    }
}
