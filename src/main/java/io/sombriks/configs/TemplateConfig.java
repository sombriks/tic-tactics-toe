package io.sombriks.configs;

import de.neuland.pug4j.PugConfiguration;
import de.neuland.pug4j.template.ClasspathTemplateLoader;
import de.neuland.pug4j.template.PugTemplate;
import io.javalin.config.JavalinConfig;

import java.io.IOException;
import java.util.Map;

// https://javalin.io/documentation#views-and-templates
// https://github.com/neuland/pug4j?tab=readme-ov-file#full-api
public class TemplateConfig {

    private final PugConfiguration pugConfig = new PugConfiguration();

    public void configure(JavalinConfig javalinConfig) {
        javalinConfig.fileRenderer((filePath, model, context) -> {
            try {
                PugTemplate template = pugConfig.getTemplate(filePath);
                return pugConfig.renderTemplate(template, (Map<String, Object>) model);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pugConfig.setPrettyPrint(true);
        pugConfig.setTemplateLoader(new ClasspathTemplateLoader("templates"));
    }

}
