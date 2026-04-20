package com.example.parsers;

import com.example.gamestate.filestructure.FileSystemEntry;
import com.example.parsers.strategies.ParsingFileStrucure;

public class FileStructureParser extends Parser<FileSystemEntry> {

    private static FileStructureParser instance;

    private FileStructureParser() {
        super(new ParsingFileStrucure());
    }
    
    public static FileStructureParser getInstance() {
        if (instance == null) {
            instance = new FileStructureParser();
        }
        return instance;
    }

    @Override
    public FileSystemEntry parse(String resource) {
        return getParseStrategy().parse(resource);
    }
}
