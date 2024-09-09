package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.DeckService;
import io.sombriks.templates.layouts.MainLayout;
import org.jetbrains.annotations.NotNull;

public class DeckController {

    private final DeckService deckService;
    private final MainLayout mainLayout;

    public DeckController(DeckService deckService, MainLayout mainLayout) {
        this.deckService = deckService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
