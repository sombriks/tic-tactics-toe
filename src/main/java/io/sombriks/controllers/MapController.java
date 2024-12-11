package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.models.Board;
import io.sombriks.models.GameMap;
import io.sombriks.services.BoardService;
import io.sombriks.services.GameMapService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MapController {

    private static final Logger LOG = LoggerFactory.getLogger(MapController.class);

    private final GameMapService gameMapService;
    private final BoardService boardService;

    public MapController(GameMapService gameMapService, BoardService boardService) {
        this.gameMapService = gameMapService;
        this.boardService = boardService;
    }

    public void index(@NotNull Context context) {
        LOG.info("index");
        Long mapId = context.queryParamAsClass("id", Long.class).getOrDefault(1L);
        GameMap map = gameMapService.find(mapId);
        List<Board> boards = boardService.list(mapId);
        context.render("index", Map.of("map", map, "boards", boards));
    }

    public void find(@NotNull Context context) {
        LOG.info("find");
        Long mapId = context.pathParamAsClass("mapId", Long.class).getOrDefault(1L);
        GameMap map = gameMapService.find(mapId);
        List<Board> boards = boardService.list(mapId);
        context.render("index", Map.of("map", map, "boards", boards));
    }
}
