package io.sombriks.services;

import io.sombriks.configs.Database;

public class BoardService {

    private final Database database;

    public BoardService(Database database) {
        this.database = database;
    }
}
