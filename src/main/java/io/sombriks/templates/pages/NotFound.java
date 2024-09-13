package io.sombriks.templates.pages;

import io.sombriks.templates.Page;
import j2html.tags.DomContent;

import static j2html.TagCreator.h1;

public class NotFound implements Page {
  
  private final String message;
  
  public NotFound(String message) {
    this.message = message;
  }
  
  @Override
  public String getTitle() {
    return "Not found";
  }
  
  @Override
  public DomContent content() {
    return h1(message);
  }
}
