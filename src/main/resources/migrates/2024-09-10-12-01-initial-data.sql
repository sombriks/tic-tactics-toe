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

-- player 1 cards

insert into cards (players_id,card_types_id,status,current_combat_power)
values (1,1,'ready',1),
       (1,2,'ready',1),
       (1,3,'ready',2),
       (1,3,'ready',2),
       (1,3,'ready',2),
       (1,4,'ready',3),
       (1,3,'ready',2),
       (1,5,'ready',5),
       (1,5,'ready',5),
       (1,5,'ready',5),
       (1,6,'ready',8),
       (1,7,'ready',13),
       (1,3,'ready',2),
       (1,3,'ready',2),
       (1,4,'ready',3),
       (1,4,'ready',3),
       (1,3,'ready',2),
       (1,1,'ready',1);

-- player 2 cards

insert into cards (players_id,card_types_id,status,current_combat_power)
values (2,1, 'ready',1),
       (2,2, 'ready',1),
       (2,3, 'ready',2),
       (2,3, 'ready',2),
       (2,3, 'ready',2),
       (2,4, 'ready',3),
       (2,3, 'ready',2),
       (2,5, 'ready',5),
       (2,5, 'ready',5),
       (2,5, 'ready',5),
       (2,6, 'ready',8),
       (2,7, 'ready',13),
       (2,3, 'ready',2),
       (2,3, 'ready',2),
       (2,4, 'ready',3),
       (2,4, 'ready',3),
       (2,3, 'ready',2),
       (2,1, 'ready',1);

insert into boards(maps_id, players_id)
values (1, 1);

-- 9 defender cards in a board
insert into boards_cards (boards_id, cards_id)
values (1,1),
       (1,3),
       (1,5),
       (1,7),
       (1,9),
       (1,11),
       (1,2),
       (1,4),
       (1,6);

insert into challenges(boards_id, players_id)
values (1, 2);

-- 9 attacker card in a challenge
insert into challenges_cards (challenges_id, cards_id)
values (1,18),
       (1,16),
       (1,14),
       (1,1),
       (1,2),
       (1,3),
       (1,17),
       (1,7),
       (1,9);
