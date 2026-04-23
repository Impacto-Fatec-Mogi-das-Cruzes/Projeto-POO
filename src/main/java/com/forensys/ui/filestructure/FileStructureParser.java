package com.forensys.ui.filestructure;

import com.forensys.common.parser.Parser;
import com.forensys.core.filestructure.FileSystemEntry;

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
