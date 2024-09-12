package io.sombriks.templates.pages;

import io.sombriks.models.Board;
import io.sombriks.models.GameMap;
import io.sombriks.templates.Page;
import io.sombriks.templates.components.BoardItem;
import io.sombriks.templates.components.NewBoardItem;
import j2html.tags.DomContent;

import java.util.List;

import static j2html.TagCreator.*;

public class GameMapsPage implements Page {
  
  private final GameMap map;
  private final List<Board> boards;
  
  public GameMapsPage(GameMap map, List<Board> boards) {
    this.map = map;
    this.boards = boards;
  }
  
  @Override
  public String getTitle() {
    return "World Map";
  }
  
  @Override
  public DomContent content() {
    return join(
        h1(map.toString()),
        new NewBoardItem(map).content(),
        each(boards, (board -> new BoardItem(board).content())));
  }
}
