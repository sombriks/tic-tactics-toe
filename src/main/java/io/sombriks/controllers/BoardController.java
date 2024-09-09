package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.BoardService;
import io.sombriks.templates.layouts.MainLayout;
import org.jetbrains.annotations.NotNull;

public class BoardController {

    private final BoardService boardService;
    private final MainLayout mainLayout;
    
    public BoardController(BoardService boardService, MainLayout mainLayout) {
        this.boardService = boardService;
        this.mainLayout = mainLayout;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
