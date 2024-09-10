package io.sombriks.models;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public record GameMap(Long id, String name) {
  public static class Mapper implements RowMapper<GameMap> {
    @Override
    public GameMap map(ResultSet rs, StatementContext ctx) throws SQLException {
      return new GameMap(rs.getLong("id"), rs.getString("name"));
    }
  }
}
