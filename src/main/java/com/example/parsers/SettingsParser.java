package com.example.parsers;

import com.example.gamestate.settings.Settings;
import com.example.parsers.strategies.ParsingSettings;

public class SettingsParser extends Parser<Settings>{
    private static SettingsParser instance;

    private SettingsParser() {
        super(new ParsingSettings());
    }

    public static SettingsParser getInstance() {
        if (instance == null) {
            instance = new SettingsParser();
        }
        return instance;
    }

    @Override
    public Settings parse(String resource) {
        return getParseStrategy().parse(resource);
    }
    
}
