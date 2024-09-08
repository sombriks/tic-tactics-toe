-- all boardws dwell in a world map
create table if not exists world_maps
(
    id integer not null primary key auto_increment
);

create table if not exists boards
(
    id integer not null primary key auto_increment,
    world_maps_id integer not null references world_maps(id) on delete cascade
);

create table if not exists challenges
(
    id integer not null primary key auto_increment,
    boards_id integer not null references boards(id) on delete cascade
);

create table if not exists fights
(
    id integer not null primary key auto_increment,
    challenges_id integer not null references challenges(id) on delete cascade
);

create table if not exists moves
(
    id integer not null primary key auto_increment,
    fights_id integer not null references fights(id) on delete cascade
);
