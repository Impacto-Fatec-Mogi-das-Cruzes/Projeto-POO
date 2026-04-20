package com.example.gamestate.filestructure;

import com.example.gamestate.filestructure.concretes.Directory;
import com.example.gamestate.filestructure.concretes.TextFile;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Directory.class, name = "directory"),
        @JsonSubTypes.Type(value = TextFile.class, name = "text")
})
public abstract class FileSystemEntry {

    private String type;
    private FileMetadata metadata;

    public FileMetadata getMetadata() {
        return metadata;
    }

    public String getType() {
        return type;
    }
}
