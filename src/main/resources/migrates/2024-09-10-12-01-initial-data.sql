-- some support basic data

insert into maps (name) values ('The great one');

insert into players (uid,handle) values ('aaaa', 'player 1');
insert into players (uid,handle) values ('bbbb', 'player 2');

insert into boards(naps_id, player_id) values (1,1);

insert into challenges(boards_id, player_id) values (1,2);
