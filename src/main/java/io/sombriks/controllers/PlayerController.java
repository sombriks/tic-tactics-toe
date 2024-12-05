package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.PlayerService;
import org.jetbrains.annotations.NotNull;

public class PlayerController {

    private final PlayerService playerService;
//    private final MainLayout mainLayout;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void index(@NotNull Context context) {
//        PlayersPage playersPage = new PlayersPage();
//        context.html(mainLayout.layout(playersPage).render());
    }

    public void find(@NotNull Context context) {

    }
}
