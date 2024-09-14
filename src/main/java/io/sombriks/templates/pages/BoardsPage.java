package io.sombriks.templates.pages;

import io.sombriks.models.Board;
import io.sombriks.templates.Page;
import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class BoardsPage implements Page {
  
  private final Board board;
  
  public BoardsPage(Board board) {
    this.board = board;
  }
  
  @Override
  public String getTitle() {
    return "Board";
  }
  
  @Override
  public DomContent content() {
    return div(attrs(".board"),
        div(attrs(".item"), "1"),
        div(attrs(".item"), "2"),
        div(attrs(".item"), "3"),
        div(attrs(".item"), "4"),
        div(attrs(".item"), "5"),
        div(attrs(".item"), "6"),
        div(attrs(".item"), "7"),
        div(attrs(".item"), "8"),
        div(attrs(".item"), "9")
    );
  }
}
