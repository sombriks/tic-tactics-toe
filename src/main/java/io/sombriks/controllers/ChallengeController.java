package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.ChallengeService;
import org.jetbrains.annotations.NotNull;

public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
