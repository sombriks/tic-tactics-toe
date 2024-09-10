package io.sombriks.services;

import io.sombriks.configs.Database;
import io.sombriks.models.GameMap;

public class MapService {
  
  private final Database database;
  
  public MapService(Database database) {
    this.database = database;
  }
  
  public GameMap find(Long mapId) {
    return database.jdbi
        .withHandle(handle -> handle
            .createQuery("select * from world_maps where id = :mapId")
            .bind("mapId", mapId)
            .mapTo(GameMap.class).one());
  }
}
