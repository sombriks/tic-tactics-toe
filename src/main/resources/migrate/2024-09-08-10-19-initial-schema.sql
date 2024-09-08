-- all boardws dwell in a world map
create table if not exists world_map
(
    id integer not null primary key auto_increment
);

create table if not exists board
(
    id integer not null primary key auto_increment,
    world_map_id integer not null references world_map(id)
);
