package com.example.gamestate.filestructure.concretes;

import com.example.gamestate.filestructure.FileSystemEntry;

public class TextFile extends FileSystemEntry {

    private String content;
    
    public TextFile() {}

    public String getContent() {
        return content;
    }
}
