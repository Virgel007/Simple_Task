package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuilder {
    private StringBuilder content;
    private final List<StringBuilder> snapshots;

    public MyStringBuilder() {
        this.content = new StringBuilder();
        this.snapshots = new ArrayList<>();
        saveSnapshot();
    }

    public void append(String str) {
        content.append(str);
        saveSnapshot();
    }

    public void insert(int offset, String str) {
        content.insert(offset, str);
        saveSnapshot();
    }

    public void delete(int start, int end) {
        content.delete(start, end);
        saveSnapshot();
    }

    public void undo() {
        if (snapshots.size() > 1) {
            snapshots.remove(snapshots.size() - 1);
            content = snapshots.get(snapshots.size() - 1);
        }
    }

    private void saveSnapshot() {
        snapshots.add(new StringBuilder(content));
    }

    public String toString() {
        return content.toString();
    }
}