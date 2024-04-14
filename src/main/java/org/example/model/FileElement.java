package org.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileElement {
    private String path;
    private String name;
    private String date;
    private String size;

    public FileElement(String name, Long date, Long size, String path) {
        this.name = name;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        this.date = dateFormat.format(new Date(date)).toString();
        if (size == 0) {
            this.size = "";
        } else {
            this.size = size.toString() + " B";
        }

        this.path = path;
    }

    public String getName() {
        return size.equals("") ? name + "/" : name;
    }

    public String getDate() {
        return date;
    }

    public String getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }
}
