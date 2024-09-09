package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.ChallengeService;
import io.sombriks.templates.layouts.MainLayout;
import org.jetbrains.annotations.NotNull;

public class ChallengeController {

    private final ChallengeService challengeService;
    private final MainLayout mainLayout;

    public ChallengeController(ChallengeService challengeService, MainLayout mainLayout) {
        this.challengeService = challengeService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
