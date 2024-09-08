package io.sombriks.services;

import io.sombriks.configs.Database;

public class DeckService {

    private final Database database;

    public DeckService(Database database) {
        this.database = database;
    }
}
