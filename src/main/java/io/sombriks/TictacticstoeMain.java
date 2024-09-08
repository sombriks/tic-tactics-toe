package io.sombriks;

import io.javalin.Javalin;
import io.sombriks.configs.Database;
import io.sombriks.controllers.BoardController;
import io.sombriks.controllers.WorldMapController;
import io.sombriks.services.BoardService;
import io.sombriks.services.WorldMapService;

import static io.javalin.apibuilder.ApiBuilder.*;

public class TictacticstoeMain {

    private final Database database = new Database();

    private final WorldMapService worldMapService = new WorldMapService(database);
    private final BoardService boardService = new BoardService(database);

    private final WorldMapController worldMapController = new WorldMapController(worldMapService);
    private final BoardController boardController = new BoardController(boardService);

    final Javalin server = Javalin.create(config -> {
        config.router.apiBuilder(() -> {
            get("/status", ctx -> ctx.result("ONLINE"));
            path("/map", () -> {
                get(worldMapController::index);
                get("/{mapId}", worldMapController::find);
            });
            path("/board", () -> {
                get(boardController::index);
                get("/{boardId}", boardController::find);
                path("/{boardId}/challenge", () -> {
                    get("/{challengeId}", ctx -> ctx.result("ONLINE"));
                    path("/{challengeId}/match", () -> {
                        get("/{matchId}", ctx -> ctx.result("ONLINE"));
                    });
                });
            });
            get("/player/{playerId}", ctx -> ctx.result("ONLINE"));
            get("/deck", ctx -> ctx.result("ONLINE"));
            get("/settings", ctx -> ctx.result("ONLINE"));
        });
    });

    public static void main(String[] args) {
        // TODO System.getEnv()
        new TictacticstoeMain().server.start(7070);
    }
}
