package io.sombriks.templates.pages;

import io.sombriks.models.GameMap;
import io.sombriks.templates.Page;
import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class MapsPage implements Page {
  
  private final GameMap map;
  
  public MapsPage(GameMap map) {
    this.map = map;
  }
  
  @Override
  public String getTitle() {
    return "World Map";
  }
  
  @Override
  public DomContent content() {
    return join(h1("Map #" + map.id()), table( // TODO each
        tr(
            td(
                "1"
            ),
            td(
                "2"
            ),
            td(
                "3"
            )
        )
    ));
  }
}
