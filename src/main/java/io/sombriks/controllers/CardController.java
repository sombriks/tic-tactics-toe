package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.CardService;
import org.jetbrains.annotations.NotNull;

public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
