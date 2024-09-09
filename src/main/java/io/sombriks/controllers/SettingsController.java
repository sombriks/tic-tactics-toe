package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.SettingsService;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.SettingsPage;
import org.jetbrains.annotations.NotNull;

public class SettingsController {

    private final SettingsService settingsService;
    private final MainLayout mainLayout;

    public SettingsController(SettingsService settingsService, MainLayout mainLayout) {
        this.settingsService = settingsService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
        SettingsPage settingsPage = new SettingsPage();
        context.html(mainLayout.layout(settingsPage).render());
    }
}
