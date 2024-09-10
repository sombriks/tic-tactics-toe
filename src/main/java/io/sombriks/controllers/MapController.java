package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.models.GameMap;
import io.sombriks.services.GameMapService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.GameMapsPage;
import org.jetbrains.annotations.NotNull;

public class MapController {

    private final GameMapService gameMapService;
    private final MainLayout mainLayout;
    
    public MapController(GameMapService gameMapService, MainLayout mainLayout) {
        this.gameMapService = gameMapService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
        Long mapId = context.queryParamAsClass("id", Long.class).getOrDefault(1L);
        GameMap map = gameMapService.find(mapId);
        GameMapsPage gameMapsPage = new GameMapsPage(map); // dynamic content maybe
        context.html(mainLayout.layout(gameMapsPage).render());
    }

    public void find(@NotNull Context context) {
    }
}
