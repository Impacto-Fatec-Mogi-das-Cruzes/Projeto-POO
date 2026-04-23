package com.example.core;

import java.util.ArrayDeque;
import java.util.Deque;

import com.example.core.filestructure.DirectorySnapshot;
import com.example.core.filestructure.concrete.Directory;

// TODO: add observer pattern to openTextFile and make scene manager subcriber to make the following flow
/*
Controller -> "Do something" -> Service -> "Use this" -> Core -> {may update Context} -> {notify subscribers} -> Scene Manager -> "Change scene to..."
this flow will be useful for "read" command
*/
public class SystemContext {

    private static SystemContext instance;
    private Directory currentDirectory;
    // private TextFile openTextFile;
    private Deque<DirectorySnapshot> history = new ArrayDeque<>();

    private SystemContext() {
    }

    public static SystemContext getInstance() {
        if (instance == null) {
            instance = new SystemContext();
        }
        return instance;
    }

    public Directory getCurrentDirectory() {
        return this.currentDirectory;
    }

    public void setCurrentDirectory(Directory newDirectory) {
        history.add(currentDirectory.save());
        this.currentDirectory = newDirectory;
    }

    public void restore() {
        DirectorySnapshot snapshot = history.pop();
        snapshot.restore();
    }
}
