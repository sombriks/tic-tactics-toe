package io.sombriks.services;

import io.sombriks.configs.Database;

public class ChallengeService {

    private final Database database;

    public ChallengeService(Database database) {
        this.database = database;
    }
}
