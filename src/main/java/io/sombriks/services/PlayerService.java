package io.sombriks.services;

import io.sombriks.configs.Database;

public class PlayerService {

    private final Database database;

    public PlayerService(Database database) {
        this.database = database;
    }
}
