-- all boards dwell in a world map
create table if not exists maps
(
    id   identity primary key,
    name varchar(255) unique not null
);

create table if not exists boards
(
    id      identity primary key,
    maps_id integer not null references maps (id) on delete cascade
);

create table if not exists challenges
(
    id        identity primary key,
    boards_id integer not null references boards (id) on delete cascade
);

create table if not exists fights
(
    id            identity primary key,
    challenges_id integer not null references challenges (id) on delete cascade
);

create table if not exists moves
(
    id        identity primary key,
    fights_id integer not null references fights (id) on delete cascade
);

-- players may exist even without a map
create table if not exists players
(
    id identity primary key
);

create table if not exists decks
(
    id         identity primary key,
    players_id integer not null references players (id) on delete cascade
);

create table if not exists settings
(
    id         identity primary key,
    players_id integer not null references players (id) on delete cascade
);

create table if not exists card_types
(
    id identity primary key
);

-- and, of course, cards exists
create table if not exists cards
(
    id            identity primary key,
    players_id    integer not null references players (id) on delete cascade,
    card_types_id integer not null references card_types (id) on delete cascade
);
