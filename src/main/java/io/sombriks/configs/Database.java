package io.sombriks.configs;

import io.sombriks.models.Board;
import io.sombriks.models.GameMap;
import io.sombriks.models.InsertedId;
import org.apache.commons.io.IOUtils;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Database {
  
  // TODO System.getEnv()
  public final Jdbi jdbi = Jdbi.create("jdbc:h2:./tictacticstoe");
  
  private final String CHANGES = """
      create table if not exists WE_GOING_THROUGH_CHANGES(
          id integer primary key auto_increment,
          created timestamp not null default current_timestamp,
          migrate text not null
      );
      """;
  
  private final String CHECK = """
      select count(*) > 0 as executed
      from WE_GOING_THROUGH_CHANGES
      where migrate = :migrate;
      """;
  
  private final String REGISTER = """
      insert into WE_GOING_THROUGH_CHANGES (migrate) values (:migrate);
      """;
  
  public Database() {
    jdbi.registerRowMapper(ConstructorMapper.factory(Board.class));
    jdbi.registerRowMapper(ConstructorMapper.factory(GameMap.class));
    jdbi.registerRowMapper(ConstructorMapper.factory(InsertedId.class));
    initDB();
  }
  
  private void initDB() {
    String[] migrates = {
        "/migrates/2024-09-08-10-19-initial-schema.sql",
        "/migrates/2024-09-10-12-01-initial-data.sql",
    };
    jdbi.withHandle(handle -> handle.execute(CHANGES));
    for (String migrate : migrates) {
      try {
        InputStream in = Database.class.getResourceAsStream(migrate);
        assert in != null;
        String sql = IOUtils.toString(in, StandardCharsets.UTF_8);
        boolean ran = jdbi.withHandle(handle -> handle.createQuery(CHECK)
            .bind("migrate", migrate).mapTo(Boolean.class).one());
        if (!ran) {
          jdbi.withHandle(handle -> handle.execute(sql));
          jdbi.withHandle(handle -> handle.createUpdate(REGISTER)
              .bind("migrate", migrate).execute());
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
