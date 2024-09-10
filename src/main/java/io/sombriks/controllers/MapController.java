package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.models.GameMap;
import io.sombriks.services.MapService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.MapsPage;
import org.jetbrains.annotations.NotNull;

public class MapController {

    private final MapService mapService;
    private final MainLayout mainLayout;
    
    public MapController(MapService mapService, MainLayout mainLayout) {
        this.mapService = mapService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
        Long mapId = context.queryParamAsClass("id", Long.class).getOrDefault(1L);
        GameMap map = mapService.find(mapId);
        MapsPage mapsPage = new MapsPage(map); // dynamic content maybe
        context.html(mainLayout.layout(mapsPage).render());
    }

    public void find(@NotNull Context context) {
    }
}
