package io.sombriks;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class TictacticstoeMain {

    final Javalin server = Javalin.create(config -> {
        config.router.apiBuilder(() -> {
            get("/status", ctx -> ctx.result("ONLINE"));
        });
    });

    public String getMessage() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        new TictacticstoeMain().server.start(7070);
    }
}