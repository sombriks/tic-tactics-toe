package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.WorldMapService;
import org.jetbrains.annotations.NotNull;

public class WorldMapController {

    private final WorldMapService worldMapService;

    public WorldMapController(WorldMapService worldMapService) {
        this.worldMapService = worldMapService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
