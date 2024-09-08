package io.sombriks.services;

import io.sombriks.configs.Database;

public class SettingsService {

    private final Database database;

    public SettingsService(Database database) {
        this.database = database;
    }
}
