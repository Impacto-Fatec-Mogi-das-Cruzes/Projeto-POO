package com.example.core.filestructure.concrete;

import java.util.Map;

import com.example.core.filestructure.FileSystemEntry;

public class Directory extends FileSystemEntry {
    
    private Map<String, FileSystemEntry> children;

    public Directory() {}

    public Map<String, FileSystemEntry> getChildren() {
        return children;
    }   
}
