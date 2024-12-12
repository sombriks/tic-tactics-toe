-- all boards dwell in a world map
create table if not exists maps
(
    id      identity primary key,
    name    varchar(255) unique not null,
    created timestamp           not null default now(),
    updated timestamp                    default now()
);

-- players may exist even without a map
create table if not exists players
(
    id      identity primary key,
    uid     varchar(255) unique not null,
    handle  varchar(255) unique not null,
    email   varchar(255) unique,
    created timestamp           not null default now(),
    updated timestamp                    default now()
);

create table if not exists card_types
(
    id           identity primary key,
    title        varchar(255) not null,
    description  text         not null,
    combat_power integer      not null default 1,
    -- TODO side effects: reveal, on attack, on efend, etc
    created      timestamp    not null default now(),
    updated      timestamp             default now()
);

create table if not exists cards
(
    id                   identity primary key,
    current_combat_power integer   not null default 1,
    players_id           integer   not null references players (id) on delete cascade,
    card_types_id        integer   not null references card_types (id) on delete cascade,
    created              timestamp not null default now(),
    updated              timestamp          default now()
);

create table if not exists decks
(
    id          identity primary key,
    description text      not null,
    players_id  integer   not null references players (id) on delete cascade,
    cards_id    integer   not null references cards (id) on delete cascade,
    created     timestamp not null default now(),
    updated     timestamp          default now()
);

create table if not exists boards
(
    id         identity primary key,
    maps_id    integer   not null references maps (id) on delete cascade,
    players_id integer   not null references players (id) on delete cascade,
    created    timestamp not null default now(),
    updated    timestamp          default now()
);

create table if not exists challenges
(
    id         identity primary key,
    boards_id  integer   not null references boards (id) on delete cascade,
    -- the attacker id
    players_id integer   not null references players (id) on delete cascade,
    created    timestamp not null default now(),
    updated    timestamp          default now()
);

create table if not exists moves
(
    id            identity primary key,
    challenges_id integer   not null references challenges (id) on delete cascade,
    created       timestamp not null default now(),
    updated       timestamp          default now()
);

create table if not exists settings
(
    id         identity primary key,
    players_id integer   not null references players (id) on delete cascade,
    created    timestamp not null default now(),
    updated    timestamp          default now()
);

create table if not exists decks_cards
(
    decks_id integer   not null references decks (id) on delete cascade,
    cards_id integer   not null references cards (id) on delete cascade,
    created  timestamp not null default now(),
    updated  timestamp          default now(),
    primary key (decks_id, cards_id)
);

create table if not exists boards_cards
(
    boards_id integer   not null references boards (id) on delete cascade,
    cards_id  integer   not null references cards (id) on delete cascade,
    created   timestamp not null default now(),
    updated   timestamp          default now(),
    primary key (boards_id, cards_id)
);
