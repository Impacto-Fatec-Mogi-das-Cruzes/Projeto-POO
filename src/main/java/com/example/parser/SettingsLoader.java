package com.example.parser;

import com.example.gamestate.settings.Settings;
import com.example.parser.strategies.ParserSettings;

public class SettingsLoader extends Loader<Settings>{
    private static SettingsLoader instance;

    private SettingsLoader() {
        super(new ParserSettings());
    }

    public static SettingsLoader getInstance() {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    @Override
    public Settings parse(String resourceFile) {
        return getParseStrategy().parse(resourceFile);
    }
    
}
