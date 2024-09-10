-- all boards dwell in a world map
create table if not exists game_maps
(
    id integer not null primary key auto_increment,
    name varchar(255) unique not null
);

create table if not exists boards
(
    id            integer not null primary key auto_increment,
    game_maps_id integer not null references game_maps (id) on delete cascade
);

create table if not exists challenges
(
    id        integer not null primary key auto_increment,
    boards_id integer not null references boards (id) on delete cascade
);

create table if not exists fights
(
    id            integer not null primary key auto_increment,
    challenges_id integer not null references challenges (id) on delete cascade
);

create table if not exists moves
(
    id        integer not null primary key auto_increment,
    fights_id integer not null references fights (id) on delete cascade
);

-- players may exist even without a map
create table if not exists players
(
    id integer not null primary key auto_increment
);

create table if not exists decks
(
    id integer not null primary key auto_increment,
    players_id integer not null references players (id) on delete cascade
);

create table if not exists settings
(
    id integer not null primary key auto_increment,
    players_id integer not null references players (id) on delete cascade
);

-- and, of course, cards exists
create table if not exists cards
(
    id integer not null primary key auto_increment
);
