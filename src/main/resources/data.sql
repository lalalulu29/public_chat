create table if not exists log
(
    id      int auto_increment,
    dated   datetime      not null,
    logger  varchar(50)   not null,
    level   varchar(10)   not null,
    message varchar(1000) not null,
    constraint LOG_PK
        primary key (id)
);

create table if not exists person
(
    id      int auto_increment,
    address varchar(100)  not null,
    login   varchar(1000) not null,
    date    datetime      not null,
    constraint USER_PK
        primary key (id)
);

create table if not exists message
(
    id   int auto_increment,
    person_id int not null,
    body varchar(10000) not null,
    date datetime       not null,

    constraint MESSAGE_PK
        primary key (id),
    constraint MESSAGE_PERSON_ID_FK
        foreign key (person_id) references person(id)
);



