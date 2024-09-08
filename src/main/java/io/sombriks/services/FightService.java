package io.sombriks.services;

import io.sombriks.configs.Database;

public class FightService {

    private final Database database;

    public FightService(Database database) {
        this.database = database;
    }
}
