package io.sombriks.configs;

import de.neuland.pug4j.template.TemplateLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ClasspathTemplateLoader implements TemplateLoader {
    @Override
    public long getLastModified(String name) throws IOException {
        return System.currentTimeMillis();
    }

    @Override
    public Reader getReader(String name) throws IOException {
        name = getBase() + name + getExtension();
        return new InputStreamReader(getClass().getResourceAsStream(name), StandardCharsets.UTF_8);
    }

    @Override
    public String getExtension() {
        return ".pug";
    }

    @Override
    public String getBase() {
        return "/templates/";
    }
}
