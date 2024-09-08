package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.WorldMapService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.MapsPage;
import org.jetbrains.annotations.NotNull;

public class WorldMapController {

    private final WorldMapService worldMapService;

    private final MainLayout mainLayout = new MainLayout();
    
    public WorldMapController(WorldMapService worldMapService) {
        this.worldMapService = worldMapService;
    }

    public void index(@NotNull Context context) {
        MapsPage mapsPage = new MapsPage(); // dynamic content maybe
        context.html(mainLayout.layout(mapsPage).render());
    }

    public void find(@NotNull Context context) {
    }
}
