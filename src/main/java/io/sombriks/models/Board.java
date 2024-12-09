package io.sombriks.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public record Board(Long id, @ColumnName("maps_id") Long mapId) {
}

