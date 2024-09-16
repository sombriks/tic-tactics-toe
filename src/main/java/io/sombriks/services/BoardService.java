package io.sombriks.services;

import io.sombriks.configs.Database;
import io.sombriks.models.Board;
import io.sombriks.models.InsertedId;
import org.jdbi.v3.core.statement.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BoardService {
  
  private static final Logger LOG = LoggerFactory.getLogger(BoardService.class);
  
  private final Database database;
  
  public BoardService(Database database) {
    this.database = database;
  }
  
  public List<Board> list(Long mapId) {
    return database.jdbi.withHandle(handle -> handle.createQuery("""
                select * from boards
                 where game_maps_id = :mapId
            """).bind("mapId", mapId)
        .mapTo(Board.class).list());
  }
  
  public Board find(Board board) {
    return database.jdbi.withHandle(handle -> handle.createQuery("""
                select * from boards
                 where id = :id and game_maps_id = :mapId
            """).bindMethods(board)
        .mapTo(Board.class).one());
  }
  
  public Long insert(Board board) {
    LOG.info("insert");
    return database.jdbi.withHandle(handle -> handle.createUpdate("""
             insert into boards (game_maps_id)
              values (:mapId)
            """).bind("mapId", board.mapId())
        .executeAndReturnGeneratedKeys("id")
        .mapTo(InsertedId.class).one().id());
  }
}
