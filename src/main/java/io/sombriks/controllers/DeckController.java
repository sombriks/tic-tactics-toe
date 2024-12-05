package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.DeckService;
import org.jetbrains.annotations.NotNull;

public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
