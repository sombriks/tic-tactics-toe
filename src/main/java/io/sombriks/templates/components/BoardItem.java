package io.sombriks.templates.components;

import io.sombriks.models.Board;
import io.sombriks.templates.Component;
import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class BoardItem implements Component {
  
  private final Board board;
  
  public BoardItem(Board board) {
    this.board = board;
  }
  
  @Override
  public DomContent content() {
    return div(attrs(".board-item"),
        a(board.toString())
            .withHref(String.format("/maps/%d/boards/%d", board.mapId(), board.id())));
  }
}
