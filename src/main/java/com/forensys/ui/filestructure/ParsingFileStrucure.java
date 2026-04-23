package com.forensys.ui.filestructure;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forensys.common.parser.ParsingStrategy;
import com.forensys.core.filestructure.FileSystemEntry;

// File Structure Parsing Strategy
public class ParsingFileStrucure implements ParsingStrategy<FileSystemEntry> {
    @Override
    public FileSystemEntry parse(String resource) {
        FileSystemEntry data = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = getClass().getResourceAsStream("/filestructure/" + resource);
            if (is == null) {
               throw new RuntimeException("File not found");
            }
            data = mapper.readValue(is, FileSystemEntry.class);
        } catch (Exception e) {
            System.err.println(e);
        }
        return data;
    }
}
