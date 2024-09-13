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
    return join(
        h1(board.toString()));
  }
}
