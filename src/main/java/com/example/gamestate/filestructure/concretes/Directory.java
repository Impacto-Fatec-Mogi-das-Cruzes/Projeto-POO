package com.example.gamestate.filestructure.concretes;

import java.util.Map;

import com.example.gamestate.filestructure.FileSystemEntry;

public class Directory extends FileSystemEntry {
    
    private Map<String, FileSystemEntry> children;

    public Directory() {}

    public Map<String, FileSystemEntry> getChildren() {
        return children;
    }   
}
