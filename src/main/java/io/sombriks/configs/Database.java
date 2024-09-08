package io.sombriks.configs;

import org.apache.commons.io.IOUtils;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Database {

    // TODO System.getEnv()
    public final Jdbi jdbi = Jdbi.create("jdbc:h2:./tictacticstoe");

    public Database() {
        String resources[] = {
          "/migrate/2024-09-08-10-19-initial-schema.sql"
        };
        for(String resource: resources) {
            try {
                InputStream in = Database.class.getResourceAsStream(resource);
                assert in != null;
                String sql = IOUtils.toString(in, StandardCharsets.UTF_8);
                jdbi.withHandle(handle -> handle.execute(sql));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
