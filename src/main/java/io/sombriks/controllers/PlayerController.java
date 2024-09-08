package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.PlayerService;
import org.jetbrains.annotations.NotNull;

public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
