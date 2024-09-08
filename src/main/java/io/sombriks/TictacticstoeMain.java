package io.sombriks;

import io.javalin.Javalin;
import io.sombriks.configs.Database;

import static io.javalin.apibuilder.ApiBuilder.*;

public class TictacticstoeMain {

    final Database database = new Database();

    final Javalin server = Javalin.create(config -> {
        config.router.apiBuilder(() -> {
            get("/status", ctx -> ctx.result("ONLINE"));
            get("/map", ctx -> ctx.result("ONLINE"));
            get("/board/{id}", ctx -> ctx.result("ONLINE"));
            get("/deck", ctx -> ctx.result("ONLINE"));
            get("/settings", ctx -> ctx.result("ONLINE"));
        });
    });

    public static void main(String[] args) {
        // TODO System.getEnv()
        new TictacticstoeMain().server.start(7070);
    }
}
