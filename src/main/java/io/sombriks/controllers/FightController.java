package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.FightService;
import org.jetbrains.annotations.NotNull;

public class FightController {

    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
