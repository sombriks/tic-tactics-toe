-- some support basic data

insert into maps (name)
values ('The great one');

insert into players (uid, handle)
values ('aaaa', 'player 1'),
       ('bbbb', 'player 2');

insert into card_types (title, description, combat_power)
values ('the bush', 'simple, harmless bush sitting in the field', 1),
       ('peasant', 'humble worker trying to earn a life', 1),
       ('stray dog', 'has the wits to survive', 2),
       ('rolling stone', 'no one stays in the path of this rock', 3),
       ('soldier', 'guy who serves in the army', 5),
       ('catapult', 'throw thing at unadvised people', 8),
       ('the tower', 'watch tower to opress them all', 13),
       ('wizard', 'spells that can ruin with your day', 21),
       ('dragon', 'fire', 34),
       ('mystic knight', 'that OP character', 55),
       ('ancient evil', 'unspeakable evil', 89),
       ('bob', 'hi bob', 144);



insert into boards(maps_id, players_id)
values (1, 1);

insert into challenges(boards_id, players_id)
values (1, 2);

