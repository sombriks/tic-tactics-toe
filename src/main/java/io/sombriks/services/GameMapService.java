package io.sombriks.services;

import io.sombriks.configs.Database;
import io.sombriks.models.GameMap;

public class GameMapService {
  
  private final Database database;
  
  public GameMapService(Database database) {
    this.database = database;
  }
  
  public GameMap find(Long mapId) {
    return database.jdbi
        .withHandle(handle -> handle
            .createQuery("select * from game_maps where id = :mapId")
            .bind("mapId", mapId)
            .mapTo(GameMap.class).one());
  }
}
