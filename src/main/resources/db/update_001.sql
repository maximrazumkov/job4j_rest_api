create table roles (
    id serial primary key,
    name varchar(50)
);

insert into roles (name) values ('user'), ('admin');

create table room (
    id serial primary key,
    name varchar(50)
);

insert into room (name) values ('green'), ('gray'), ('red');

create table person (
    id serial primary key,
    name varchar(50),
    role_id int not null references roles(id)
);

insert into person (name, role_id) values ('Mr. Good', 1), ('Adam777', 1), ('Admin', 2);

create table message (
    id serial primary key,
    description text,
    room_id int not null references room(id),
    person_id int not null references person(id)
);