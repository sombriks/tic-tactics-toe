package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.CardService;
import io.sombriks.templates.layouts.MainLayout;
import org.jetbrains.annotations.NotNull;

public class CardController {

    private final CardService cardService;
    private final MainLayout mainLayout;

    public CardController(CardService cardService, MainLayout mainLayout) {
        this.cardService = cardService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
