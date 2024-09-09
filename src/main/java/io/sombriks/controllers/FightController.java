package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.FightService;
import io.sombriks.templates.layouts.MainLayout;
import org.jetbrains.annotations.NotNull;

public class FightController {

    private final FightService fightService;
    private final MainLayout mainLayout;

    public FightController(FightService fightService, MainLayout mainLayout) {
        this.fightService = fightService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
