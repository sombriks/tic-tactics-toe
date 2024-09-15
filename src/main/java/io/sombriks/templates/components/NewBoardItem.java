package io.sombriks.templates.components;

import io.sombriks.models.GameMap;
import io.sombriks.templates.Component;
import j2html.tags.DomContent;

import static j2html.TagCreator.*;

public class NewBoardItem implements Component {
  
  private final GameMap map;
  
  public NewBoardItem(GameMap map) {
    this.map = map;
  }
  
  @Override
  public DomContent content() {
    return button(attrs(".board-item"), "+")
        .attr("hx-swap", "beforeend")
        .attr("hx-target", "closest div.map")
        .attr("hx-post", String.format("/maps/%d/boards", map.id()));
  }
}
