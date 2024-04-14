package org.example.service;

import org.example.model.FileElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {
    public static List<FileElement> getElements(File element) {
        File[] current = element.listFiles();
        List<FileElement> elements = new ArrayList<>();
        if (current != null) {
            List<File> files = Arrays.asList(current);

            for (int i = 0; i < files.size(); i++) {
                if (files.get(i).isDirectory()) {
                    elements.add(new FileElement(files.get(i).getName(), files.get(i).lastModified(),
                            0l, files.get(i).getPath()));
                } else {
                    elements.add(new FileElement(files.get(i).getName(), files.get(i).lastModified(),
                            files.get(i).length(), files.get(i).getPath()));
                }

            }
        }
        return elements;
    }
}
