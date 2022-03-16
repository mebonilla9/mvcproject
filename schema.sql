/**
 * Author:  dev_manuel
 * Created: 15 mar. 2022
 */

create table person
(
    id       serial primary key,
    name     character varying(60) not null,
    document character varying(11) not null unique,
    state    int                   not null
);