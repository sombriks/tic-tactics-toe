package io.sombriks.controllers;

import io.javalin.http.Context;
import io.sombriks.services.BoardService;
import org.jetbrains.annotations.NotNull;

public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void index(@NotNull Context context) {
    }

    public void find(@NotNull Context context) {
    }
}
