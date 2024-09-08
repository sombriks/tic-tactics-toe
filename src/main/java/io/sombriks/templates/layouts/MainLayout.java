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
            script("htmx.logAll();").withType("application/javascript")
        ),
        body(
            main(
                attrs("#app"),
                page.content(),
                section("{{message}}")
            ),
            script("""
                  // TODO see what happens when htmx starts to change the document
                  const { createApp, ref } = Vue
                  createApp({
                    setup() {
                      const message = ref('Hello vue!')
                      return {
                        message
                      }
                    }
                  }).mount('#app')
                """).withType("application/javascript")
        )
    );
  }
}
