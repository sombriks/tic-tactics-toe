package io.sombriks.configs;

import org.jdbi.v3.core.Jdbi;

public class Database {

    // TODO System.getEnv()
    public final Jdbi jdbi = Jdbi.create("jdbc:h2:./tictacticstoe");

    public Database() {
        jdbi.withHandle(handle -> handle.execute("""
                select 1 + 1 -- create tables here
            """));
    }
}
