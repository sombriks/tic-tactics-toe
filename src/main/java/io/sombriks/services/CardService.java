package io.sombriks.services;

import io.sombriks.configs.Database;

public class CardService {

    private final Database database;

    public CardService(Database database) {
        this.database = database;
    }
}
