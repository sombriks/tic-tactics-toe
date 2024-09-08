package io.sombriks.templates;

import j2html.tags.DomContent;

/**
 * contract on what a page should offer to layouts
 */
public interface Page {
    String getTitle();
    DomContent content();
}
