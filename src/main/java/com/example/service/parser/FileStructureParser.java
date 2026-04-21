package com.example.service.parser;

import com.example.core.filestructure.FileSystemEntry;
import com.example.service.parser.strategy.ParsingFileStrucure;

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
