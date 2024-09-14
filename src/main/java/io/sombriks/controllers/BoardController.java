package io.sombriks.controllers;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.sombriks.models.Board;
import io.sombriks.services.BoardService;
import io.sombriks.templates.components.BoardItem;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.BoardsPage;
import io.sombriks.templates.pages.NotFound;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardController {
  
  private static final Logger LOG = LoggerFactory.getLogger(BoardController.class);
  
  private final BoardService boardService;
  private final MainLayout mainLayout;
  
  public BoardController(BoardService boardService, MainLayout mainLayout) {
    this.boardService = boardService;
    this.mainLayout = mainLayout;
  }
  
  public void index(@NotNull Context context) {
    LOG.info("index");
    context.status(404).html(mainLayout.layout(new NotFound("Provide boardId")).render());
  }
  
  public void find(@NotNull Context context) {
    LOG.info("find");
    Long mapId = context.pathParamAsClass("mapId", Long.class).getOrDefault(1L);
    Long boardId = context.pathParamAsClass("boardId", Long.class).get();
    Board board = boardService.find(mapId, boardId);
    if ("true".equals(context.header("HX-Request"))) {
      context.html(new BoardItem(board).content().render());
    } else {
      context.html(mainLayout.layout(new BoardsPage(board)).render());
    }
  }
  
  public void insert(@NotNull Context context) {
    LOG.info("insert");
    Long mapId = context.pathParamAsClass("mapId", Long.class).getOrDefault(1L);
    Board board = new Board(null, mapId);
    Long id = boardService.insert(board);
    context.redirect("/maps/" + mapId + "/boards/" + id, HttpStatus.SEE_OTHER);
  }
}
