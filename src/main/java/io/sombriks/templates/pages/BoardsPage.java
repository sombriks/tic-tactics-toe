package io.sombriks.templates.pages;

import io.sombriks.templates.Page;
import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class BoardsPage implements Page {
  @Override
  public String getTitle() {
    return "Board";
  }
  
  @Override
  public DomContent content() {
    return join(
        h1("Board"),
        table());
  }
}
