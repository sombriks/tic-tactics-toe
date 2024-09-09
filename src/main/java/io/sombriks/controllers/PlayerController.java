package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.PlayerService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.PlayersPage;
import org.jetbrains.annotations.NotNull;

public class PlayerController {

    private final PlayerService playerService;
    private final MainLayout mainLayout;

    public PlayerController(PlayerService playerService, MainLayout mainLayout) {
        this.playerService = playerService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
        PlayersPage playersPage = new PlayersPage();
        context.html(mainLayout.layout(playersPage).render());
    }

    public void find(@NotNull Context context) {
    
    }
}
