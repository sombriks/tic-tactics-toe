package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.SettingsService;
import org.jetbrains.annotations.NotNull;

public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    public void index(@NotNull Context context) {
    }
}
