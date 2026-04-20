package com.example.service.parsers;

import com.example.service.parsers.strategies.ParsingSettings;
import com.example.core.settings.Settings;

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
