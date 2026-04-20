package com.example.core.filestructure.concretes;

import com.example.core.filestructure.FileSystemEntry;

public class TextFile extends FileSystemEntry {

    private String content;
    
    public TextFile() {}

    public String getContent() {
        return content;
    }
}
