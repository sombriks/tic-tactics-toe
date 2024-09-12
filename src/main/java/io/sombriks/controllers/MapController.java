package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.models.Board;
import io.sombriks.models.GameMap;
import io.sombriks.services.BoardService;
import io.sombriks.services.GameMapService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.GameMapsPage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MapController {
  
  private static final Logger LOG = LoggerFactory.getLogger(MapController.class);
  
  private final GameMapService gameMapService;
  private final BoardService boardService;
  private final MainLayout mainLayout;
  
  public MapController(GameMapService gameMapService, BoardService boardService, MainLayout mainLayout) {
    this.gameMapService = gameMapService;
    this.boardService = boardService;
    this.mainLayout = mainLayout;
  }
  
  public void index(@NotNull Context context) {
    LOG.info("index");
    Long mapId = context.queryParamAsClass("id", Long.class).getOrDefault(1L);
    GameMap map = gameMapService.find(mapId);
    List<Board> boards = boardService.list(mapId);
    GameMapsPage gameMapsPage = new GameMapsPage(map, boards); // dynamic content maybe
    context.html(mainLayout.layout(gameMapsPage).render());
  }
  
  public void find(@NotNull Context context) {
    LOG.info("find");
    Long mapId = context.pathParamAsClass("mapId", Long.class).getOrDefault(1L);
    GameMap map = gameMapService.find(mapId);
    List<Board> boards = boardService.list(mapId);
    GameMapsPage gameMapsPage = new GameMapsPage(map, boards); // dynamic content maybe
    context.html(gameMapsPage.content().render());
  }
}
