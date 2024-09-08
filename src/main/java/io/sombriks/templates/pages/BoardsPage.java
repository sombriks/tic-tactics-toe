package io.sombriks.templates.pages;

import io.sombriks.templates.Page;
import j2html.tags.DomContent;

import static j2html.TagCreator.h1;

public class BoardsPage implements Page {
  @Override
  public String getTitle() {
    return "Board";
  }
  
  @Override
  public DomContent content() {
    return h1("Board");
  }
}
