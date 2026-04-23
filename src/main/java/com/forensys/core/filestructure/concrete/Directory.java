package com.forensys.core.filestructure.concrete;

import java.util.Map;

import com.forensys.core.filestructure.FileSystemEntry;

public class Directory extends FileSystemEntry {
    
    private Map<String, FileSystemEntry> children;

    public Directory() {}

    public Map<String, FileSystemEntry> getChildren() {
        return children;
    }

    public void setChildren(Map<String, FileSystemEntry> children) {
        this.children = children;
    }
}
