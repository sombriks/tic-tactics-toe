package io.sombriks.templates.layouts;

import io.sombriks.templates.Page;
import j2html.tags.Renderable;

import static j2html.TagCreator.*;

public class MainLayout {
  public Renderable layout(Page page) {
    return html(
        head(
            meta().withCharset("UTF-8"),
            meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
            title("Tic Tactics Toe - " + page.getTitle()),
            script().withType("application/javascript").withSrc("/webjars/htmx.org/2.0.2/dist/htmx.js"),
            script().withType("application/javascript").withSrc("/webjars/vue/3.5.3/dist/vue.global.js"),
            script().withType("application/javascript").withSrc("/webjars/vueuse__core/10.9.0/index.iife.js"),
            script("htmx.logAll();").withType("application/javascript")
        ),
        body(
            main(
                attrs("#app"),
                page.content()
            ),
            script().withType("application/javascript").withSrc("/main-layout.js")
        )
    );
  }
}
